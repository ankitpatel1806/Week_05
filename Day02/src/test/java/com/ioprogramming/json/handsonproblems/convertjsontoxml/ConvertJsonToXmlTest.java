package com.ioprogramming.json.handsonproblems.convertjsontoxml;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConvertJsonToXmlTest {

    @Test
    public void testConvertJsonToXml() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(new File("C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day02\\src\\Sample.json"));

            XmlMapper xmlMapper = new XmlMapper();
            String xml = xmlMapper.writeValueAsString(jsonNode);

            String expectedXml = "<?xml version='1.0' encoding='UTF-8'?>\n<root>\n  <name>Ankit</name>\n  <age>25</age>\n  <email>yugap1806@gmail.com</email>\n  <address>\n    <street>007 Land of Wano</street>\n    <city>GrandLine</city>\n  </address>\n</root>";
            assertEquals(expectedXml, xml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
