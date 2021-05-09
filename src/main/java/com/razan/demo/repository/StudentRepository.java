package com.razan.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.razan.demo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, String> {

}
