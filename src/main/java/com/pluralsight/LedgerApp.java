package com.pluralsight;

public class LedgerApp {
    public static void main(String[] args) {
        Transaction transaction = new Transaction("","","","",9.0);
        System.out.println(transaction.getAmount());
        System.out.println(transaction.getDate());
        System.out.println(transaction.getDescription());
        System.out.println(transaction.getTime());
        System.out.println(transaction.getVendor());
    }
}
