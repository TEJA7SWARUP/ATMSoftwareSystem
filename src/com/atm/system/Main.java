package com.atm.system;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank userAccount = new Bank("1234567890", "1234", 5000.0);

        System.out.print("Enter PIN: ");
        String inputPin = sc.nextLine();

        if (!userAccount.authenticate(inputPin)) {
            System.out.println("Authentication failed!");
            sc.close(); // Optional here
            return;
        }

        while (true) {
            System.out.println("\n---- ATM MENU ----");
            System.out.println("1. View Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Exit");
            System.out.print("Select option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current Balance: ₹" + userAccount.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ₹");
                    double wAmt = sc.nextDouble();
                    sc.nextLine(); // consume newline
                    userAccount.withdraw(wAmt);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ₹");
                    double dAmt = sc.nextDouble();
                    sc.nextLine(); // consume newline
                    userAccount.deposit(dAmt);
                    break;
                case 4:
                    System.out.println("Thank you for using ATM!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
