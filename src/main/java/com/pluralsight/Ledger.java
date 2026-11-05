package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Ledger {
    private static ArrayList<Transaction> transactions = TransactionFileManager.loadTransactions();

    public static void displayTransactions() {
        DateTimeFormatter fmt =
                DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm:ss");

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
                        //is before is like compareTo
                        if(dateTimeCombined.isBefore(dateTime2)) {//first transaction happened before the second transaction.
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
    public static void displayDeposits() {
        for (Transaction t : transactions) {
            if (t.getAmount() > 0){
                System.out.println(t);
            }

        }
    }
    public static void displayPayments() {
        for (Transaction t : transactions) {
            if (t.getAmount() < 0){
                System.out.println(t);
            }
        }
    }
    public void ledgerMenu() {
        Scanner scanner = new Scanner(System.in);
        String menu = """
                o A) Display All
                o D) Deposits - Display only the entries that are deposits into the account
                o P) Payments - Display only the negative entries (or payments)
                o R) Reports - A new screen that allows the user to run pre-defined reports or
                o H) Home - go back to the home page
                """;
        boolean running = true;

        while (running) {
            System.out.println(menu);
            System.out.print("please enter your choice: ");
            String choice = scanner.nextLine();
            choice = choice.toUpperCase();
            switch (choice) {
                case "A":
                    displayTransactions();
                    break;

                case "D":
                    displayDeposits();
                    break;

                case "P":
                    displayPayments();
                    break;
                case "R":
                    reportsMenu();
                    break;
                case "H":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }

        }
    }
    public static void reportsMenu() {
        Scanner scanner = new Scanner(System.in);
        String reports = """
                1) Month To Date
                2) Previous Month
                3) Year To Date
                4) Previous Year
                5) Search by Vendor - prompt the user for the vendor name and
                display all entries for that vendor
                0) Back - go back to the Ledger page
                """;
        boolean running = true;
        while (running) {
            System.out.println(reports);
            System.out.print("please enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    monthToDate();
                    break;
                case 2:
                    previousMonth();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                    running = false;
                    break;
                   default:
                       System.out.println("Invalid choice");
            }
        }
    }
    public static void monthToDate() {
        LocalDate today = LocalDate.now();
        LocalDate firstDay = today.withDayOfMonth(1);
        for(Transaction t : transactions) {
            LocalDate dateTime = LocalDate.parse(t.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            if(!dateTime.isBefore(firstDay) && !dateTime.isAfter(today)) {
                System.out.println(t);
            }

        }
    }
    public static void previousMonth(){
        LocalDate today = LocalDate.now();
        int currentMonth = today.getMonthValue();
        int year = today.getYear();

        int previousMonth;
        int previousYear;
        if(currentMonth == 1){
            previousMonth = 12;
            previousYear = year-1;
        }else {
            previousMonth = currentMonth-1;
            previousYear = year;
        }
        for(Transaction transactionMonth : transactions) {
            LocalDate dateTime = LocalDate.parse(transactionMonth.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            if (dateTime.getMonthValue() == previousMonth && dateTime.getYear() == previousYear) {
                System.out.println(transactionMonth);
            }
        }


    }
    public static void yearToDate() {
        LocalDate today = LocalDate.now();
        LocalDate firstDay = today.withDayOfYear(1);
        for(Transaction t : transactions) {
            LocalDate dateTime = LocalDate.parse(t.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            if(!dateTime.isBefore(firstDay) && !dateTime.isAfter(today)) {
                System.out.println(t);
            }

        }
    }
    public static void previousYear(){
        LocalDate today = LocalDate.now();
        int year = today.getYear();

        int previousYear = year-1;

        for(Transaction transactionMonth : transactions) {
            LocalDate dateTime = LocalDate.parse(transactionMonth.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            if (dateTime.getYear() == previousYear) {
                System.out.println(transactionMonth);
            }
        }


    }



}
