package com.ioprogramming.json.practiceproblem.validatejsonstructure;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidateJsonTest {

    @Test
    public void testValidJsonStructure() {
        String validJson = "{\"name\":\"Anand Soni\",\"email\":\"anandsoni@gmail.com\",\"age\":30}";
        assertTrue(JsonValidator.isValidJsonStructure(validJson));
    }

    @Test
    public void testInvalidJsonStructure() {
        String invalidJson = "{\"name\":\"Ankit Patel\",\"email\":\"yugap1806@gmail.com\",\"age\":\"invalid\"}";
        assertFalse(JsonValidator.isValidJsonStructure(invalidJson));
    }

    @Test
    public void testMissingFields() {
                String missingFieldsJson = "{\"name\":\"Ankit Kumar\",\"email\":\"ankitkumar7891@gmail.com\"}";
        assertFalse(JsonValidator.isValidJsonStructure(missingFieldsJson));
    }
}

