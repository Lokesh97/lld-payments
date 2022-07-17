package com.payment.model.payment_request;

import com.payment.model.PayMethod;

public class NBPaymentRequest extends AbstractPaymentRequest{

    private String username, password;

    public NBPaymentRequest(String username, String password, String receiverAccount, String clientName) {
        super(receiverAccount, clientName);
        this.username = username;
        this.password = password;
        this.payMethod = PayMethod.NB;
    }
}

