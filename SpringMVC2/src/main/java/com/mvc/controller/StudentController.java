package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("student")
public class StudentController {
	@RequestMapping("firstRequest")
	public String firstReq() {
		return "student-Page";
	}
	
	@RequestMapping("secondRequest")
	public String secondReq() {
		return "student-info";
	}
}
