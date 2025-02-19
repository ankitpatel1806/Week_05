package com.ioprogramming.json.practiceproblem.mergejsonobjects;


import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MergeJsonTest {

    @Test
    public void testMergeJsonObjects() {
        JSONObject json1 = new JSONObject();
        json1.put("name", "Anand Soni");
        json1.put("age", 30);

        JSONObject json2 = new JSONObject();
        json2.put("email", "anandsoni541@gmail.com");
        json2.put("age", 22);

        JSONObject mergedJson = new JSONObject(json1, JSONObject.getNames(json1));
        for (String key : JSONObject.getNames(json2)) {
            mergedJson.put(key, json2.get(key));
        }

        JSONObject expectedJson = new JSONObject();
        expectedJson.put("name", "Anand Soni");
        expectedJson.put("age", 22);
        expectedJson.put("email", "anandsoni541@gmail.com");

        assertEquals(expectedJson.toString(), mergedJson.toString());
    }
}
