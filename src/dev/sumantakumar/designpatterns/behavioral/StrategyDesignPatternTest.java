package dev.sumantakumar.designpatterns.behavioral;

public class StrategyDesignPatternTest {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setPaymentStrategy(new CreditCardPaymentStrategy("1234-1111-5555-6666"));
        shoppingCart.checkout(20_000.00);


        ShoppingCart shoppingCart2 = new ShoppingCart();
        shoppingCart2.setPaymentStrategy(new DebitCardPaymentStrategy("1234-1111-5555-6789"));
        shoppingCart2.checkout(45_000.00);

        ShoppingCart shoppingCart3 = new ShoppingCart();
        shoppingCart3.setPaymentStrategy(new InternetBankPaymentStrategy());
        shoppingCart3.checkout(30_000.00);


    }
}


interface PaymentStrategy{
    void pay(double amount);
}

class CreditCardPaymentStrategy implements PaymentStrategy{
    public String creditCardNumber;

    public CreditCardPaymentStrategy(String creditCardNumber){
        this.creditCardNumber = creditCardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Rs. "+amount+" paid by Credit Card Number XXXX-XXXX-XXXX-"+(creditCardNumber.substring(creditCardNumber.length()-4)));
    }
}

class DebitCardPaymentStrategy implements PaymentStrategy{
    public String debitCardNumber;
    public DebitCardPaymentStrategy(String debitCardNumber){
        this.debitCardNumber = debitCardNumber;
    }
    @Override
    public void pay(double amount) {
        System.out.println("Rs. "+amount+" paid by Debit Card Number XXXX-XXXX-XXXX-"+(debitCardNumber.substring(debitCardNumber.length()-4)));
    }
}

class InternetBankPaymentStrategy implements PaymentStrategy{

    @Override
    public void pay(double amount) {
        System.out.println("Rs. "+amount+" paid by Internet Banking.");
    }
}


class ShoppingCart{
    public PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(double amount){
        if(paymentStrategy == null){
            throw new IllegalArgumentException("Payment strategy not set");
        }
        paymentStrategy.pay(amount);
    }


}