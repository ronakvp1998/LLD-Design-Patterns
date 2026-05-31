package com.bbglldprobelm.parkinglotproblem.payment;

import java.math.BigDecimal;

public interface PaymentMethod {
    boolean processPayment(BigDecimal amount);
}
