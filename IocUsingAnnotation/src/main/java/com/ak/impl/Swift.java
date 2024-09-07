package com.ak.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ak.classes.Infotainment;
import com.ak.interfaces.Car;

@Component("swift")
public class Swift implements Car {
	Infotainment i;
	String model;
	
	@Autowired
	public Swift(@Value("Swift car") String model,  @Qualifier("info") Infotainment i) {
		this.i = i;
		this.model = model;
	}
	
	@Override
	public void getDetails() {
		System.out.println("This is "+ model);
	}
	
	public void getInfo() {
		i.getInfo();
	}
}
