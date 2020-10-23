package bankapp;

public class BankAccount {
    private String accountNumber;
    private int balance;
    private AccountStatement accountStatement;
    
    public BankAccount(String accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountStatement = new AccountStatement(accountNumber);
    }

    public void deposit(int amount) {
        this.balance += amount;
        this.accountStatement.recordTransaction("Deposit", amount);
        System.out.println("Rs. " + amount + " added successfully! " + "Current balance is Rs. " + this.balance);
    }

    public void withdraw(int amount) {
        this.balance -= amount;
        this.accountStatement.recordTransaction("Withdrawal", amount);
        System.out.println("Rs. " + amount + " withdrawn from your account " + this.accountNumber + ". Current balance is Rs. " + this.balance);
    }

    public void showBalance() {
        System.out.println("Current balance is Rs. " + this.balance);
    }
}