package com.akki.InversionOfControl3.impl;

import com.akki.InversionOfControl3.interfaces.Customer;

public class PlatinumCustomer implements Customer {
	
	String type = "Platinum Customer";
	
	public PlatinumCustomer(String type) {
		this.type = type;
	}

	@Override
	public String getMembershipType() {
		return "This is a : " + type;
	}

}
