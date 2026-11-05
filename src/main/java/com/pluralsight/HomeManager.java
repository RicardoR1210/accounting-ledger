package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class HomeManager {
public static void homeScreen(){
    Ledger ledger = new Ledger();
    Scanner scanner = new Scanner(System.in);
    String homeMenu = """
            *********************************
            o D) Add Deposit
            o P) Make Payment (Debit)
            o L) Ledger
            o X) Exit
            *********************************
            """;
    boolean running = true;
    while (running) {
        System.out.println(homeMenu);
        System.out.print("please select one of the options above: ");
        String userInput = scanner.nextLine();
        userInput = userInput.toUpperCase();
        switch (userInput) {
            case "D":
                addDeposit();
                break;
            case "P":
                makePayments();
                break;
            case "L":
                ledger.ledgerMenu();
                break;
            case "X":
                running = false;
                break;
            default:
                System.out.println("Invalid input");
        }
    }
}
public static void addDeposit(){
    TransactionFileManager transactionFileManager = new TransactionFileManager();
    Scanner scanner = new Scanner(System.in);
    LocalDate depositDate = LocalDate.now();
    LocalTime depositTime = LocalTime.now();
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");

    String date = depositDate.toString();
    String time = depositTime.format(fmt);

    System.out.println("Please enter Item description:");
    String itemDescription = scanner.nextLine();
    System.out.println("Please enter vendor name:");
    String vendorName = scanner.nextLine();
    System.out.println("Please enter deposit amount:");
    double depositAmount = scanner.nextDouble();
    scanner.nextLine();
    depositAmount = Math.abs(depositAmount);
    Transaction deposit = new Transaction(date, time, itemDescription, vendorName, depositAmount);
    transactionFileManager.saveTransaction(deposit);
    Ledger.refreshTransactions();
    System.out.println("Deposit has been saved successfully.");

}
public static void makePayments(){
    TransactionFileManager transactionFileManager = new TransactionFileManager();
    Scanner scanner = new Scanner(System.in);
    LocalDate paymentDate = LocalDate.now();
    LocalTime paymentTime = LocalTime.now();
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");

    String date = paymentDate.toString();
    String time = paymentTime.format(fmt);

    System.out.println("Please enter Item description:");
    String itemDescription = scanner.nextLine();
    System.out.println("Please enter vendor name:");
    String vendorName = scanner.nextLine();
    System.out.println("Please enter payment amount:");
    double paymentAmount = scanner.nextDouble();
    scanner.nextLine();
    if(paymentAmount > 0){
        paymentAmount *= -1;
    }
    Transaction payment = new Transaction(date, time, itemDescription, vendorName, paymentAmount);
    transactionFileManager.saveTransaction(payment);
    Ledger.refreshTransactions();
    System.out.println("payment has been saved successfully.");

    }
}
