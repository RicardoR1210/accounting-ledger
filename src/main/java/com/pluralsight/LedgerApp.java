package com.pluralsight;


import java.util.ArrayList;

public class LedgerApp {
    public static void main(String[] args) {
    Transaction transaction = new Transaction("12-10-2026","10:13:25",
            "ergonomic keyboard","Walmart",-89.50);
    TransactionFileManager.saveTransaction(transaction);
    ArrayList<Transaction> display =TransactionFileManager.loadTransactions();
        for(Transaction t: display){
            System.out.println(t);
        }
    }
}
