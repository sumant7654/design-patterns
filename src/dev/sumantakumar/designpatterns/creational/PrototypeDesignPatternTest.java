package dev.sumantakumar.designpatterns.creational;

public class PrototypeDesignPatternTest {
    public static void main(String[] args) {

        // Original Prototypes
        CreditCardPayment creditCardPayment = new CreditCardPayment("1234-1234-1234-1234", 1000.00);
        PayPalPayment payPalPayment = new PayPalPayment("test@test.com", 2000.00);

        // Cloning Prototypes
        CreditCardPayment clonedCreditCardPayment = (CreditCardPayment) creditCardPayment.clone();
        PayPalPayment clonedPayPalPayment = (PayPalPayment) payPalPayment.clone();


        // Displaying Clone Objects
        System.out.println(clonedCreditCardPayment);
        System.out.println(clonedPayPalPayment);


        // Modify cloned object if needed
        clonedCreditCardPayment = new CreditCardPayment("2222-3333-4444-5555", 6000.00);
        clonedPayPalPayment = new PayPalPayment("example@exmple.com", 8000.00);


        // Displaying Modified cloned Objects
        System.out.println(clonedCreditCardPayment);
        System.out.println(clonedPayPalPayment);


    }
}


interface PaymentPrototype extends Cloneable {
    PaymentPrototype clone();
}

class CreditCardPayment implements PaymentPrototype {

    private String cardNumber;
    private double amount;

    public CreditCardPayment(String cardNumber, double amount) {
        this.cardNumber = cardNumber;
        this.amount = amount;
    }


    @Override
    public PaymentPrototype clone() {
        return new CreditCardPayment(cardNumber, amount);
    }

    @Override
    public String toString() {
        return "CreditCardPayment{" +
                "cardNumber='" + cardNumber + '\'' +
                ", amount=" + amount +
                '}';
    }
}

class PayPalPayment implements PaymentPrototype {
    private String email;
    private double amount;
    public PayPalPayment(String email, double amount) {
        this.email = email;
        this.amount = amount;
    }


    @Override
    public PaymentPrototype clone() {
        return new PayPalPayment(email, amount);
    }

    @Override
    public String toString() {
        return "PayPalPayment{" +
                "email='" + email + '\'' +
                ", amount=" + amount +
                '}';
    }
}



