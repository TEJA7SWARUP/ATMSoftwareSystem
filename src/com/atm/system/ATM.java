package com.atm.system;

public class ATM {
    private String cardNumber;
    private String pin;
    private double balance;

    public ATM(String cardNumber, String pin, double balance) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.balance = balance;
    }

    public boolean authenticate(String enteredPin) {
        return this.pin.equals(enteredPin);
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("₹" + amount + " deposited successfully.");
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
            return true;
        } else {
            System.out.println("Insufficient balance.");
            return false;
        }
    }
}
