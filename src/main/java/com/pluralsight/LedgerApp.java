package com.pluralsight;

import java.util.Scanner;

public class LedgerApp {
    public static void main(String[] args) throws InterruptedException {
        welcomeScreen();
        Thread.sleep(1000);
        homeScreen();
        goodbyeScreen();



    }
    public static void welcomeScreen(){
        System.out.println("=======================================");
        System.out.println(" ************************************** ");
        System.out.println(" *Welcome to the Accounting Ledger App* ");
        System.out.println(" *************************************");
        System.out.println("=======================================");
    }
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
                    HomeManager.addDeposit();
                    break;
                case "P":
                    HomeManager.makePayments();
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
    public static void goodbyeScreen(){
        System.out.println("=======================================");
        System.out.println(" ************************************** ");
        System.out.println("*Thanks for using our application!*");
        System.out.println(" *************************************");
        System.out.println("=======================================");
    }
}
