package org.progund.student;

import java.util.List;

public class StudentDemo {
  public static void main(String[] args) {
    if (args.length != 1) {
      System.err.println("you must provide a filename");
      System.exit(1);
    }
    List<Student> students = StudentParserManager.getStudents(args[0]);
    if (students == null) {
      System.out.println("No students found.");
      System.exit(2);
    }
    for (Student s : students) {
      System.out.println(s);
    }
  }
}
