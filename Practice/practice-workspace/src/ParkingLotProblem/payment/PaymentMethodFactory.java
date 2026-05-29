package ParkingLotProblem.payment;

public class PaymentMethodFactory {


    public static PaymentMethod getPaymentMethod(String type,String name,String card){
        if(type != null && type.equalsIgnoreCase("creditcard")){
            return new CreditCardPayment(name,card);
        }
        return new CashPayment();
    }
    public static PaymentMethod getPaymentMethod(String type) {
        // Default to cash
        return new CashPayment();
    }
}
