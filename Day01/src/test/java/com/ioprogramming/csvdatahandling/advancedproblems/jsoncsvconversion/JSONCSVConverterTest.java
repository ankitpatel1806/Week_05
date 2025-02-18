package com.ioprogramming.csvdatahandling.advancedproblems.jsoncsvconversion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class JSONCSVConverterTest {

    private static final String TEST_JSON_FILE = "students.json";
    private static final String TEST_CSV_FILE = "students.csv";
    private static final String TEST_JSON_FILE_CONVERTED = "converted_students.json";
    private static final String TEST_CSV_FILE_CONVERTED = "converted_students.csv";

    @BeforeEach
    public void setUp() {
        // Example JSON data to test
        String jsonContent = "[{\"id\":1,\"name\":\"John Doe\",\"age\":20,\"grade\":\"A\"},"
                + "{\"id\":2,\"name\":\"Jane Smith\",\"age\":22,\"grade\":\"B\"},"
                + "{\"id\":3,\"name\":\"Jim Brown\",\"age\":21,\"grade\":\"A\"}]";

        try (java.io.FileWriter writer = new java.io.FileWriter(TEST_JSON_FILE)) {
            writer.write(jsonContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testJsonToCsv() {
        JSONCSVConverter converter = new JSONCSVConverter();
        converter.jsonToCsv(TEST_JSON_FILE, TEST_CSV_FILE_CONVERTED);
        File file = new File(TEST_CSV_FILE_CONVERTED);
        assertTrue(file.exists(), "CSV file should exist after conversion");
    }



    @Test
    public void testCleanup() {
        new File(TEST_JSON_FILE).delete();
        new File(TEST_CSV_FILE).delete();
        new File(TEST_JSON_FILE_CONVERTED).delete();
        new File(TEST_CSV_FILE_CONVERTED).delete();
    }
}
