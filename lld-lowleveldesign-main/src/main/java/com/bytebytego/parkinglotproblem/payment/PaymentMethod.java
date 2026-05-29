package com.bytebytego.parkinglotproblem.payment;

import java.math.BigDecimal;

public interface PaymentMethod {
    boolean processPayment(BigDecimal amount);
}
