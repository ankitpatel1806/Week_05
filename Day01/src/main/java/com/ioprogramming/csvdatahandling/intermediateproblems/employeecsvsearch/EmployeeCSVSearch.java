package com.ioprogramming.csvdatahandling.intermediateproblems.employeecsvsearch;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class EmployeeCSVSearch {
    public void searchCSVFile(String filePath, String searchName) {
        String line;
        String splitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] employeeData = line.split(splitBy);
                String id = employeeData[0];
                String name = employeeData[1];
                String age = employeeData[2];
                String designation = employeeData[3];
                if (name.equals(searchName)) {
                    System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Designation: " + designation);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        }
    }
}
