package com.razan.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.razan.demo.entity.Student;
import com.razan.demo.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repository;
	
	public Student regStudent(Student std) {
		return repository.save(std);
	}
	
	public Student getStudent(String sid) {
		return repository.findById(sid).orElse(null);
	}
}
