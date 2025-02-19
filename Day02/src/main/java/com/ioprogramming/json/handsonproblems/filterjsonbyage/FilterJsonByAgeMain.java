package com.ioprogramming.json.handsonproblems.filterjsonbyage;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

public class FilterJsonByAgeMain {

    public static void main(String[] args) {
        String json = "[{\"name\":\"Ankit Patel\",\"age\":30},{\"name\":\"Ankit Kumar\",\"age\":22},{\"name\":\"Anand Soni\",\"age\":28}]";

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootArray = objectMapper.readTree(json);
            List<Person> filteredPeople = new ArrayList<>();

            for (JsonNode node : rootArray) {
                String name = node.get("name").asText();
                int age = node.get("age").asInt();

                if (age > 25) {
                    filteredPeople.add(new Person(name, age));
                }
            }

            for (Person person : filteredPeople) {
                System.out.println("Name: " + person.getName() + ", Age: " + person.getAge());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

