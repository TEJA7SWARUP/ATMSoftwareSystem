package com.atm.system;

import java.util.Scanner;

public class Bank extends ATM {
    public Bank(String cardNumber, String pin, double balance) {
        super(cardNumber, pin, balance);
    }

    @Override
    public boolean withdraw(double amount) {
        Scanner sc = new Scanner(System.in);
        String otp = OTPService.generateOTP();
        
        System.out.println("Generated OTP (simulated): " + otp);
        System.out.print("Enter OTP: ");
        String enteredOTP = sc.nextLine();
        if (OTPService.verifyOTP(otp, enteredOTP)) {
            boolean success = super.withdraw(amount);
            if (success) Transaction.log("Withdraw", amount);
            return success;
        } else {
            System.out.println("OTP verification failed.");
            return false;
        }
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        Transaction.log("Deposit", amount);
    }
    
}
