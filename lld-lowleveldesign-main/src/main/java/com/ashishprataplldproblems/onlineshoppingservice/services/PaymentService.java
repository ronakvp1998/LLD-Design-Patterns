package com.ashishprataplldproblems.onlineshoppingservice.services;

import com.ashishprataplldproblems.onlineshoppingservice.strategy.PaymentStrategy;

public class PaymentService {
    public boolean processPayment(PaymentStrategy strategy, double amount) {
        return strategy.pay(amount);
    }
}
