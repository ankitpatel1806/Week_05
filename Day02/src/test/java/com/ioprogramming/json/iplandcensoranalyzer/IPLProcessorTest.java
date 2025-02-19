package com.ioprogramming.json.iplandcensoranalyzer;


import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class IPLProcessorTest {

    @Test
    void testProcessJsonFile() throws IOException {
        IPLProcessor processor = new IPLProcessor();
        processor.processJsonFile("C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day02\\src\\inputjson.json", "C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day02\\src\\outputjson.json");

        File outputFile = new File("C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day02\\src\\outputjson.json");
        assertTrue(outputFile.exists());
    }

    @Test
    void testProcessCsvFile() throws IOException {
        IPLProcessor processor = new IPLProcessor();
        processor.processCsvFile("C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day02\\src\\input.csv", "C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day02\\src\\output.csv");

        File outputFile = new File("C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day02\\src\\output.csv");
        assertTrue(outputFile.exists());
    }
}
