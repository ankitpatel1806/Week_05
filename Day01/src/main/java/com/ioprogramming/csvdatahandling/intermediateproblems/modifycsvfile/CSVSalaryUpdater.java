package com.ioprogramming.csvdatahandling.intermediateproblems.modifycsvfile;
import java.io.*;
import java.util.*;
public class CSVSalaryUpdater {
    public void updateSalary(String inputFilePath, String outputFilePath, String department) {
        List<String[]> updatedRecords = new ArrayList<>();
        String line;
        String splitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            String header = br.readLine();
            updatedRecords.add(header.split(splitBy));

            while ((line = br.readLine()) != null) {
                String[] record = line.split(splitBy);
                if (record[2].equalsIgnoreCase(department)) {
                    double salary = Double.parseDouble(record[3]);
                    salary *= 1.10;
                    record[3] = String.format("%.2f", salary);
                }
                updatedRecords.add(record);
            }

        } catch (IOException e) {
            System.err.println("Error reading or writing the CSV file: " + e.getMessage());
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {
            for (String[] record : updatedRecords) {
                bw.write(String.join(",", record));
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing the updated CSV file: " + e.getMessage());
        }
    }
    public void readCSVFile(String filePath) {
        String line;
        String splitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(splitBy);
                String id = data[0];
                String name = data[1];
                String age = data[2];
                String marks = data[3];
                System.out.println("ID: " + id + ", Name: " + name + ", Department: " + age + ", Marks: " + marks);
            }
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        }
    }
}
