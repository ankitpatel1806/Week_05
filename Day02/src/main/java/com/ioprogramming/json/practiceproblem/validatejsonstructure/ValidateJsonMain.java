package com.ioprogramming.json.practiceproblem.validatejsonstructure;
public class ValidateJsonMain {

    public static void main(String[] args) {

        String validJson = "{\"name\":\"Ankit Patel\",\"email\":\"yugap1806@gmail.com\",\"age\":30}";
        String invalidJson = "{\"name\":\"Ankit Kumar\",\"email\":\"ankitkumar7891@gmail.com\",\"age\":\"N/A\"}";

        System.out.println("Valid JSON: " + JsonValidator.isValidJsonStructure(validJson));
        System.out.println("Invalid JSON: " + JsonValidator.isValidJsonStructure(invalidJson));
    }
}
