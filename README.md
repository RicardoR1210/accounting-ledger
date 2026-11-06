# Accounting Ledger

## Project Description

The Accounting Ledger is a Java console application that allows users to manage and track their financial transactions. Users can record deposits and payments, view their transaction history, and generate reports based on dates or vendors.

## Features

- **Add Deposit:** Record money coming into the account.
- **Make Payment:** Record payments and expenses.
- **Display All:** View all transactions, sorted by newest first.
- **Deposits:** Display transactions with positive amounts.
- **Payments:** Display transactions with negative amounts.
- **Month To Date:** View transactions from the beginning of the current month.
- **Previous Month:** View transactions from the previous month.
- **Year To Date:** View transactions from the beginning of the current year.
- **Previous Year:** View transactions from the previous year.
- **Search by Vendor:** Find transactions using a vendor name.

## Technologies Used

- Java
- IntelliJ IDEA
- File I/O
- ArrayList
- LocalDate and LocalTime
- DateTimeFormatter

## Data Storage

Transactions are stored in a CSV file named `Transactions.csv`.

Each transaction contains:
- Date
- Time
- Description
- Vendor
- Amount

The application saves new transactions to the file and loads them when displaying the ledger.

## How to Run

1. Open the project in IntelliJ IDEA.
2. Locate the `LedgerApp` class.
3. Run the `main()` method.
4. Follow the menu instructions to manage transactions.

## What I practiced

Through this project, I practiced:
- Object-oriented programming.
- Creating and organizing Java classes.
- Reading and writing files.
- Working with ArrayLists.
- Using dates and times.
- Building menus with loops and switch statements.
