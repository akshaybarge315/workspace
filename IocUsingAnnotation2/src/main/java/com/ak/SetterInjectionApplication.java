package com.ak;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ak.interfaces.Car;

public class SetterInjectionApplication {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		Car swift = (Car) ac.getBean("swift");
		Car polo = (Car) ac.getBean("polo");
		
		swift.getDetails();
		swift.getInfo();
		polo.getDetails();
		swift.getInfo();
		
	}

}
