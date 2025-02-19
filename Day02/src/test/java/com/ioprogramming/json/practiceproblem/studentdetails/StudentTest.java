package com.ioprogramming.json.practiceproblem.studentdetails;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTest {

    @Test
    public void testStudentJsonCreation() {
        String[] subjects = {"Java", "Python", "CyberSecurities"};
        Student student = new Student("Ankit Patel", 25, subjects);

        JSONObject expectedJson = new JSONObject();
        expectedJson.put("name", "Ankit Patel");
        expectedJson.put("age", 25);
        expectedJson.put("subjects", subjects);

        JSONObject studentJson = student.toJSON();

        assertEquals(expectedJson.toString(), studentJson.toString());
    }
}
