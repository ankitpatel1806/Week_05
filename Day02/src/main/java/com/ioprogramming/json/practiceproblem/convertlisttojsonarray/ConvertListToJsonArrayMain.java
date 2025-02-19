package com.ioprogramming.json.practiceproblem.convertlisttojsonarray;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;
import java.util.ArrayList;

public class ConvertListToJsonArrayMain {

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Ankit Patel", 25));
        people.add(new Person("Ankit Kuamr", 22));
        people.add(new Person("Anand Soni", 22));

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonArray = objectMapper.valueToTree(people);
            System.out.println(jsonArray.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
