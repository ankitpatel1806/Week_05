package com.ioprogramming.json.practiceproblem.convertcartojson;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    @Test
    public void testCarJsonCreation() {
        Car car = new Car("Thousand Sunny", "One Piece", 2024, 200000.00);

        JSONObject expectedJson = new JSONObject();
        expectedJson.put("make", "Thousand Sunny");
        expectedJson.put("model", "One Piece");
        expectedJson.put("year", 2024);
        expectedJson.put("price", 200000.00);

        JSONObject carJson = car.toJSON();

        assertEquals(expectedJson.toString(), carJson.toString());
    }
}
