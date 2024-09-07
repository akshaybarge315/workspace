package com.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

	@RequestMapping("/")
	public String collectData() {
		return "collect-info";
	}
	
	@RequestMapping("FormSubmit")
	public String sendData(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("sem") String sem, @RequestParam("marks") String marks) {
		
		StudentDataManager sdm = new StudentDataManager();
		sdm.connect();
		sdm.addStudent(id, name, email, sem, marks);
		
		return "data-added";
	}
}
