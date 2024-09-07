package com.ak.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("info")
public class Infotainment {
	String brand;
	
	public void getInfo() {
		System.out.println("This is car has "+ brand + " Infotainment system");
	}
	
	@Autowired
	public Infotainment(@Value("sony") String brand) {
		this.brand = brand;
	}
	
}
