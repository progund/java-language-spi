package com.foo.parser;

import java.util.List;
import java.util.ArrayList;

import org.json.*;

import java.io.IOException;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.progund.student.Student;
import org.progund.student.StudentParser;

public class StudentJsonParser implements StudentParser {

  public List<Student> parseStudents(String fileName) {
    if (!fileName.endsWith(".json")) {
      System.err.println("File must end with .json: " + fileName);
      return null;
    }
    System.out.println("parsing using json parser");
    List<Student> students = null;
    try {
      JSONArray jsonArray
        = new JSONArray(new String(Files.readAllBytes(Paths.get(fileName)),
                                 StandardCharsets.UTF_8));
      students = new ArrayList<>();
      for(int i = 0; i < jsonArray.length(); i++) {
        JSONObject jsonObject = jsonArray.getJSONObject(i);
        String name = jsonObject.getString("name");
        String mail = jsonObject.getString("mail");
        students.add(new Student(name, mail));
      }
    } catch (IOException e) {
      System.err.println("can't parse json in " + fileName + ": " +
                         e.getMessage());
    }
    return students;
  }
}
