package com.ioprogramming.json.practiceproblem.convertlisttojsonarray;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.ArrayList;

public class ConvertListToJsonArrayTest {

    @Test
    public void testConvertListToJsonArray() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Ankit Kumar", 25));
        people.add(new Person("Ankit Patel", 22));
        people.add(new Person("Anand Soni", 22));

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonArray = objectMapper.valueToTree(people);

            String expectedJson = "[{\"name\":\"Ankit Kumar\",\"age\":25},{\"name\":\"Ankit Patel\",\"age\":22},{\"name\":\"Anand Soni\",\"age\":22}]";
            assertEquals(expectedJson, jsonArray.toString());
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception should not occur");
        }
    }
}
