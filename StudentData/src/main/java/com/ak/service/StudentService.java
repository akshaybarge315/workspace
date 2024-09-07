package com.ak.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ak.entity.StudentEntity;
import com.ak.repo.StudentRepo;

@Component
public class StudentService {
	@Autowired
	StudentRepo sr;

	public List<StudentEntity> getAllStudent() {
		List<StudentEntity> list = (List<StudentEntity>) sr.findAll();
		return list;
	}
}
