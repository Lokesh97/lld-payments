package com.payment.model.payment_request;

import com.payment.model.PayMethod;

public class CardPaymentRequest extends AbstractPaymentRequest{

    private String cardNumber, expiry, cvv;

    public CardPaymentRequest(String cardNumber, String expiry, String cvv,
                              String receiverAccount, String clientName) {
        super(receiverAccount, clientName);
        this.cardNumber = cardNumber;
        this.expiry = expiry;
        this.cvv = cvv;
        this.payMethod = PayMethod.CARD;
    }
}
