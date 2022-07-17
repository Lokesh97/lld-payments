package com.payment.strategy.routing_strategy;

import com.payment.model.pg.AbstractPaymentGateway;

import java.util.List;

public interface IRoutingStrategy {
    public AbstractPaymentGateway selectPaymentGateway(List<AbstractPaymentGateway> paymentGatewayList);
}
