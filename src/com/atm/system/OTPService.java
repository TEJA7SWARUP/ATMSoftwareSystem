package com.atm.system;

import java.util.Random;

public class OTPService {
    public static String generateOTP() {
        Random rand = new Random();
        int otp = 100000 + rand.nextInt(900000);
        return String.valueOf(otp);
    }

    public static boolean verifyOTP(String sentOTP, String userInput) {
        return sentOTP.equals(userInput);
    }
}
