package dev.sumantakumar.designpatterns.behavioral;

import java.util.Scanner;

public class ChainOfResponsibilityTest {
    Dispense rack2000;
    public ChainOfResponsibilityTest() {
        this.rack2000 = new Notes2000Rack();
        Dispense rack500 = new Notes500Rack();
        Dispense rack100 = new Notes100Rack();
        rack2000.chain(rack500);
        rack500.chain(rack100);
    }
    public static void main(String[] args) {
        ChainOfResponsibilityTest test = new ChainOfResponsibilityTest();
        System.out.println("Please Enter the Amount to withdraw.....");
        Scanner sc = new Scanner(System.in);
        int amount = sc.nextInt();
        if(amount < 100){
            System.out.println("Amount must be greater than or equals to 100");
        }else if(amount % 100 != 0){
            System.out.println("Amount must be multiply of 100");
        }else {
            test.rack2000.dispense(new Currency(amount));
        }

    }
}


class Notes2000Rack implements Dispense{
    Dispense dispense;
    @Override
    public void dispense(Currency currency) {
        int noOfNotes = currency.getAmount() / 2000;
        if(noOfNotes > 0){
            System.out.println("Dispensing "+noOfNotes+" 2000 notes");
        }
        int reminder = currency.getAmount() % 2000;
        if(reminder != 0){
            dispense.dispense(new Currency(reminder));
        }
    }

    @Override
    public void chain(Dispense dispense) {
        this.dispense = dispense;
    }
}

class Notes500Rack implements Dispense{
    Dispense dispense;
    @Override
    public void dispense(Currency currency) {
        int noOfNotes = currency.getAmount() / 500;
        if(noOfNotes > 0){
            System.out.println("Dispensing "+noOfNotes+" 500 notes");
        }
        int reminder = currency.getAmount() % 500;
        if(reminder != 0){
            dispense.dispense(new Currency(reminder));
        }
    }

    @Override
    public void chain(Dispense dispense) {
        this.dispense = dispense;
    }
}

class Notes100Rack implements Dispense{
    Dispense dispense;
    @Override
    public void dispense(Currency currency) {
        int noOfNotes = currency.getAmount() / 100;
        if(noOfNotes > 0){
            System.out.println("Dispensing "+noOfNotes+" 100 notes");
        }
        int reminder = currency.getAmount() % 100;
        if(reminder != 0){
            dispense.dispense(new Currency(reminder));
        }
    }

    @Override
    public void chain(Dispense dispense) {
        this.dispense = dispense;
    }
}


interface Dispense{
    void dispense(Currency currency);
    void chain(Dispense dispense);
}
class Currency{
    int amount;

    public Currency(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

}
