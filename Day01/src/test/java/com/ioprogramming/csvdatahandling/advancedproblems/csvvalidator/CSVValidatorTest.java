package com.ioprogramming.csvdatahandling.advancedproblems.csvvalidator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CSVValidatorTest {

    @Test
    void testValidateEmail() {
        CSVValidator validator = new CSVValidator();
        assertTrue(validator.validateEmail("test@example.com"));
        assertFalse(validator.validateEmail("test@example"));
        assertFalse(validator.validateEmail("test.com"));
    }

    @Test
    void testValidatePhoneNumber() {
        CSVValidator validator = new CSVValidator();
        assertTrue(validator.validatePhoneNumber("1234567890"));
        assertFalse(validator.validatePhoneNumber("12345"));
        assertFalse(validator.validatePhoneNumber("12345678901"));
    }
}
