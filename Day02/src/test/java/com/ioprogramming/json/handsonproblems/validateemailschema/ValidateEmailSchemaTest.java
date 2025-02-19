package com.ioprogramming.json.handsonproblems.validateemailschema;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ValidateEmailSchemaTest {

    @Test
    public void testValidEmail() throws IOException, ProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode emailSchemaNode = objectMapper.readTree(new File("C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day02\\src\\email.json"));
        JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
        JsonSchema emailSchema = factory.getJsonSchema(emailSchemaNode);

        String jsonData = "{\"email\": \"yugap1806@gmail.com\"}";
        JsonNode dataNode = objectMapper.readTree(jsonData);

        assertTrue(emailSchema.validate(dataNode).isSuccess());
    }

    @Test
    public void testInvalidEmail() throws IOException, ProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode emailSchemaNode = objectMapper.readTree(new File("C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day02\\src\\email.json"));
        JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
        JsonSchema emailSchema = factory.getJsonSchema(emailSchemaNode);

        String jsonData = "{\"email\": \"email test\"}";
        JsonNode dataNode = objectMapper.readTree(jsonData);

        assertFalse(emailSchema.validate(dataNode).isSuccess());
    }
}
