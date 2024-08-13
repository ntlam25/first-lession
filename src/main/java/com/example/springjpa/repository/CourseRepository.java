package com.example.springjpa.repository;

import com.example.springjpa.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseRepository extends JpaRepository<Course,Long> {

}
