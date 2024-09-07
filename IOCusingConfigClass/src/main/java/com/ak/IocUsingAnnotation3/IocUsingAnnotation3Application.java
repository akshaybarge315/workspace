package com.ak.IocUsingAnnotation3;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ak.IocUsingAnnotation3.classes.ConfigClassCustomer;
import com.ak.IocUsingAnnotation3.interfaces.Customer;

@SpringBootApplication
public class IocUsingAnnotation3Application {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ConfigClassCustomer.class);
		
		Customer gc = (Customer)ac.getBean("goldCustomer");
		Customer pc = (Customer)ac.getBean("platinumCustomer");
		
		gc.customerType();
		pc.customerType();
	}

}
