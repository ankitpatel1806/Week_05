package com.ioprogramming.csvdatahandling.intermediateproblems.studentcsvfilter;
public class StudentCSVFilterMain {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day01\\src\\students_data.csv";
        StudentCSVFilter filter = new StudentCSVFilter();
        filter.filterCSVFile(filePath);
    }
}
