package com.bar.parser;

import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;

import org.progund.student.Student;
import org.progund.student.StudentParser;

public class StudentCsvParser implements StudentParser {
  public List<Student> parseStudents(String fileName) {

    if (!fileName.endsWith(".csv")) {
      System.err.println("File name must end with .csv: " + fileName);
      return null;
    }
    
    System.out.println("parsing using csv parser");
    List<Student> students = new ArrayList<Student>();
    try {
      students = Files.lines(Paths.get(fileName))
        .map(s -> new Student(s.split(",")[0], s.split(",")[1]))
        .collect(Collectors.toList());
    } catch (IOException e) {
      System.err.println("can't parse " + fileName + ": " + e.getMessage());
    }
    
    return students;
  }
}
