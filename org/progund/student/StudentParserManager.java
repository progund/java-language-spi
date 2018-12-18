package org.progund.student;

import java.util.List;
import java.util.ArrayList;
import java.util.ServiceLoader;

public class StudentParserManager {

  private static ServiceLoader<StudentParser> loader
    = ServiceLoader.load(StudentParser.class);
  
  public static List<Student> getStudents(String fileName) {

    List<Student> students = new ArrayList<>();
    for (StudentParser parser : loader) {
      students = parser.parseStudents(fileName);
      if (students != null) {
        return students;
      }
    }
    return students;
  }

}
