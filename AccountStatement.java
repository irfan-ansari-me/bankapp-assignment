package bankapp;

import java.io.FileWriter;
import java.io.IOException;

public class AccountStatement {
    String filename;
    int transactionId = 1;

    public AccountStatement(String accountNumber) {
        this.filename = accountNumber + ".txt";
        try (FileWriter outputStream = new FileWriter(this.filename)) {
            outputStream.write("*********** Account statement for account " + 
                        accountNumber + 
                        " ************\n\n" +
                        "Transaction_id\tTransaction_type\tAmount\n");
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public void recordTransaction(String transactionType, int amount) {
        try (FileWriter outputStream = new FileWriter(this.filename, true)) {
            outputStream.write(this.transactionId + "\t" + transactionType + "\t" + amount + "\n");
            this.transactionId++;
            System.out.println("Account statement updated!");
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}