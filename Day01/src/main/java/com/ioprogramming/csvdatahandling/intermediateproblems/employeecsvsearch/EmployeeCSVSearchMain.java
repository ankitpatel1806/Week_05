package com.ioprogramming.csvdatahandling.intermediateproblems.employeecsvsearch;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class EmployeeCSVSearchMain {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day01\\src\\employees_data.csv";
        EmployeeCSVSearch search = new EmployeeCSVSearch();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the employee to search: ");
        String searchName = scanner.nextLine();
        search.searchCSVFile(filePath, searchName);
    }
}
