package bankapp;

import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BankingApplication {
    public static void main(String[] args) {
        String choice;
        int amount;
        Scanner input = new Scanner(System.in);
        String  accountNumber = "12123234";
        BankAccount bankAccount = new BankAccount(accountNumber, 3001);

        while (true) {
            System.out.println("1. Deposit amount\n" +
                        "2. Withdraw amount\n" +
                        "3. Balance enquiry\n" +
                        "4. Show bank statement\n" +
                        "0. Exit\n" +
                        "Enter your choice: "
            );
            choice = input.nextLine();
            System.out.println("Your choice " + choice);
            switch (choice) {
                case "1":
                    System.out.println("Enter amount to deposit");
                    amount = input.nextInt();
                    bankAccount.deposit(amount);    
                    break;
            
                case "2":
                    System.out.println("Enter amount to withdraw");
                    amount = input.nextInt();
                    try {
                        bankAccount.withdraw(amount);
                    } catch (LowBalanceException lowbalance) {
                        System.out.println(lowbalance.getMessage());
                    }
                    break;
    
                case "3":
                    bankAccount.showBalance();
                    break;

                case "4":
                    try {
                        BufferedReader inputStream = new BufferedReader(new FileReader(accountNumber + ".txt"));
                        String transaction;
                        while ((transaction = inputStream.readLine()) != null) {
                            System.out.println(transaction);
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found!");
                    } 
                    catch (IOException io) {
                        System.out.println("IO error!");                        
                    }
                    break;
    
                default:
                    if (choice == "0") return;
                    System.out.println("Wrong choice!");
                    break;
            }  
        }
    }
}