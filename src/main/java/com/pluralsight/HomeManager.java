package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class HomeManager {
public static void HomeScreen(){
    Ledger ledger = new Ledger();
    Scanner scanner = new Scanner(System.in);
    String homeMenu = """
            D) Add Deposit - prompt the user for the deposit information and
            save it to the CSV file
            P) Make Payment (Debit) - prompt the user for the debit information
            and save it to the CSV file
            L) Ledger - display the ledger screen
            X) Exit - exit the application
            """;
    System.out.println(homeMenu);
    boolean running = true;
    while (running) {
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
    depositAmount = Math.abs(depositAmount);
    Transaction deposit = new Transaction(date, time, itemDescription, vendorName, depositAmount);
    transactionFileManager.saveTransaction(deposit);
    System.out.println("Deposit has been saved successfully.");

}
public static void makePayments(){
}
}
