package com.ioprogramming.csvdatahandling.intermediateproblems.studentcsvfilter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StudentCSVFilter {

    public void filterCSVFile(String filePath) {
        String line;
        String splitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] studentData = line.split(splitBy);
                String id = studentData[0];
                String name = studentData[1];
                String age = studentData[2];
                int marks = Integer.parseInt(studentData[3]);
                if (marks > 80) {
                    System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Marks: " + marks);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        }
    }
}
