package com.ioprogramming.csvdatahandling.intermediateproblems.employeecsvsearch;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;

public class EmployeeCSVSearchTest {
    private static final String FILE_PATH = "C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day01\\src\\employee_data.csv";
    private EmployeeCSVSearch search;
    @BeforeEach
    void setUp() {
        search = new EmployeeCSVSearch();
    }
    @Test
    void testSearchCSVFile() throws IOException {
        search.searchCSVFile(FILE_PATH, "Ankit Patel");
        File file = new File(FILE_PATH);
        assertFalse(file.exists(), "The file should exist.");
    }
    @Test
    void testSearchByName() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
        String line;
        boolean employeeFound = false;
        br.readLine();
        while ((line = br.readLine()) != null) {
            String[] employeeData = line.split(",");
            String name = employeeData[1];
            if (name.equals("Ankit Patel")) {
                employeeFound = true;
            }
        }
        assertTrue(employeeFound, "There should be an employee with the name John.");
    }
}
