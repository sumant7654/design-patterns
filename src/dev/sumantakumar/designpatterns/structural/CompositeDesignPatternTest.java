package dev.sumantakumar.designpatterns.structural;

import java.util.ArrayList;
import java.util.List;

public class CompositeDesignPatternTest {
    public static void main(String[] args) {

        SavingsAccount savingsAccount = new SavingsAccount("Sumanta", 1_00_000.00);
        SavingsAccount savingsAccount1 = new SavingsAccount("Sumair", 3_00_000.00);
        CurrentAccount currentAccount = new CurrentAccount("Shadab", 2_00_000.00);

        AccountComposite accountComposite = new AccountComposite();
        accountComposite.addAccountComponent(savingsAccount);
        accountComposite.addAccountComponent(savingsAccount1);
        accountComposite.addAccountComponent(currentAccount);
        accountComposite.showAccountDetails();
        accountComposite.removeAccountComponent(savingsAccount1);

    }
}

interface AccountComponent {
    void showAccountDetails();
}

class SavingsAccount implements AccountComponent {
    private final String accountHolderName;
    private final double balance;

    public SavingsAccount(String accountHolderName, double balance) {
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    @Override
    public void showAccountDetails() {
        System.out.println("Savings Account Holder: " + accountHolderName+". Balance: " + balance);

    }
}

class CurrentAccount implements AccountComponent {
    private final String accountHolderName;
    private final double balance;

    public CurrentAccount(String accountHolderName, double balance) {
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    @Override
    public void showAccountDetails() {
        System.out.println("Current Account Holder: " + accountHolderName+". Balance: " + balance);

    }
}

class AccountComposite implements AccountComponent {
    private final List<AccountComponent> accountComponents = new ArrayList<>();

    public void addAccountComponent(AccountComponent accountComponent) {
        accountComponents.add(accountComponent);
    }

    public void removeAccountComponent(AccountComponent accountComponent) {
        accountComponents.remove(accountComponent);
    }

    @Override
    public void showAccountDetails() {
        accountComponents.forEach(AccountComponent::showAccountDetails);

    }
}