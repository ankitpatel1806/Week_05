package com.ioprogramming.json.handsonproblems.mergejsonfiles;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class MergeJsonFilesMain {

    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode file1 = objectMapper.readTree(new File("file1.json"));
            JsonNode file2 = objectMapper.readTree(new File("file2.json"));

            JsonNode merged = file1.deepCopy();
            ((com.fasterxml.jackson.databind.node.ObjectNode) merged).setAll((com.fasterxml.jackson.databind.node.ObjectNode) file2);

            System.out.println(merged.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
