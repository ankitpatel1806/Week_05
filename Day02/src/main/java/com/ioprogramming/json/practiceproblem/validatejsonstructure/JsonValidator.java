package com.ioprogramming.json.practiceproblem.validatejsonstructure;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
public class JsonValidator {

    public static boolean isValidJsonStructure(String jsonString) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonString);
            if (!rootNode.has("name") || !rootNode.get("name").isTextual()) {
                return false;
            }
            if (!rootNode.has("email") || !rootNode.get("email").isTextual()) {
                return false;
            }
            if (!rootNode.has("age") || !rootNode.get("age").isInt()) {
                return false;
            }
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
