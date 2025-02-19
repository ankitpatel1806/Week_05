package com.ioprogramming.json.practiceproblem.studentdetails;

import org.json.JSONObject;

public class StudentJsonMain {

    public static void main(String[] args) {
        String[] subjects = {"Java", "Python", "CyberSecurities"};
        Student student = new Student("Ankit Patel", 25, subjects);

        JSONObject studentJson = student.toJSON();
        System.out.println(studentJson.toString(5));
    }
}
