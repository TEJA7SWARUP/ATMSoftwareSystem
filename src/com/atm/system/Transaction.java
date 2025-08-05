package com.atm.system;

import java.time.LocalDateTime;

public class Transaction {
    public static void log(String type, double amount) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("[" + now + "] " + type + " of ₹" + amount);
    }
}
