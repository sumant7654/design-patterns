package dev.sumantakumar.designpatterns.behavioral;


public class StateDesignPatternTest {
    public static void main(String[] args) {

        Context context = new Context();
        context.insert();
        context.dispense(10_000.00);
        System.out.println(context.getState().toString());


        context.insert();
        context.dispense(6_000.00);
        System.out.println(context.getState().toString());

        context.insert();
        context.eject();

    }
}

interface ATMState{
    void insertCard(Context context);
    void ejectCard(Context context);
    void dispenseCash(Context context, double amount);
}

class ReadyState implements ATMState{

    @Override
    public void insertCard(Context context) {
        System.out.println("Card inserted. Please enter your PIN.");
        context.setState(new CardInsertedState());
    }

    @Override
    public void ejectCard(Context context) {
        System.out.println("No card inserted. Please insert a card first.");
    }

    @Override
    public void dispenseCash(Context context, double amount) {
        System.out.println("No card inserted. Please insert a card first.");
    }

    @Override
    public String toString() {
        return "ReadyState{}";
    }
}
class CardInsertedState implements ATMState {

    @Override
    public void insertCard(Context context) {
        System.out.println("Card already inserted.");

    }

    @Override
    public void ejectCard(Context context) {
        System.out.println("Card ejected. Thank you!");
        context.setState(new ReadyState());

    }

    @Override
    public void dispenseCash(Context context, double amount) {
        if(context.getCash() >= amount){
            context.setCash(context.getCash() - amount);
            System.out.println("Dispensed " + amount + ". Current balance: " + context.getCash());
            context.setState(new ReadyState());
        }else{
            System.out.println("Insufficient cash. Moving to No Cash state.");
            context.setState(new InsufficientCashState());
        }

    }

    @Override
    public String toString() {
        return "CardInsertedState{}";
    }
}

class InsufficientCashState implements ATMState {

    @Override
    public void insertCard(Context context) {
        System.out.println("ATM out of cash. Cannot process transactions.");
    }

    @Override
    public void ejectCard(Context context) {
        System.out.println("ATM out of cash. No card can be inserted.");
    }

    @Override
    public void dispenseCash(Context context, double amount) {
        System.out.println("ATM out of cash. Cannot dispense cash.");

    }

    @Override
    public String toString() {
        return "InsufficientCashState{}";
    }
}
class Context {
    private ATMState state;
    private double cash;
    public Context() {
        state = new ReadyState();
        cash = 15_000.00;
    }

    public ATMState getState() {
        return state;
    }

    public void setState(ATMState state) {
        this.state = state;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public void insert(){
        state.insertCard(this);
    }

    public void eject(){
        state.ejectCard(this);
    }

    public void dispense(double amount){
        state.dispenseCash(this, amount);
    }
}
