package com.lldproblems.parkinglotproblem.payment;

public class PaymentMethodFactory {

    public static PaymentMethod getPaymentMethod(String type, String nameOnCard, String cardNumber) {
        if (type != null && type.equalsIgnoreCase("creditcard")) {
            return new CreditCardPayment(nameOnCard, cardNumber);
        }
        // Default to cash
        return new CashPayment();
    }

    public static PaymentMethod getPaymentMethod(String type) {
        // Default to cash
        return new CashPayment();
    }
}
