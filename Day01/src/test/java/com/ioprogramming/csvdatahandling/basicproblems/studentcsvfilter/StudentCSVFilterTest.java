package com.ioprogramming.csvdatahandling.basicproblems.studentcsvfilter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class StudentCSVFilterTest {

    private static final String FILE_PATH = "C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day01\\src\\students_data.csv";
    private StudentCSVFilter filter;

    @BeforeEach
    void setUp() {
        filter = new StudentCSVFilter();
    }

    @Test
    void testFilterCSVFile() throws IOException {
        filter.filterCSVFile(FILE_PATH);
        File file = new File(FILE_PATH);
        assertTrue(file.exists(), "The file should exist.");

    }

    @Test
    void testFilterByMarks() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
        String line;
        boolean qualifiedStudents = false;
        br.readLine();
        while ((line = br.readLine()) != null) {
            String[] studentData = line.split(",");
            int marks = Integer.parseInt(studentData[3]);
            if (marks > 80) {
                qualifiedStudents = true;
            }
        }

        assertTrue(qualifiedStudents, "There should be students with marks greater than 80.");
    }
}

