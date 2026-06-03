package com.ashishprataplldproblems.hard.onlineshoppingservice.services;

import com.ashishprataplldproblems.hard.onlineshoppingservice.strategy.PaymentStrategy;

public class PaymentService {
    public boolean processPayment(PaymentStrategy strategy, double amount) {
        return strategy.pay(amount);
    }
}
