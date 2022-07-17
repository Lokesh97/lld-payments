package com.payment.model.payment_request;

import com.payment.model.PayMethod;

import java.util.UUID;

public abstract class AbstractPaymentRequest {
    public String id;
    public String receiverAccount;

    private String clientName;
    public PayMethod payMethod;
    public AbstractPaymentRequest(String receiverAccount, String clientName) {
        this.id = UUID.randomUUID().toString();
        this.receiverAccount = receiverAccount;
        this.clientName = clientName;
    }

    public String getId() {
        return id;
    }

    public PayMethod getPayMethod() {
        return payMethod;
    }

    public String getClientName() {
        return clientName;
    }
}
