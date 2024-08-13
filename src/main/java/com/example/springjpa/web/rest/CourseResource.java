package com.example.springjpa.web.rest;

import com.example.springjpa.dto.request.CourseRequest;
import com.example.springjpa.dto.response.CourseResponse;
import com.example.springjpa.dto.response.StudentResponse;
import com.example.springjpa.entity.Student;
import com.example.springjpa.service.CourseService;
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
@RequestMapping("/courses")
public class CourseResource {

  private final CourseService service;

  public CourseResource(CourseService service) {
    this.service = service;
  }

  @PostMapping
  public CourseResponse create(@RequestBody CourseRequest request){
    return service.create(request);
  }
  @GetMapping("/{id}")
  public CourseResponse findById(@PathVariable Long id){
    return service.findById(id);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteById(@PathVariable Long id){
    service.deleteById(id);
  }
  @GetMapping("/{id}/students")
  public List<StudentResponse> findStudentByCourseId(@PathVariable Long id){
    return service.findStudentByCourseId(id);
  }
}
