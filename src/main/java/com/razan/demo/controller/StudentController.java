package com.razan.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.razan.demo.entity.Student;
import com.razan.demo.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;
	
	@PostMapping("/regstudent")
	public Student regStudent(@RequestBody Student std) {
		return service.regStudent(std);
	}
	
}
