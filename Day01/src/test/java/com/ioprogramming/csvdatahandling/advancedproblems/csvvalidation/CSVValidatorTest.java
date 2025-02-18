package com.ioprogramming.csvdatahandling.advancedproblems.csvvalidation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CSVValidatorTest {

    @Test
    public void testValidEmail() {
        assertTrue(CSVValidator.isValidEmail("ankitpatel@gmail.com"));
        assertTrue(CSVValidator.isValidEmail("google.ukint@google.co.uk"));
    }

    @Test
    public void testInvalidEmail() {
        assertFalse(CSVValidator.isValidEmail("plainaddress"));
        assertFalse(CSVValidator.isValidEmail("test1@.com"));
        assertFalse(CSVValidator.isValidEmail("test@com"));
    }

    @Test
    public void testValidPhoneNumber() {
        assertTrue(CSVValidator.isValidPhoneNumber("1234567890"));
    }

    @Test
    public void testInvalidPhoneNumber() {
        assertFalse(CSVValidator.isValidPhoneNumber("12345"));
        assertFalse(CSVValidator.isValidPhoneNumber("123456789012"));
        assertFalse(CSVValidator.isValidPhoneNumber("abcdefg123"));
    }
}
