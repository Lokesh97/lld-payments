package com.payment.model;

import java.util.*;

public class Client {
    public String id;
    public String name;
    public Set<PayMethod> supportedPayMethods;

    public Client(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.supportedPayMethods = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public String getSupportedPayMethods() {
        String payMethodString = "";
        for (PayMethod payMethod: supportedPayMethods){
            payMethodString = payMethodString + payMethod.toString();
        }

        return payMethodString;
    }

    public boolean hasPayMethod(PayMethod payMethod){
        return this.supportedPayMethods.contains(payMethod);
    }

    public boolean addPayMethod(PayMethod payMethod){
        return this.supportedPayMethods.add(payMethod);
    }

    public boolean removePayMethod(PayMethod payMethod){
        return this.supportedPayMethods.remove(payMethod);
    }
}
