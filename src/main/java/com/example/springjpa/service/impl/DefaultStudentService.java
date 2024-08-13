package com.example.springjpa.service.impl;

import com.example.springjpa.dto.request.StudentRequest;
import com.example.springjpa.dto.response.CourseResponse;
import com.example.springjpa.dto.response.StudentResponse;
import com.example.springjpa.entity.Course;
import com.example.springjpa.entity.Student;
import com.example.springjpa.exception.ResourceNotFoundException;
import com.example.springjpa.repository.CourseRepository;
import com.example.springjpa.repository.StudentRepository;
import com.example.springjpa.service.CourseService;
import com.example.springjpa.service.StudentService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DefaultStudentService implements StudentService {
  private final StudentRepository repository;
  private final CourseRepository courseRepository;

  public DefaultStudentService(StudentRepository repository, CourseRepository courseRepository) {
    this.repository = repository;
    this.courseRepository = courseRepository;
  }

  @Override
  public StudentResponse create(StudentRequest request) {
//    Course courseRef = courseRepository.findById(request.getCourseId()).orElseThrow(() -> new BadRequestException("Could not found course with ID: " + request.getCourseId()));
//    try {
//      courseRef.getId();
//    } catch (EntityNotFoundException e) {
//      System.err.println("Class with ID " + request.getCourseId() + " not found.");
//      throw new BadRequestException("Class not found for ID: " + request.getCourseId(), e);
//    }

    Student student = new Student();
    student.setName(request.getName());
    student.setAge(request.getAge());
    student.setGpa(request.getGpa());
    student.setHobbies(request.getHobbies());

    return toResponse(student);
  }

  @Override
  public StudentResponse findById(Long id) {
    Student student = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Khong tim thay hoc sinh voi id " + id + "." ));

    return toResponse(student);
  }

  @Override
  public void deleteById(Long id) {
    Student student = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Khong tim thay hoc sinh voi id " + id + "." ));

    repository.delete(student);
  }

  @Override
  public StudentResponse updateById(Long id, StudentRequest request) {
    Student student = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Khong tim thay hoc sinh voi id " + id + "." ));
    student.setName(request.getName());
    student.setAge(request.getAge());
    student.setGpa(request.getGpa());
    student.setHobbies(request.getHobbies());

    return toResponse(student);
  }

  @Override
  public StudentResponse toResponse(Student student) {
    Student savedStudent = repository.save(student);

    StudentResponse response = new StudentResponse();
    response.setId(savedStudent.getId());
    response.setName(savedStudent.getName());
    response.setAge(savedStudent.getAge());
    response.setGpa(savedStudent.getGpa());
    response.setHobbies(savedStudent.getHobbies());


    List<CourseResponse> courseResponse = new ArrayList<>();
    for (Course c : savedStudent.getCourse()  ) {
      CourseResponse res = new CourseResponse();
      res.setId(c.getId());
      res.setName(c.getName());
      courseResponse.add(res);
    }
//    courseResponse.setId(savedStudent.getCourse().getId());
//    courseResponse.setName(savedStudent.getCourse().getName());
    response.setCourse(courseResponse);
    return response;
  }

  @Override
  public CourseResponse enrollCourse(Long id, Long studentId) {
    Course course = courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Khong tim thay khoa hoc voi id " + id + "." ));
    Student student = repository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Khong tim thay hoc sinh voi id " + studentId + "." ));
    List<Student> students = course.getStudents();
    students.add(student);
    course.setStudents(students);
    CourseResponse res = new CourseResponse();
    res.setId(course.getId());
    res.setName(course.getName());
    res.setStudentEnroll(course.getStudents());
    courseRepository.save(course);
    return res;
  }
}
