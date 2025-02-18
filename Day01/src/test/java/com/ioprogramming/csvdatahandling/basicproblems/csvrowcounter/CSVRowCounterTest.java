package com.ioprogramming.csvdatahandling.basicproblems.csvrowcounter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVRowCounterTest {

    private static final String FILE_PATH = "C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day01\\src\\students_data.csv";
    private CSVRowCounter counter;

    @Test
    void testCountCSVRows() throws IOException {
        counter = new CSVRowCounter();
        counter.countCSVRows(FILE_PATH);
        BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
        String line;
        br.readLine();
        int rowCount = 0;
        while ((line = br.readLine()) != null) {
            rowCount++;
        }
        assertEquals(rowCount, 1000, "The number of rows should be 6.");
    }
}
