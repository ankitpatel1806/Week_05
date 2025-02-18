package com.ioprogramming.csvdatahandling.advancedproblems.csvdatahandling;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class CSVConverterTest {

    @Test
    public void testConvertCSVToStudents() {
        CSVToStudentConverter converter = new CSVToStudentConverter();
        List<Student> students = converter.convertCSVToStudents("C:\\Users\\yugap\\OneDrive\\Desktop\\cap\\Week_05\\Day01\\src\\students_detail.csv");

        assertNotNull(students);
        assertFalse(students.isEmpty());
        Student firstStudent = students.get(0);
        assertEquals(1, firstStudent.getId());
        assertEquals("Kathleen Delacruz", firstStudent.getName());
        assertEquals("cody47@example.net", firstStudent.getEmail());
        assertEquals(2.72, firstStudent.getGrade());

        Student lastStudent = students.get(students.size() - 1);
        assertEquals(100, lastStudent.getId());
        assertEquals("Angela Hill", lastStudent.getName());
        assertEquals("clarkshannon@example.net", lastStudent.getEmail());
        assertEquals(3.24, lastStudent.getGrade());
    }
}
