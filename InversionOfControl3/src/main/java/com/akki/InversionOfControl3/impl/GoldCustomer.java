package com.akki.InversionOfControl3.impl;

import com.akki.InversionOfControl3.interfaces.Customer;

public class GoldCustomer implements Customer {
	
	String type;
	
	public GoldCustomer(String type) {
		this.type = type;
	}
	
	@Override
	public String getMembershipType() {
		return "This is a : " + type;
	}

}
