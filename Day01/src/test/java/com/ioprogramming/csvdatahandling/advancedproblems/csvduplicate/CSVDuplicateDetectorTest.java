package com.ioprogramming.csvdatahandling.advancedproblems.csvduplicate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CSVDuplicateDetectorTest {

    private static final String TEST_CSV = "C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day01\\src\\employees.csv";

    @BeforeEach
    public void setUp() throws IOException {
        String content = "ID,Name,Age\n1,John Doe,20\n2,Jane Smith,22\n1,John Doe,20\n3,Jim Brown,25";
        try (FileWriter writer = new FileWriter(TEST_CSV)) {
            writer.write(content);
        }
    }

    @Test
    public void testDetectDuplicates() {
        CSVDuplicateDetector detector = new CSVDuplicateDetector();
        detector.detectDuplicates(TEST_CSV);
    }

    @Test
    public void testCleanup() {
        new File(TEST_CSV).delete();
    }
}
