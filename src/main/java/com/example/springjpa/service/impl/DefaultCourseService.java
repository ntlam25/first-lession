package com.example.springjpa.service.impl;

import com.example.springjpa.dto.request.CourseRequest;
import com.example.springjpa.dto.response.CourseResponse;
import com.example.springjpa.dto.response.StudentResponse;
import com.example.springjpa.entity.Course;
import com.example.springjpa.entity.Student;
import com.example.springjpa.exception.ResourceNotFoundException;
import com.example.springjpa.repository.CourseRepository;
import com.example.springjpa.service.CourseService;
import com.example.springjpa.service.StudentService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DefaultCourseService implements CourseService {

  private final CourseRepository repository;
  private final StudentService studentService;
  public DefaultCourseService(CourseRepository repository, StudentService studentService) {
    this.repository = repository;
    this.studentService = studentService;
  }

  @Override
  public List<StudentResponse> findStudentByCourseId(Long id) {
    Course course = repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Could not found course with id " + id));
    List<Student> students = course.getStudents();
    return students.stream().map(studentService::toResponse).toList();
  }

  @Override
  public CourseResponse create(CourseRequest request) {
    Course course = new Course();
    course.setName(request.getName());
    return toResponse(course);
  }


  @Override
  public CourseResponse findById(Long id) {
    Course course = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Could not found course with id "+id));
    return toResponse(course);
  }

  @Override
  public void deleteById(Long id) {
    Course course = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Could not found course with id "+id));
    repository.delete(course);
  }
  public CourseResponse toResponse(Course course) {
    Course savedCourse = repository.save(course);
    CourseResponse response = new CourseResponse();
    response.setId(savedCourse.getId());
    response.setName(savedCourse.getName());
    response.setStudentEnroll(savedCourse.getStudents());
    return response;
  }
}
