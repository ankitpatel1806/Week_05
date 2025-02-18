package com.ioprogramming.csvdatahandling.advancedproblems.encryption;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CSVEncryptDecryptTest {

    private static final String TEST_INPUT_CSV = "employee_data.csv";
    private static final String TEST_ENCRYPTED_CSV = "encrypted_employee_data.csv";

    @BeforeEach
    public void setUp() {
        String content = "1,John Doe,john.doe@example.com,75000\n2,Jane Smith,jane.smith@example.com,65000\n3,Jim Brown,jim.brown@example.com,70000";
        try (java.io.FileWriter writer = new java.io.FileWriter(TEST_INPUT_CSV)) {
            writer.write(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testEncryptAndWriteCSV() {
        CSVEncryptDecrypt encryptDecrypt = new CSVEncryptDecrypt();
        encryptDecrypt.encryptAndWriteCSV(TEST_INPUT_CSV, TEST_ENCRYPTED_CSV);
        File file = new File(TEST_ENCRYPTED_CSV);
        assertTrue(file.exists(), "Encrypted CSV file should exist after conversion");
    }

    @Test
    public void testReadAndDecryptCSV() {
        CSVEncryptDecrypt encryptDecrypt = new CSVEncryptDecrypt();
        encryptDecrypt.readAndDecryptCSV(TEST_ENCRYPTED_CSV);
    }

    @Test
    public void testCleanup() {
        new File(TEST_INPUT_CSV).delete();
        new File(TEST_ENCRYPTED_CSV).delete();
    }
}
