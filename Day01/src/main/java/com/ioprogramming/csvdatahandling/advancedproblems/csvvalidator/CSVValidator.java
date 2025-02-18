package com.ioprogramming.csvdatahandling.advancedproblems.csvvalidator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CSVValidator {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final String PHONE_REGEX = "^\\d{10}$";

    public void validateCSV(String filePath) {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String email = data[0];
                String phoneNumber = data[1];
                boolean isEmailValid = validateEmail(email);
                boolean isPhoneNumberValid = validatePhoneNumber(phoneNumber);
                if (!isEmailValid || !isPhoneNumberValid) {
                    System.out.println("Invalid row: " + line);
                    if (!isEmailValid) {
                        System.out.println("Error: Invalid email format.");
                    }
                    if (!isPhoneNumberValid) {
                        System.out.println("Error: Phone number must be exactly 10 digits.");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    boolean validatePhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile(PHONE_REGEX);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    public static void main(String[] args) {
        CSVValidator validator = new CSVValidator();
        validator.validateCSV("data.csv");
    }
}
