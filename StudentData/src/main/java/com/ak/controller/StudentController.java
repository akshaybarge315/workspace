package com.ak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ak.entity.StudentEntity;
import com.ak.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService ss;
	
	@GetMapping("/student")
	public List<StudentEntity> getAllStudent() {
		return ss.getAllStudent();
	}
}
