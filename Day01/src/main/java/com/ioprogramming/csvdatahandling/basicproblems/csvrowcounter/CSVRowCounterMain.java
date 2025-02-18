package com.ioprogramming.csvdatahandling.basicproblems.csvrowcounter;

public class CSVRowCounterMain {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day01\\src\\students_data.csv";
        CSVRowCounter counter = new CSVRowCounter();
        counter.countCSVRows(filePath);
    }
}
