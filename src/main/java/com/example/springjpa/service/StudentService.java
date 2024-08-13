package com.example.springjpa.service;

import com.example.springjpa.dto.request.StudentRequest;
import com.example.springjpa.dto.response.CourseResponse;
import com.example.springjpa.dto.response.StudentResponse;
import com.example.springjpa.entity.Student;
import org.springframework.stereotype.Service;


public interface StudentService {
  StudentResponse create(StudentRequest request);
  StudentResponse findById(Long id);
  void deleteById(Long id);
  StudentResponse updateById(Long id, StudentRequest request);
  StudentResponse toResponse(Student student);
  CourseResponse enrollCourse(Long id, Long studentId);
}
