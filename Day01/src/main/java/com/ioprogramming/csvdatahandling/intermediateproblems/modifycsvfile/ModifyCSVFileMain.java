package com.ioprogramming.csvdatahandling.intermediateproblems.modifycsvfile;

public class ModifyCSVFileMain {

    public static void main(String[] args) {
        String inputFilePath = "C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day01\\src\\employee_data.csv";
        String outputFilePath = "C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day01\\src\\empty_students.csv";
        String department = "IT";

        CSVSalaryUpdater updater = new CSVSalaryUpdater();
        updater.updateSalary(inputFilePath, outputFilePath, department);
        updater.readCSVFile(outputFilePath);
    }
}
