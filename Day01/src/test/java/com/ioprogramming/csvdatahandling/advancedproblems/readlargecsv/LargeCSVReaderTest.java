package com.ioprogramming.csvdatahandling.advancedproblems.readlargecsv;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LargeCSVReaderTest {

    private static final String SMALL_CSV = "C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day01\\src\\employee_data.csv";
    private static final String LARGE_CSV = "C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day01\\src\\employees.csv";

    @BeforeEach
    public void setUp() throws IOException {
        // Create a small test file for testing
        String smallCsvContent = "ID,Name,Age\n1,John Doe,20\n2,Jane Smith,21\n";
        writeToFile(SMALL_CSV, smallCsvContent);

        StringBuilder largeCsvContent = new StringBuilder("ID,Name,Age\n");
        for (int i = 1; i <= 1000; i++) {
            largeCsvContent.append(i).append(",Name ").append(i).append(",").append(20 + (i % 30)).append("\n");
        }
        writeToFile(LARGE_CSV, largeCsvContent.toString());
    }

    private void writeToFile(String filePath, String content) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
        }
    }

    @Test
    public void testReadSmallCSV() {
        LargeCSVReader reader = new LargeCSVReader();
        reader.readCSVInChunks(SMALL_CSV);

    }

    @Test
    public void testReadLargeCSV() {
        LargeCSVReader reader = new LargeCSVReader();
        reader.readCSVInChunks(LARGE_CSV);

    }

    @Test
    public void testInvalidFilePath() {
        LargeCSVReader reader = new LargeCSVReader();
        reader.readCSVInChunks("invalid_file.csv");

    }

    @Test
    public void testCleanup() {
        new File(SMALL_CSV).delete();
        new File(LARGE_CSV).delete();
    }
}
