package com.ak.IocUsingAnnotation3;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ak.IocUsingAnnotation3.interfaces.Customer;

@SpringBootApplication
public class IocUsingAnnotation3Application {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		Customer gc = (Customer)ac.getBean("goldCustomer");
		Customer pc = (Customer)ac.getBean("platinumCustomer");
		
		gc.customerType();
		pc.customerType();
	}

}
