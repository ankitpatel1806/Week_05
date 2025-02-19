package com.ioprogramming.json.handsonproblems.validateemailschema;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import java.io.File;
import java.io.IOException;

public class ValidateEmailSchemaMain {

    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode emailSchemaNode = objectMapper.readTree(new File("C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day02\\src\\email.json"));
            JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
            JsonSchema emailSchema = factory.getJsonSchema(emailSchemaNode);

            String jsonData = "{\"email\": \"yugap1806@gmail.com\"}";
            JsonNode dataNode = objectMapper.readTree(jsonData);

            if (emailSchema.validate(dataNode).isSuccess()) {
                System.out.println("Valid email");
            } else {
                System.out.println("Invalid email");
            }

        } catch (IOException | ProcessingException e) {
            e.printStackTrace();
        }
    }
}
