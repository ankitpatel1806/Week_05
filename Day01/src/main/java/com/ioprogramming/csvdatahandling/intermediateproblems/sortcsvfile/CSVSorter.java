package com.ioprogramming.csvdatahandling.intermediateproblems.sortcsvfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CSVSorter {

    static class Employee {
        String name;
        String email;
        double salary;

        Employee(String name, String email, double salary) {
            this.name = name;
            this.email = email;
            this.salary = salary;
        }
    }

    public void sortCSV(String filePath) {
        List<Employee> employees = new ArrayList<>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                String email = data[1];
                double salary = Double.parseDouble(data[2]);
                employees.add(new Employee(name, email, salary));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        employees.sort((e1, e2) -> Double.compare(e2.salary, e1.salary));

        System.out.println("Top 5 Highest Paid Employees:");
        for (int i = 0; i < Math.min(5, employees.size()); i++) {
            Employee employee = employees.get(i);
            System.out.println(employee.name + ", " + employee.email + ", " + employee.salary);
        }
    }

    public static void main(String[] args) {
        CSVSorter sorter = new CSVSorter();
        sorter.sortCSV("C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day01\\src\\employee_data.csv");
    }
}

