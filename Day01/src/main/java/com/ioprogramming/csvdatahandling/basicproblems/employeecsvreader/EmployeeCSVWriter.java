package com.ioprogramming.csvdatahandling.basicproblems.employeecsvreader;
import java.io.*;
import java.util.ArrayList;

public class EmployeeCSVWriter {
    public void writeCSVFile(String filePath, ArrayList<String> modifiedData) {
        String[][] employees = {
                {"1", "Ankit Patel", "HR", "55000"},
                {"2", "Anand Soni", "Finance", "60000"},
                {"3", "Riya Rai", "IT", "75000"},
                {"4", "Aakriti Barsaiyn", "Sales", "65000"},
                {"5", "Avinash Rai", "Marketing", "70000"}
        };

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("ID,Name,Department,Salary");
            writer.newLine();
            for (String[] employee : employees) {
                writer.write(String.join(",", employee));
                writer.newLine();
            }

            System.out.println("Employee data written to CSV successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to the CSV file: " + e.getMessage());
        }
    }
    public void readCSVFile(String filePath) {
        String line;
        String splitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] studentData = line.split(splitBy);
                String id = studentData[0];
                String name = studentData[1];
                String age = studentData[2];
                String marks = studentData[3];
                System.out.println("ID: " + id + ", Name: " + name + ", Department: " + age + ", Salary: " + marks);
            }
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        }
    }
}
