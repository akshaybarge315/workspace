package com.tap.InversionOfControl1.impl;

import org.springframework.context.ApplicationContext;

import com.tap.InversionOfControl1.classes.President;
import com.tap.InversionOfControl1.interfaces.Services;

public class IndianAirForce implements Services {

	ApplicationContext ac;
	
	public IndianAirForce(ApplicationContext ac) {
		this.ac = ac;
	}

	@Override
	public void addressPresident() {
		President p = (President) ac.getBean("president");
		System.out.println(p);		
	}

}
