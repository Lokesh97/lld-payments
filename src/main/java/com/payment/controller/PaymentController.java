package com.payment.controller;

import com.payment.database.ClientManager;
import com.payment.model.Client;
import com.payment.model.OutputPrinter;
import com.payment.model.PayMethod;
import com.payment.model.Router;
import com.payment.model.payment_request.AbstractPaymentRequest;

public class PaymentController {
    private ClientManager clientManager;
    private Router router;
    private OutputPrinter outputPrinter;

    public PaymentController(ClientManager clientManager, Router router) {
        this.clientManager = clientManager;
        this.router = router;
        this.outputPrinter = new OutputPrinter();
    }

    public void addClient(String name) {
        try {
            this.clientManager.addClient(name);
            this.outputPrinter.success();
        } catch (Exception ex) {
            ex.printStackTrace();
            this.outputPrinter.failure();
        }
    }

    public void removeClient(String name) {
        try {
            this.clientManager.removeClient(name);
            this.outputPrinter.success();
        } catch (Exception ex) {
            ex.printStackTrace();
            this.outputPrinter.failure();
        }
    }

    public void hasClient(String name) {
        try {
            if (this.clientManager.hasClient(name)) {
                this.outputPrinter.printMsg("YES!!");
            } else {
                this.outputPrinter.printMsg("NO!!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            this.outputPrinter.failure();
        }
    }

    public void addSupportForPaymentMode(String name, PayMethod payMethod) {
        try {
            Client client = this.clientManager.getClient(name);
            client.addPayMethod(payMethod);
        } catch (Exception ex) {
            ex.printStackTrace();
            this.outputPrinter.failure();
        }
    }

    public void listSupportForPaymentMode(String name) {
        try {
            Client client = this.clientManager.getClient(name);
            this.outputPrinter.printMsg(client.getSupportedPayMethods());
        } catch (Exception ex) {
            ex.printStackTrace();
            this.outputPrinter.failure();
        }
    }

    public void makePayment(AbstractPaymentRequest paymentRequest) {
        this.outputPrinter.printMsg("payment -- ");
        try {
            if(this.router.routePayment(paymentRequest)){
                this.outputPrinter.success();
            } else {
                this.outputPrinter.failure();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            this.outputPrinter.failure();
        }
        this.outputPrinter.printMsg("done -- ");
    }
}
