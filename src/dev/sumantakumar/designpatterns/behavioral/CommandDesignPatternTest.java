package dev.sumantakumar.designpatterns.behavioral;


import java.util.ArrayList;
import java.util.List;

public class CommandDesignPatternTest {
    public static void main(String[] args) {

        Account account = new Account(1_00_000.00);

        Command deposit = new DepositCommand(account, 10_000.00);
        Command withdraw = new WithdrawCommand(account, 20_000.00);

        Bank bank = new Bank();
        bank.executeCommand(deposit);
        bank.executeCommand(withdraw);


    }
}

interface Command {
    void execute();
}

class DepositCommand implements Command {
    private Account account;
    private double amount;
    public DepositCommand(Account account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        account.deposit(amount);
    }
}

class WithdrawCommand implements Command {
    private Account account;
    private double amount;
    public WithdrawCommand(Account account, double amount) {
        this.account = account;
        this.amount = amount;
    }


    @Override
    public void execute() {
        account.withdraw(amount);
    }
}

class Account {
    private double balance;
    public Account(double balance) {
        this.balance = balance;
    }
    public void deposit(double amount) {
        this.balance += amount;
        System.out.println("Deposited: Rs. " + amount+"/-. New balance: " + this.balance);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            this.balance -= amount;
            System.out.println("Withdraw: Rs. " + amount+"/-. New balance: " + this.balance);
        }else{
            System.out.println("Insufficient funds. Current Balance: Rs. " + this.balance);
        }
    }
}


class Bank{
    private List<Command> commandHistory = new ArrayList<>();
    public void executeCommand(Command cmd) {
        commandHistory.add(cmd);
        cmd.execute();
    }
}
