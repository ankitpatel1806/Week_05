package com.ioprogramming.json.practiceproblem.convertcartojson;

import org.json.JSONObject;

public class CarJsonMain {

    public static void main(String[] args) {
        Car car = new Car("Thousand Sunny", "One Piece", 2024, 200000.00);

        JSONObject carJson = car.toJSON();
        System.out.println(carJson.toString(4));
    }
}

