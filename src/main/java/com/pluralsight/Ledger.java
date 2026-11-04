package com.pluralsight;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Ledger {
    private  ArrayList<Transaction> transactions = TransactionFileManager.loadTransactions();

    public void displayTransactions() {
        DateTimeFormatter fmt =
                DateTimeFormatter.ofPattern("yyyy, MM, dd, HH:mm:ss");

        if (transactions.isEmpty()) {
            System.out.println("No transactions found");
        }else if (transactions.size() == 1) {
                System.out.println("Only one transaction found:");
                System.out.println(transactions.get(0));
            }else {
                for(int i = 0; i < transactions.size()-1; i++) {
                    
                    for (int j = 0; j < transactions.size() - 1; j++) {
                        // -1 to prevent the +1 to reach outside the index
                        Transaction getTransaction = transactions.get(j);
                        Transaction getTransaction1 = transactions.get(j+ 1);
                        String dateTime = getTransaction.getDate() + " " + getTransaction.getTime();
                        String dateTime1 = getTransaction1.getDate() + " " + getTransaction1.getTime();
                        LocalDateTime dateTime2 = LocalDateTime.parse(dateTime1, fmt);
                        LocalDateTime dateTimeCombined = LocalDateTime.parse(dateTime, fmt);

                        if(dateTimeCombined.compareTo(dateTime2)< 0) {//first transaction happened before the second transaction.
                            //swaping to sort by newest
                            transactions.set(j, getTransaction1);
                            transactions.set(j+1, getTransaction);
                        }
                }
            }
            for (Transaction t : transactions) {
                System.out.println(t);
            }
        }
    }
    public void displayDeposits() {
        for (Transaction t : transactions) {
            if (t.getAmount() > 0){
                System.out.println(t);
            }

        }
    }
    public void displayPayments() {
        for (Transaction t : transactions) {
            if (t.getAmount() < 0){
                System.out.println(t);
            }
        }
    }

}
