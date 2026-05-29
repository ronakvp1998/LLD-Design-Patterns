package com.bytebytego.parkinglotproblem.payment;

import java.math.BigDecimal;

public class CreditCardPayment implements PaymentMethod {
    private final String nameOnCard;
    private final String cardNumber;

    public CreditCardPayment(String nameOnCard, String cardNumber) {
        this.nameOnCard = nameOnCard;
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean processPayment(BigDecimal amount) {
        System.out.println("Processing credit card payment of $" + amount + " for " + nameOnCard);
        // Add actual payment processing logic here
        return true;
    }
}
