package com.ioprogramming.json.practiceproblem.readjsonextractfields;

import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadJsonMain {

    public static void main(String[] args) {
        try {
            String jsonString = new String(Files.readAllBytes(Paths.get("C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day02\\src\\user_data.json")));

            JSONObject jsonObject = new JSONObject(jsonString);

            String name = jsonObject.getString("name");
            String email = jsonObject.getString("email");

            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
