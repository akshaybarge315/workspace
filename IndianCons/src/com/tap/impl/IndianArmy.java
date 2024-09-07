package com.tap.impl;

import com.tap.classes.President;
import com.tap.interfaces.Services;

public class IndianArmy implements Services {

	@Override
	public void addressPresident() {
		President p = President.getPresident();
//		System.out.println("President is" + p.name);
		System.out.println(p);
	}

}
