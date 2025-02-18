package com.ioprogramming.csvdatahandling.basicproblems.employeecsvreader;

public class EmployeeCSVWriterMain {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day01\\src\\employee_data.csv";
        EmployeeCSVWriter writer = new EmployeeCSVWriter();
        writer.writeCSVFile(filePath);
        EmployeeCSVWriter reader = new EmployeeCSVWriter();
        reader.readCSVFile(filePath);
    }
}
