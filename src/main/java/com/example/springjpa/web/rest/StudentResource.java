package com.example.springjpa.web.rest;

import com.example.springjpa.dto.request.StudentRequest;
import com.example.springjpa.dto.response.CourseResponse;
import com.example.springjpa.dto.response.StudentResponse;
import com.example.springjpa.entity.Course;
import com.example.springjpa.entity.Student;
import com.example.springjpa.service.StudentService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
  @RequestMapping("/students")
public class StudentResource {
  private final StudentService service;

  public StudentResource(StudentService service) {
    this.service = service;
  }

  @PostMapping
  public StudentResponse create(@RequestBody StudentRequest request){
    return service.create(request);
  }

  @GetMapping("/{id}")
  public StudentResponse findById(@PathVariable Long id){
    return service.findById(id);
  }
  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteById(@PathVariable Long id){
    service.deleteById(id);
  }

  @PutMapping("/{id}")
  public StudentResponse updateById(@PathVariable Long id, @RequestBody StudentRequest request){
    return service.updateById(id,request);
  }
  @PostMapping("/{id}/course/{courseId}")
  public CourseResponse enrollCourse(@PathVariable Long id, @PathVariable Long courseId){
    return service.enrollCourse(courseId,id);
  }
}
