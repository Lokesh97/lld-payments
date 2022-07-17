package com.payment.model;

import com.payment.database.ClientManager;
import com.payment.exception.PayMethodNotSupportedForClientException;
import com.payment.model.payment_request.AbstractPaymentRequest;
import com.payment.model.pg.AbstractPaymentGateway;
import com.payment.strategy.routing_strategy.IRoutingStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Router {
    private IRoutingStrategy routingStrategy;
    private ClientManager clientManager;
    private HashSet<AbstractPaymentGateway> paymentGateways;

    public Router(IRoutingStrategy routingStrategy, ClientManager clientManager) {
        this.routingStrategy = routingStrategy;
        this.clientManager = clientManager;
        this.paymentGateways = new HashSet<>();
    }

    public List<AbstractPaymentGateway> getSupportedPGs(PayMethod payMethod){
        List<AbstractPaymentGateway> paymentGatewayList = new ArrayList<>();
        for (AbstractPaymentGateway paymentGateway: paymentGateways){
            if(paymentGateway.payMethodSupported(payMethod)){
                paymentGatewayList.add(paymentGateway);
            }
        }

        return paymentGatewayList;
    }

    public AbstractPaymentGateway choosePG(List<AbstractPaymentGateway> paymentGatewayList){
        return this.routingStrategy.selectPaymentGateway(paymentGatewayList);
    }

    public void addPG(AbstractPaymentGateway paymentGateway){
        this.paymentGateways.add(paymentGateway);
    }

    public boolean routePayment(AbstractPaymentRequest paymentRequest){
        try {
            Client client = clientManager.getClient(paymentRequest.getClientName());
            if(!client.hasPayMethod(paymentRequest.getPayMethod())){
                throw new PayMethodNotSupportedForClientException();
            }

            List<AbstractPaymentGateway> paymentGatewayList =
                    this.getSupportedPGs(paymentRequest.getPayMethod());

            AbstractPaymentGateway paymentGateway = this.choosePG(paymentGatewayList);
            return paymentGateway.makePayment(paymentRequest);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
}
