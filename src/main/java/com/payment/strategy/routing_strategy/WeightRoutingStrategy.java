package com.payment.strategy.routing_strategy;

import com.payment.model.pg.AbstractPaymentGateway;

import java.util.List;

public class WeightRoutingStrategy implements IRoutingStrategy{
    @Override
    public AbstractPaymentGateway selectPaymentGateway(List<AbstractPaymentGateway> paymentGatewayList) {
        return null;
    }
}
