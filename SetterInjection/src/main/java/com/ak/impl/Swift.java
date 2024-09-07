package com.ak.impl;

import com.ak.classes.Infotainment;
import com.ak.interfaces.Car;

public class Swift implements Car {
	Infotainment i;
	String model;
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public void setI(Infotainment i) {
		this.i = i;
	}
	
	public void start() {
		System.out.println("This is init method");
	}

	@Override
	public void getDetails() {
		System.out.println("This is " + model);
	}

	@Override
	public void getInfo() {
		i.getInfo();
	}
	
	public void end() {
		System.out.println("This is destroy method");
	}

}
