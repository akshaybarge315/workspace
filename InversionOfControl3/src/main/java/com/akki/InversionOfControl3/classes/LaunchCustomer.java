package com.akki.InversionOfControl3.classes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.akki.InversionOfControl3.interfaces.Customer;

public class LaunchCustomer {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		Customer gc = (Customer) ac.getBean("gc");
		Customer pc = (Customer) ac.getBean("pc");
		
		System.out.println(gc.getMembershipType());
		System.out.println(pc.getMembershipType());
	}

}
