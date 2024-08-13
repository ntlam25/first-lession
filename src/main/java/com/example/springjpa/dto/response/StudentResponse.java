package com.example.springjpa.dto.response;


import com.example.springjpa.entity.Course;
import java.util.List;

public class StudentResponse {

  private Long id;
  private String name;
  private Integer age;
  private Double gpa;
  private String hobbies;
  private List<CourseResponse> course;

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

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Double getGpa() {
    return gpa;
  }

  public void setGpa(Double gpa) {
    this.gpa = gpa;
  }

  public String getHobbies() {
    return hobbies;
  }

  public void setHobbies(String hobbies) {
    this.hobbies = hobbies;
  }

  public List<CourseResponse> getCourse() {
    return course;
  }

  public void setCourse(List<CourseResponse> course) {
    this.course = course;
  }
}
