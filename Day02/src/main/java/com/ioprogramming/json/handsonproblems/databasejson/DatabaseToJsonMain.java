package com.ioprogramming.json.handsonproblems.databasejson;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class DatabaseToJsonMain {

    private static final String URL = "jdbc:mysql://localhost:3306/ankitdb";
    private static final String USER = "root";
    private static final String PASSWORD = "Passw0rd@1806";

    public static String generateJsonReport() {
        List<Map<String, Object>> userList = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM users")) {

            while (rs.next()) {
                Map<String, Object> user = new HashMap<>();
                user.put("id", rs.getInt("id"));
                user.put("name", rs.getString("name"));
                user.put("age", rs.getInt("age"));
                user.put("email", rs.getString("email"));
                userList.add(user);
            }

            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(userList);

        } catch (Exception e) {
            e.printStackTrace();
            return "{}";
        }
    }

    public static void main(String[] args) {
        String jsonReport = generateJsonReport();
        System.out.println("JSON Report:\n" + jsonReport);
    }
}
