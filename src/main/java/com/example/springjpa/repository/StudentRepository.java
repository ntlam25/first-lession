package com.example.springjpa.repository;

import com.example.springjpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student,Long> {

}
