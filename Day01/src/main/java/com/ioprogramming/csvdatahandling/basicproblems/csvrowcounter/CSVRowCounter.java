package com.ioprogramming.csvdatahandling.basicproblems.csvrowcounter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class CSVRowCounter {
    public void countCSVRows(String filePath) {
        String line;
        int rowCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                rowCount++;
            }
            System.out.println("The number of rows in the CSV file is: " + rowCount);
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        }
    }
}
