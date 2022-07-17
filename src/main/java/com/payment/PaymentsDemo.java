package com.payment;

import com.payment.controller.PaymentController;
import com.payment.database.ClientManager;
import com.payment.model.PayMethod;
import com.payment.model.Router;
import com.payment.model.payment_request.CardPaymentRequest;
import com.payment.model.payment_request.UPIPaymentRequest;
import com.payment.model.pg.AbstractPaymentGateway;
import com.payment.model.pg.PG1;
import com.payment.model.pg.PG2;
import com.payment.strategy.routing_strategy.IRoutingStrategy;
import com.payment.strategy.routing_strategy.RandomRoutingStrategy;

public class PaymentsDemo {
    private ClientManager clientManager;
    private Router router;

    private PaymentController paymentController;

    public void setup(){
        this.clientManager = new ClientManager();
        IRoutingStrategy routingStrategy = new RandomRoutingStrategy();
        this.router = new Router(routingStrategy, clientManager);

        AbstractPaymentGateway pg1 = new PG1(.7);
        pg1.addPayMethod(PayMethod.UPI);

        AbstractPaymentGateway pg2 = new PG2(.3);
        pg2.addPayMethod(PayMethod.CARD);

        router.addPG(pg1);
        router.addPG(pg2);

        this.paymentController = new PaymentController(clientManager, router);
    }

    public void test(){
        this.setup();

        this.paymentController.addClient("c1");
        this.paymentController.addClient("c2");
        this.paymentController.addClient("c3");
        System.out.println();

        this.paymentController.hasClient("c1");
        this.paymentController.removeClient("c1");
        this.paymentController.hasClient("c1");
        System.out.println();

        this.paymentController.addSupportForPaymentMode("c2", PayMethod.UPI);
        this.paymentController.addSupportForPaymentMode("c2", PayMethod.CARD);
        this.paymentController.listSupportForPaymentMode("c2");

        this.paymentController.makePayment(new CardPaymentRequest(
                "123", "12", "234", "4321", "c2"));

        this.paymentController.makePayment(new UPIPaymentRequest("1","2", "c1"));
        this.paymentController.makePayment(new UPIPaymentRequest("1","2", "c3"));

        this.paymentController.addSupportForPaymentMode("c3", PayMethod.UPI);
        this.paymentController.makePayment(new UPIPaymentRequest("1","2", "c3"));
    }

}
