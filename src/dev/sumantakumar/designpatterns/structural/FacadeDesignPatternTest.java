package dev.sumantakumar.designpatterns.structural;

public class FacadeDesignPatternTest {
    public static void main(String[] args) {
        BankFaced bankFaced = new BankFaced();

        long accountNumber = bankFaced.createAccount("Sumanta Kumar Sahoo");
        bankFaced.depositMoney(String.valueOf(accountNumber), 20_000_00);
        bankFaced.withdrawMoney(String.valueOf(accountNumber), 1_000_00);
        bankFaced.applyForLoan("Sumanta Kumar Sahoo", 10_000_00);

    }
}


class Account{
    public long createAccount(String accountHolder){
        long accountNumber = (long) (Math.random() * (9999999999L - 1000000000L) + 1000000000L);
        System.out.println("Creating account " + accountHolder + " with account number " + accountNumber);
        return accountNumber;
    }
    public void deposit(String accountNumber, int amount) {
        System.out.println("Rs. "+amount+"/- deposited into A/C No. " + accountNumber);

    }

    public void withdraw(String accountNumber, int amount) {
        System.out.println("Rs. "+amount+"/- withdrawn from A/C No. " + accountNumber);

    }
}

class Loan{
    public void applyLoan(String accountHolder, int amount){
        System.out.println(accountHolder+" applied for a loan of Rs. " + amount+"/-");
    }
    public void approveLoan(String accountHolder, int amount){
        System.out.println("Loan approved for "+accountHolder+" of Rs. " + amount+"/-");
    }
}

class CreditScore{
    public void checkCreditScore(String accountHolder){
        System.out.println("Credit score checked for "+accountHolder);
    }

    public void getCreditScore(String accountHolder){
        System.out.println(accountHolder+"'s credit score is good.");
    }
}

class BankFaced{
    private Account account;
    private Loan loan;
    private CreditScore creditScore;

    public BankFaced() {
        this.loan = new Loan();
        this.account = new Account();
        this.creditScore = new CreditScore();
    }

    public long createAccount(String accountHolder){
        System.out.println("Creating account for " + accountHolder);
        long accountNumber = account.createAccount(accountHolder);
        System.out.println("Created account for " + accountHolder);
        return accountNumber;
    }

    public void depositMoney(String accountHolder, int amount){
        account.deposit(accountHolder, amount);
    }

    public void withdrawMoney(String accountHolder, int amount){
        account.withdraw(accountHolder, amount);
    }

    public void applyForLoan(String accountHolder, int amount){
        System.out.println("Applying for " + accountHolder + " to loan " + amount);
        creditScore.checkCreditScore(accountHolder);
        creditScore.getCreditScore(accountHolder);
        loan.applyLoan(accountHolder, amount);
        loan.approveLoan(accountHolder, amount);


    }




}



