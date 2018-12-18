package org.progund.student;

public class Student {
  private String name;
  private String mail;

  public Student(String name, String mail) {
    this.name = name;
    this.mail = mail;
  }

  public String name() {
    return name;
  }

  public String mail() {
    return mail;
  }

  public String toString() {
    return name + " <" + mail + ">";
  }
}
