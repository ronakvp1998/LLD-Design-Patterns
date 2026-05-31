package com.ashishprataplldproblems.movieticketbookingsystem.strategy.payment;

import com.ashishprataplldproblems.movieticketbookingsystem.entities.Payment;

public interface PaymentStrategy {
    Payment pay(double amount);
}
