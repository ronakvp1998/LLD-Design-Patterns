package com.lldproblems.movieticketbookingsystem.strategy.payment;

import com.lldproblems.movieticketbookingsystem.entities.Payment;

public interface PaymentStrategy {
    Payment pay(double amount);
}
