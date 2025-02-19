package com.ioprogramming.json.iplandcensoranalyzer;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class IPLProcessor {

    public static void main(String[] args) {
        IPLProcessor processor = new IPLProcessor();

        // Example: Processing JSON and CSV files
        try {
            processor.processJsonFile("C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day02\\src\\inputjson.json", "C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day02\\src\\outputjson.json");
            processor.processCsvFile("C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day02\\src\\input.csv", "C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day02\\src\\output.csv");
            System.out.println("Processing completed successfully.");
        } catch (IOException e) {
            System.out.println("Error during processing: " + e.getMessage());
        }
    }

    public void processJsonFile(String inputFilePath, String outputFilePath) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(inputFilePath)));
        JSONArray jsonArray = new JSONArray(content);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject match = jsonArray.getJSONObject(i);
            maskTeamNames(match);
            redactPlayerOfMatch(match);
        }
        Files.write(Paths.get(outputFilePath), jsonArray.toString().getBytes());
    }

    public void processCsvFile(String inputFilePath, String outputFilePath) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(inputFilePath));
        List<String> processedLines = new ArrayList<>();
        processedLines.add(lines.get(0)); // Add header line
        for (int i = 1; i < lines.size(); i++) {
            String[] fields = lines.get(i).split(",");
            fields[1] = maskTeamName(fields[1]);
            fields[2] = maskTeamName(fields[2]);
            fields[6] = "REDACTED";
            processedLines.add(String.join(",", fields));
        }
        Files.write(Paths.get(outputFilePath), processedLines);
    }

    private void maskTeamNames(JSONObject match) {
        match.put("team1", maskTeamName(match.getString("team1")));
        match.put("team2", maskTeamName(match.getString("team2")));
    }

    private String maskTeamName(String teamName) {
        return teamName.replaceAll("(.+)(\\s.+)", "$1 ***");
    }

    private void redactPlayerOfMatch(JSONObject match) {
        match.put("player_of_match", "REDACTED");
    }
}
