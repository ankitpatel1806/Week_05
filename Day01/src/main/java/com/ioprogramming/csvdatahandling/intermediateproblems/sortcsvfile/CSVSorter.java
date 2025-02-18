package com.ioprogramming.csvdatahandling.intermediateproblems.sortcsvfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CSVSorter {

    static class Employee {
        int id;
        String name;
        String department;
        double salary;

        Employee(String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return id + ", " + name + ", " + department + ", " + salary;
        }
    }

    public void sortCSV(String filePath) {
        List<Employee> employees = new ArrayList<>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String department = data[2];
                try {
                    double salary = Double.parseDouble(data[3]);
                    employees.add(new Employee(name, department, salary));
                } catch (NumberFormatException e) {
                    System.err.println("Invalid salary value: " + data[3]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        employees.sort((e1, e2) -> Double.compare(e2.salary, e1.salary));

        System.out.println("Top 5 Highest Paid Employees:");
        for (int i = 0; i < Math.min(5, employees.size()); i++) {
            System.out.println(employees.get(i));
        }
    }

    public static void main(String[] args) {
        CSVSorter sorter = new CSVSorter();
        sorter.sortCSV("C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day01\\src\\employee_data.csv"); // Update the file path
    }
}
