package com.ioprogramming.json.practiceproblem.mergejsonobjects;

import org.json.JSONObject;

public class MergeJsonMain {

    public static void main(String[] args) {
        JSONObject json1 = new JSONObject();
        json1.put("name", "Ankit Kumar");
        json1.put("age", 30);
        JSONObject json2 = new JSONObject();
        json2.put("email", "ankitkumar7941@gmail.com");
        json2.put("age", 31);

        JSONObject mergedJson = new JSONObject(json1, JSONObject.getNames(json1));
        for (String key : JSONObject.getNames(json2)) {
            mergedJson.put(key, json2.get(key));
        }

        System.out.println("Merged JSON: " + mergedJson.toString(4));
    }
}
