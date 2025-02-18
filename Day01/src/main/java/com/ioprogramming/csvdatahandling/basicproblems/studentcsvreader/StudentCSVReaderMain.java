package com.ioprogramming.csvdatahandling.basicproblems.studentcsvreader;
public class StudentCSVReaderMain {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day01\\src\\students_data.csv";
        StudentCSVReader reader = new StudentCSVReader();
        reader.readCSVFile(filePath);
    }
}
