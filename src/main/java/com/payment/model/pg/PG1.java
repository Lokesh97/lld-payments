package com.payment.model.pg;

import com.payment.model.PayMethod;
import com.payment.model.payment_request.AbstractPaymentRequest;

import java.util.List;
import java.util.Set;

public class PG1 extends AbstractPaymentGateway{

    public PG1(Double weight) {
        super(weight, "PG1");
    }

    @Override
    public boolean makePayment(AbstractPaymentRequest abstractPaymentRequest) {

        // PG specific logic
        System.out.println("Routing -- " + this.name);

        if(Math.random()<0.5){
            return true;
        }
        return false;
    }
}
