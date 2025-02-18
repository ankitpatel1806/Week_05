package com.ioprogramming.csvdatahandling.advancedproblems.databasereport;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class CSVReportGeneratorTest {

    private static final String TEST_INPUT_CSV = "C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day01\\src\\employees_100_records.csv";
    private static final String TEST_OUTPUT_CSV = "C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day01\\src\\employees.csv";

    @BeforeEach
    public void setUp() throws IOException {
        String content = "1,Ankit Kumar,Engineering,75000\n2,Ankit Patel,Marketing,65000\n3,Anand Soni,Sales,70000";
        try (java.io.FileWriter writer = new java.io.FileWriter(TEST_INPUT_CSV)) {
            writer.write(content);
        }
    }

    @Test
    public void testGenerateCSVReport() {
        CSVReportGenerator reportGenerator = new CSVReportGenerator();
        reportGenerator.generateCSVReport(TEST_INPUT_CSV, TEST_OUTPUT_CSV);
    }

    @Test
    public void testCleanup() {
        new File(TEST_INPUT_CSV).delete();
        new File(TEST_OUTPUT_CSV).delete();
    }
}
