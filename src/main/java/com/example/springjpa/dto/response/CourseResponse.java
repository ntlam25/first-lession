package com.example.springjpa.dto.response;

import com.example.springjpa.entity.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

public class CourseResponse {
  private Long id;
  private String name;
  private List<Student> studentEnroll;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Student> getStudentEnroll() {
    return studentEnroll;
  }

  public void setStudentEnroll(List<Student> studentEnroll) {
    this.studentEnroll = studentEnroll;
  }
}
