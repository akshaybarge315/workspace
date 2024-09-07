package com.ak.impl;

import com.ak.classes.Infotainment;
import com.ak.interfaces.Car;

public class Polo implements Car {
	Infotainment i;
	String model;
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public void setI(Infotainment i) {
		this.i = i;
	}

	@Override
	public void getDetails() {
		System.out.println("This is " + model);
	}

	@Override
	public void getInfo() {
		i.getInfo();
	}

}
