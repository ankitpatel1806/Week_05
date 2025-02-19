package com.ioprogramming.json.handsonproblems.filterjsonbyage;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilterJsonByAgeTest {

    @Test
    public void testFilterJsonByAge() {
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

            assertEquals(2, filteredPeople.size());
            assertEquals("Ankit Patel", filteredPeople.get(0).getName());
            assertEquals(30, filteredPeople.get(0).getAge());
            assertEquals("Anand Soni", filteredPeople.get(1).getName());
            assertEquals(28, filteredPeople.get(1).getAge());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
