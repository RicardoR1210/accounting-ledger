package com.pluralsight;

import java.util.Locale;
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

}
public static void makePayments(){

}
}
