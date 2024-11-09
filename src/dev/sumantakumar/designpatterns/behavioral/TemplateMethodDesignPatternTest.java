package dev.sumantakumar.designpatterns.behavioral;

public class TemplateMethodDesignPatternTest {
    public static void main(String[] args) {
        PaymentProcessor creditCardProcessor = new CreditCardPaymentProcessor(1_00_000.00);
        creditCardProcessor.processPaymentTemplateMethod(20_000.00);

        PaymentProcessor debitCardProcessor = new DebitCardPaymentProcessor(5_00_000.00);
        debitCardProcessor.processPaymentTemplateMethod(1_00_000.00);

    }
}

abstract class PaymentProcessor{

    public final void processPaymentTemplateMethod(double amount){
        validatePaymentDetails();
        processTransaction(amount);
        sendNotification();

    }

    abstract void validatePaymentDetails();
    abstract void processTransaction(double amount);

    public void sendNotification(){
        System.out.println("Your transaction has been successfully processed!");
    }

}

class CreditCardPaymentProcessor extends PaymentProcessor{
    double availableLimit;
    public CreditCardPaymentProcessor(double availableLimit){
        this.availableLimit = availableLimit;
    }

    @Override
    void validatePaymentDetails() {
        System.out.println("Your credit card details has been validated!");
    }

    @Override
    void processTransaction(double amount) {
        System.out.println("Your payment of Rs. "+amount+" has been received successfully. Available limit is "+(availableLimit-amount));

    }
}


class DebitCardPaymentProcessor extends PaymentProcessor{

    double availableBalance;
    public DebitCardPaymentProcessor(double availableBalance){
        this.availableBalance = availableBalance;
    }

    @Override
    void validatePaymentDetails() {
        System.out.println("Your debit card details has been validated!");
    }

    @Override
    void processTransaction(double amount) {
        System.out.println("Your payment of Rs. "+amount+" has been received successfully. Available limit is "+(availableBalance-amount));
    }
}
