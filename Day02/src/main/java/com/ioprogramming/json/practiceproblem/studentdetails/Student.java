package com.ioprogramming.json.practiceproblem.studentdetails;
import org.json.JSONArray;
import org.json.JSONObject;
public class Student {
    private String name;
    private int age;
    private String[] subjects;
    public Student(String name, int age, String[] subjects) {
        this.name = name;
        this.age = age;
        this.subjects = subjects;
    }
    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("age", age);
        JSONArray subjectsArray = new JSONArray(subjects);
        jsonObject.put("subjects", subjectsArray);
        return jsonObject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
    }
}
