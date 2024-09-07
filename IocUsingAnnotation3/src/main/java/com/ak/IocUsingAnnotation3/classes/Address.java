package com.ak.IocUsingAnnotation3.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Address {
	public String city;
	public String state;
	
	@Autowired
	public Address(@Value("Navi Mumbai") String city, @Value("Maharashtra") String state) {
		this.city = city;
		this.state = state;
	}
}
