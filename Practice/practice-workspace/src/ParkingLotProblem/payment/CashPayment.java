package ParkingLotProblem.payment;

import java.math.BigDecimal;

public class CashPayment implements PaymentMethod {
    @Override
    public boolean processPayment(BigDecimal amount) {
        System.out.println("Processing cash payment of $" + amount);
        // Add actual payment processing logic here
        return true;
    }
}