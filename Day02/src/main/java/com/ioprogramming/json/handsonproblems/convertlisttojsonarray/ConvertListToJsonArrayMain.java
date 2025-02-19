package com.ioprogramming.json.handsonproblems.convertlisttojsonarray;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.ArrayList;

public class ConvertListToJsonArrayMain {

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Ankit Patel", 30));
        people.add(new Person("Ankit Kumar", 25));
        people.add(new Person("Anand Soni", 28));

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonArray = objectMapper.valueToTree(people);
            System.out.println(jsonArray.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
