package dev.sumantakumar.designpatterns.creational;


public class AbstractFactoryDesignPatternTest {

    private PaymentProcessor paymentProcessor;
    private PaymentValidator paymentValidator;

    public AbstractFactoryDesignPatternTest(PaymentFactory factory) {
        this.paymentProcessor = factory.createPaymentProcessor();
        this.paymentValidator = factory.createPaymentValidator();
    }

    public void processPayment(int amount) {
        if(paymentValidator.validatePaymentDetails()){
            paymentProcessor.processPayment(amount);
        }
    }

    public static void main(String[] args) {
        PaymentFactory creditCardFactory = new CreditCardPaymentFactory();
        AbstractFactoryDesignPatternTest creditCardPayment = new AbstractFactoryDesignPatternTest(creditCardFactory);
        creditCardPayment.processPayment(1000);
        PaymentFactory payPalFactory = new PayPalPaymentFactory();
        AbstractFactoryDesignPatternTest payPalPayment = new AbstractFactoryDesignPatternTest(payPalFactory);
        payPalPayment.processPayment(2000);

    }
}
interface PaymentProcessor{

    void processPayment(double amount);

}

interface PaymentValidator{
    boolean validatePaymentDetails();
}

interface PaymentFactory{

    PaymentProcessor createPaymentProcessor();
    PaymentValidator createPaymentValidator();

}

class CreditCardPaymentFactory implements PaymentFactory{


    @Override
    public PaymentProcessor createPaymentProcessor() {
        return new CreditCardPaymentProcessor();
    }

    @Override
    public PaymentValidator createPaymentValidator() {
        return new CreditCardPaymentValidtor();
    }
}

class PayPalPaymentFactory implements PaymentFactory{

    @Override
    public PaymentProcessor createPaymentProcessor() {
        return new PayPalPaymentProcessor();
    }

    @Override
    public PaymentValidator createPaymentValidator() {
        return new PayPalPaymentValidator();
    }
}


class CreditCardPaymentProcessor implements PaymentProcessor{

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment for CreditCard Payment");
    }
}

class CreditCardPaymentValidtor implements PaymentValidator{

    @Override
    public boolean validatePaymentDetails() {
        return true;
    }
}


class PayPalPaymentProcessor implements PaymentProcessor{

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment for PayPal Payment");

    }
}

class PayPalPaymentValidator implements PaymentValidator{

    @Override
    public boolean validatePaymentDetails() {
        return true;
    }
}