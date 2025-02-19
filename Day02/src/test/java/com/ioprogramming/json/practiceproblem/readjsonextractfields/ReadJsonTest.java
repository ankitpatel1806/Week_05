package com.ioprogramming.json.practiceproblem.readjsonextractfields;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReadJsonTest {

    @Test
    public void testExtractFields() {
        String jsonString = "{\"name\":\"Ankit Patel\",\"email\":\"yugap1806@gmail.com\",\"age\":25,\"address\":\"007 WanoLand\"}";

        JSONObject jsonObject = new JSONObject(jsonString);

        String name = jsonObject.getString("name");
        String email = jsonObject.getString("email");

        assertEquals("Ankit Patel", name);
        assertEquals("yugap1806@gmail.com", email);
    }
}
