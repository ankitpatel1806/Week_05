package com.ioprogramming.csvdatahandling.intermediateproblems.sortcsvfile;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CSVSorterTest {

    @Test
    void testEmployeeSorting() {
        CSVSorter sorter = new CSVSorter();
        CSVSorter.Employee e1 = new CSVSorter.Employee("Ankit Patel", "yugap1806@gmail.com", 50000);
        CSVSorter.Employee e2 = new CSVSorter.Employee("Anand Soni", "ankitkumar@gmail.com", 60000);
        CSVSorter.Employee e3 = new CSVSorter.Employee("Ankit Kumar", "Anand9175@gmail.com", 55000);

        assertTrue(e2.salary > e1.salary);
        assertTrue(e2.salary > e3.salary);
    }
}
