package com.payment.model.payment_request;

import com.payment.model.PayMethod;

public class UPIPaymentRequest extends AbstractPaymentRequest{

    private String vpa;

    public UPIPaymentRequest(String vpa, String receiverAccount, String clientName) {
       super(receiverAccount, clientName);
       this.vpa = vpa;
       this.payMethod = PayMethod.UPI;
    }
}
