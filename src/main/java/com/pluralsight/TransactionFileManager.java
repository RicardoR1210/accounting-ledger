package com.pluralsight;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class TransactionFileManager {
    public static void saveTransaction(Transaction transaction) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("Transactions.csv", true));
            bw.write(transaction.toString());
            bw.newLine();

            bw.close();

        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<Transaction> loadTransactions() {
        ArrayList<Transaction> transactions = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("Transactions.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.isEmpty()) {
                String[] data = line.split(Pattern.quote("|"));
                String date = data[0];
                String time = data[1];
                String description = data[2];
                String vendor = data[3];
                double amount = Double.parseDouble(data[4]);
                transactions.add(new Transaction(date,time,description,vendor,amount));
                }
            }
            br.close();
        }catch(IOException e) {
            e.printStackTrace();

        }
        return transactions;
    }
}
