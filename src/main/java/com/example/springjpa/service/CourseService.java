package com.example.springjpa.service;

import com.example.springjpa.dto.request.CourseRequest;
import com.example.springjpa.dto.response.CourseResponse;
import com.example.springjpa.dto.response.StudentResponse;
import com.example.springjpa.entity.Course;
import com.example.springjpa.entity.Student;
import java.util.List;

public interface CourseService {
  List<StudentResponse> findStudentByCourseId(Long id);
  CourseResponse create(CourseRequest request);
  CourseResponse findById(Long id);
  void deleteById(Long id);
  CourseResponse toResponse(Course course);
}
