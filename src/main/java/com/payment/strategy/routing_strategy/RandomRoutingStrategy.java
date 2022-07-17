package com.payment.strategy.routing_strategy;

import com.payment.model.pg.AbstractPaymentGateway;

import java.util.List;

public class RandomRoutingStrategy implements IRoutingStrategy{
    @Override
    public AbstractPaymentGateway selectPaymentGateway(List<AbstractPaymentGateway> paymentGatewayList) {
        int ind = (int) (Math.random() * (paymentGatewayList.size()));

        return paymentGatewayList.get(ind);
    }
}
