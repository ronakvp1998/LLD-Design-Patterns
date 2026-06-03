package com.ashishprataplldproblems.hard.movieticketbookingsystem.strategy.payment;

import com.ashishprataplldproblems.hard.movieticketbookingsystem.entities.Payment;

public interface PaymentStrategy {
    Payment pay(double amount);
}
