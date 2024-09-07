package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("trainer")
public class TrainerController {
	@RequestMapping("firstRequest")
	public String firstReq() {
		return "trainer-Page";
	}
	
	@RequestMapping("secondRequest")
	public String secondReq() {
		return "trainer-info";
	}
	
//	Apart from above two request it showing this error page
	@RequestMapping("/**")
	public String error() {
		return "error-page";
	}
}
