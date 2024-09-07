package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String firstCall() {
		return "home-page";
	}
	
//	It give error because of ambugity problem
	@RequestMapping("firstRequest")
	public String trainerHome() {
		return "trainer-home";
	}
	@RequestMapping("firstRequest")
	public String studentHome() {
		return "student-home";
	}
}
