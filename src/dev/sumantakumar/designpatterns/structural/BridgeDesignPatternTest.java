package dev.sumantakumar.designpatterns.structural;


public class BridgeDesignPatternTest {
    public static void main(String[] args) {
        Payment payment = new BankPayment(new PaytmGateway());
        payment.makePayment(20_000.00);

        Payment payment2 = new CardPayment(new RazorPayGateway());
        payment2.makePayment(30_000.00);
    }
}

interface PaymentGateway {
    void processPayment(double amount);
}

class PaytmGateway implements PaymentGateway {

    @Override
    public void processPayment(double amount) {
        System.out.println("Payment of Rs. "+amount+ " is processing using PaytmGateway");
    }
}


class RazorPayGateway implements PaymentGateway {

    @Override
    public void processPayment(double amount) {
        System.out.println("Payment of Rs. "+amount+ " is processing using RazorPayGateway");
    }
}

abstract class Payment{
    public PaymentGateway paymentGateway;
    public Payment(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }
    public abstract void makePayment(double amount);

}

class BankPayment extends Payment{
    public BankPayment(PaymentGateway paymentGateway) {
        super(paymentGateway);
    }

    @Override
    public void makePayment(double amount) {
        System.out.println("Bank Payment Initializing.....");
        paymentGateway.processPayment(amount);
    }
}

class CardPayment extends Payment{
    public CardPayment(PaymentGateway paymentGateway) {
        super(paymentGateway);
    }

    @Override
    public void makePayment(double amount) {
        System.out.println("Card Payment Initializing.....");
        paymentGateway.processPayment(amount);
    }

}