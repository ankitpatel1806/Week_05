package com.ioprogramming.json.handsonproblems.convertcsvtojson;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ConvertCsvToJsonTest {

    @Test
    public void testConvertCsvToJson() {
        try {
            CsvMapper csvMapper = new CsvMapper();
            CsvSchema csvSchema = CsvSchema.emptySchema().withHeader();
            List<Object> records = csvMapper.readerFor(Object.class).with(csvSchema).readValues(new File("C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day02\\src\\data.csv")).readAll();

            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(records);

            String expectedJson = "[{\"name\":\"Ankit\",\"age\":30,\"email\":\"yugap1806@gmail.com\"},"
                    + "{\"name\":\"Anand\",\"age\":25,\"email\":\"ankit475@gmail.com\"},"
                    + "{\"name\":\"Avinash\",\"age\":28,\"email\":\"avinash45@outlook.com\"}]";
            assertNotEquals(expectedJson, json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
