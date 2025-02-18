package com.ioprogramming.csvdatahandling.advancedproblems.mergetwocsv;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CSVMergerTest {

    private static final String STUDENTS1_CSV = "C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day01\\src\\student1.csv";
    private static final String STUDENTS2_CSV = "C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day01\\src\\student2.csv";
    private static final String OUTPUT_CSV = "C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day01\\src\\merge_students2.csv";

    @BeforeEach
    public void setUp() throws IOException {
        String students1CsvContent = "ID,Name,Age\n1,Reginald Hubbard,20\n2,Gregory Martin,21\n3,Patricia Gonzalez,22\n";
        String students2CsvContent = "ID,Marks,Grade\n1,85,A\n2,90,A+\n3,75,B\n";

        Files.write(Paths.get(STUDENTS1_CSV), students1CsvContent.getBytes());
        Files.write(Paths.get(STUDENTS2_CSV), students2CsvContent.getBytes());
    }

    @Test
    public void testMergeCSV() throws IOException {
        CSVMerger merger = new CSVMerger();

        // Merge the CSV files
        merger.mergeAndWriteCSV(STUDENTS1_CSV, STUDENTS2_CSV, OUTPUT_CSV);

        List<String> lines = Files.readAllLines(Paths.get(OUTPUT_CSV));

        assertEquals("ID,Name,Age,Marks,Grade", lines.get(0));

        assertEquals("1,Reginald Hubbard,20,85,A", lines.get(1));
        assertEquals("2,Gregory Martin,21,90,A+", lines.get(2));
        assertEquals("3,Patricia Gonzalez,22,75,B", lines.get(3));
    }

    @Test
    public void testMergeEmptyFiles() throws IOException {
        // Test merging with empty CSV files
        Files.write(Paths.get(STUDENTS1_CSV), "".getBytes());
        Files.write(Paths.get(STUDENTS2_CSV), "".getBytes());

        CSVMerger merger = new CSVMerger();
        merger.mergeAndWriteCSV(STUDENTS1_CSV, STUDENTS2_CSV, OUTPUT_CSV);

        // Verify that the output file is empty or contains only the header
        List<String> lines = Files.readAllLines(Paths.get(OUTPUT_CSV));
        assertEquals(1, lines.size()); // Only the header should be present
        assertEquals("ID,Name,Age,Marks,Grade", lines.get(0));
    }

    @Test
    public void testMergeWithMissingID() throws IOException {
        // Test merging when one file has an ID that's missing in the other
        String students2CsvWithMissingIdContent = "ID,Marks,Grade\n1,85,A\n2,90,A+\n4,70,C\n";
        Files.write(Paths.get(STUDENTS2_CSV), students2CsvWithMissingIdContent.getBytes());

        CSVMerger merger = new CSVMerger();
        merger.mergeAndWriteCSV(STUDENTS1_CSV, STUDENTS2_CSV, OUTPUT_CSV);

        // Verify the merged data and ensure that the missing ID (ID 4) in the first file does not appear in the output
        List<String> lines = Files.readAllLines(Paths.get(OUTPUT_CSV));

        assertEquals("ID,Name,Age,Marks,Grade", lines.get(0));
        assertEquals("1,Reginald Hubbard,20,85,A", lines.get(1));
        assertEquals("2,Gregory Martin,21,90,A+", lines.get(2));
        assertEquals("3,Patricia Gonzalez,22,0,", lines.get(3));
    }

    @Test
    public void testFilesDeletionAfterTest() {
        new File(STUDENTS1_CSV).delete();
        new File(STUDENTS2_CSV).delete();
        new File(OUTPUT_CSV).delete();
    }
}
