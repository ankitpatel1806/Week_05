package com.ioprogramming.json.handsonproblems.convertcsvtojson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ConvertCsvToJsonExample {

    public static void main(String[] args) {
        try {
            CsvMapper csvMapper = new CsvMapper();
            CsvSchema csvSchema = CsvSchema.emptySchema().withHeader();
            List<Object> records = csvMapper.readerFor(Object.class).with(csvSchema).readValues(new File("C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day02\\src\\data.csv")).readAll();

            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(records);

            System.out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
