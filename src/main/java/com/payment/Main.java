package com.payment;

import com.payment.controller.PaymentController;
import com.payment.database.ClientManager;
import com.payment.model.Router;
import com.payment.model.pg.AbstractPaymentGateway;
import com.payment.model.pg.PG1;
import com.payment.model.pg.PG2;
import com.payment.strategy.routing_strategy.IRoutingStrategy;
import com.payment.strategy.routing_strategy.RandomRoutingStrategy;

public class Main {



    public static void main(String[] args) {

        PaymentsDemo paymentsDemo = new PaymentsDemo();
        paymentsDemo.test();

    }
}
