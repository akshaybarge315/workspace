package com.ak.IocUsingAnnotation3.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ak.IocUsingAnnotation3.classes.Address;
import com.ak.IocUsingAnnotation3.interfaces.Customer;

@Component
public class GoldCustomer implements Customer {
	Address ad;
	String type;
	
	public GoldCustomer(@Qualifier("address") Address ad, @Value("Gold Customer") String type) {
		this.ad = ad;
		this.type = type;
	}
	
	@Override
	public void customerType() {
		System.out.println("Customer type is : "+type+" from "+ad.city +", "+ad.state);
	}

}
