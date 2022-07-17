package com.payment.model.pg;

import com.payment.model.PayMethod;
import com.payment.model.payment_request.AbstractPaymentRequest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class AbstractPaymentGateway {
    public String name;
    public Double weight;
    public Integer successCount, failedCount;

    private Set<PayMethod> payMethods;
    public AbstractPaymentGateway(Double weight, String name) {
        this.weight = weight;
        this.successCount = 0;
        this.failedCount = 0;
        this.payMethods = new HashSet<>();
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getSuccessCount() {
        return successCount;
    }

    public void setSuccessCount(Integer successCount) {
        this.successCount = successCount;
    }

    public Integer getFailedCount() {
        return failedCount;
    }

    public void setFailedCount(Integer failedCount) {
        this.failedCount = failedCount;
    }

    public abstract boolean makePayment(AbstractPaymentRequest abstractPaymentRequest);

    public void addPayMethod(PayMethod payMethod){
        this.payMethods.add(payMethod);
    }
    public boolean payMethodSupported(PayMethod payMethod){
        return this.payMethods.contains(payMethod);
    }
}
