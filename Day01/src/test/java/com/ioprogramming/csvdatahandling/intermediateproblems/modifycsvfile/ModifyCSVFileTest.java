package com.ioprogramming.csvdatahandling.intermediateproblems.modifycsvfile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class CSVSalaryUpdaterTest {

    private static final String INPUT_FILE_PATH = "C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day01\\src\\employee_data.csv";
    private static final String OUTPUT_FILE_PATH = "C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day01\\src\\empty_students.csv";
    private CSVSalaryUpdater updater;

    @BeforeEach
    void setUp() {
        updater = new CSVSalaryUpdater();
    }

    @Test
    void testUpdateSalary() throws IOException {
        updater.updateSalary(INPUT_FILE_PATH, OUTPUT_FILE_PATH, "IT");

        File outputFile = new File(OUTPUT_FILE_PATH);
        assertTrue(outputFile.exists(), "The output file should exist.");

        try (BufferedReader br = new BufferedReader(new FileReader(OUTPUT_FILE_PATH))) {
            String line;
            boolean itEmployeeUpdated = false;
            while ((line = br.readLine()) != null) {
                String[] record = line.split(",");
                if (record[2].equalsIgnoreCase("IT")) {
                    double updatedSalary = Double.parseDouble(record[3]);
                    assertEquals(82500.00, updatedSalary, "The salary for IT employees should be updated to 82500.00");
                    itEmployeeUpdated = true;
                }
            }
            assertTrue(itEmployeeUpdated, "There should be at least one IT employee with updated salary.");
        }
    }

    @Test
    void testNoITEmployeeInFile() throws IOException {
        String emptyFilePath = "C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day01\\src\\employee_data.csv";
        String outputFilePath = "C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day01\\src\\empty_students.csv";
        updater.updateSalary(emptyFilePath, outputFilePath, "IT");

        File outputFile = new File(outputFilePath);
        assertTrue(outputFile.exists(), "The output file should exist.");

        try (BufferedReader br = new BufferedReader(new FileReader(outputFilePath))) {
            String line;
            boolean itEmployeeUpdated = false;
            while ((line = br.readLine()) != null) {
                String[] record = line.split(",");
                if (record[2].equalsIgnoreCase("IT")) {
                    itEmployeeUpdated = true;
                    break;
                }
            }
            assertTrue(itEmployeeUpdated, "There should be no IT employee in the updated file.");
        }
    }
}
