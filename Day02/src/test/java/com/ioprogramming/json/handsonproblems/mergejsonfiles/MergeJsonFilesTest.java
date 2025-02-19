package com.ioprogramming.json.handsonproblems.mergejsonfiles;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MergeJsonFilesTest {

    @Test
    public void testMergeJsonFiles() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode file1 = objectMapper.readTree(new File("C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day02\\src\\file_01.json"));
            JsonNode file2 = objectMapper.readTree(new File("C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day02\\src\\file_02.json"));

            JsonNode merged = file1.deepCopy();
            ((com.fasterxml.jackson.databind.node.ObjectNode) merged).setAll((com.fasterxml.jackson.databind.node.ObjectNode) file2);

            String expectedJson = "{\"name\":\"Ankit Patel\",\"age\":25,\"email\":\"yugap1806@gmail.com\",\"address\":\"007 Land of Wano\"}";
            assertEquals(expectedJson, merged.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
