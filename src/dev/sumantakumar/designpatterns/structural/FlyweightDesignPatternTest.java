package dev.sumantakumar.designpatterns.structural;

import java.util.HashMap;
import java.util.Map;

public class FlyweightDesignPatternTest {
    public static void main(String[] args) {
        BankAccount savingsAccount = AccountFactory.getAccount("SAVINGS", 7.0);
        savingsAccount.displayAccountDetails("Sumanta Kumar");

        BankAccount currentAccount = AccountFactory.getAccount("CURRENT", 0.0);
        currentAccount.displayAccountDetails("Leafify Technology Pvt. Ltd.");

        BankAccount personalLoanAccount = AccountFactory.getAccount("PERSONAL_LOAN", 10.0);
        personalLoanAccount.displayAccountDetails("Sahoo");

        BankAccount homeLoanAccount = AccountFactory.getAccount("HOME_LOAN", 8.5);
        homeLoanAccount.displayAccountDetails("Kumar");

    }
}

interface BankAccount {
    void displayAccountDetails(String accountHolderName);
}

class AccountType implements BankAccount {
    private final String accountType;
    private final double interestRate;

    public AccountType(String accountType, double interestRate) {
        this.accountType = accountType;
        this.interestRate = interestRate;
    }

    @Override
    public void displayAccountDetails(String accountHolderName) {
        System.out.println("Hi "+accountHolderName+", Your Account Type is : " + accountType+". & Interest Rate: "+interestRate);

    }
}

class AccountFactory{
    private static final Map<String, BankAccount> accountMap = new HashMap<>();

    public static BankAccount getAccount(String accountType, double interestRate) {
        BankAccount account = accountMap.get(accountType);
        if (account == null) {
            account = new AccountType(accountType, interestRate);
            accountMap.put(accountType, account);
            System.out.println("Created new account " + accountType);
        }else{
            System.out.println("Account " + accountType + " already exists");
        }
        return account;
    }
}




