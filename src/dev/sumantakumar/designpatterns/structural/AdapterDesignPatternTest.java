package dev.sumantakumar.designpatterns.structural;

import java.time.LocalDate;

public class AdapterDesignPatternTest {
    public static void main(String[] args) {
        PaymentProcessor payPalPaymentProcessor = new PayPalPaymentAdapter(new PayPalPayment());
        payPalPaymentProcessor.pay(1_00_000, "PP201", "Sumanta Kumar Sahoo", LocalDate.now(), "myvpaid@bank");

        PaymentProcessor paytmPaymentProcessor = new PaytmPaymentAdapter(new PaytmPayment());
        paytmPaymentProcessor.pay(2_00_000, "PT405", "Sumair Sumair", LocalDate.now(), "4045-XXXX-XXXX-0012");

    }
}


interface PaymentProcessor{
    void pay(int amount, String paymentId, String payerName, LocalDate paymentDate, String sourceId);
}

class PayPalPayment{
    void makePayment(int amount, String paymentId, String payerName, LocalDate paymentDate, String sourceId){
        System.out.println("PayPal Payment of " + amount + " made by " + payerName + " on " + paymentDate + ". Payment ID: " + paymentId+". Source ID: " + sourceId);
    }
}
class PayPalPaymentAdapter implements PaymentProcessor{
    private final PayPalPayment payPalPayment;
    public PayPalPaymentAdapter(PayPalPayment payPalPayment){
        this.payPalPayment = payPalPayment;
    }


    @Override
    public void pay(int amount, String paymentId, String payerName, LocalDate paymentDate, String sourceId) {
        payPalPayment.makePayment(amount, paymentId, payerName, paymentDate, sourceId);
    }
}

class PaytmPayment{
    void processPayment(String paymentId, String sourceId, LocalDate paymentDate, int amount, String payerName){
        System.out.println("Paytm Payment of " + amount + " made by " + payerName + " on " + paymentDate + ". Payment ID: " + paymentId+". Source ID: " + sourceId);
    }
}

class PaytmPaymentAdapter implements PaymentProcessor{
    private final PaytmPayment paytmPayment;
    public PaytmPaymentAdapter(PaytmPayment paytmPayment){
        this.paytmPayment = paytmPayment;
    }

    @Override
    public void pay(int amount, String paymentId, String payerName, LocalDate paymentDate, String sourceId) {
        paytmPayment.processPayment(paymentId, sourceId, paymentDate, amount, payerName);
    }
}
