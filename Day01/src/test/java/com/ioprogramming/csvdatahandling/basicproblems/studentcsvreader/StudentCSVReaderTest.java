package com.ioprogramming.csvdatahandling.basicproblems.studentcsvreader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

class StudentCSVReaderTest {

    private static final String VALID_FILE_PATH = "C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day01\\src\\students_data.csv";
    private static final String EMPTY_FILE_PATH = "src/test/resources/empty_students.csv";
    private static final String INVALID_FILE_PATH = "src/test/resources/invalid_students.csv";

    private StudentCSVReader reader;

    @BeforeEach
    void setUp() {
        reader = new StudentCSVReader();
    }

    @Test
    void testReadCSVFile_ValidFile() {

        assertDoesNotThrow(() -> reader.readCSVFile(VALID_FILE_PATH));
    }

    @Test
    void testReadCSVFile_EmptyFile() {

        assertDoesNotThrow(() -> reader.readCSVFile(EMPTY_FILE_PATH));
    }



    @Test
    void testCSVContent_ValidFile() {

        String expectedOutput = "ID: 1, Name: Ankit patel, Age: 25, Marks: 85\n" +
                "ID: 2, Name: Ankit Kumar, Age: 22, Marks: 90\n" +
                "ID: 3, Name: Anand Soni, Age: 19, Marks: 75\n";

        assertDoesNotThrow(() -> {
            reader.readCSVFile(VALID_FILE_PATH);
        });
    }
    @Test
    void testFileExistence() {
        assertTrue(Files.exists(Path.of(VALID_FILE_PATH)));
        assertFalse(Files.exists(Path.of(INVALID_FILE_PATH)));
    }
}
