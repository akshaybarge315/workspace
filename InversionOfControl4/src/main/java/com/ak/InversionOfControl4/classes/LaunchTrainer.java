package com.ak.InversionOfControl4.classes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ak.InversionOfControl4.interfaces.Trainer;

public class LaunchTrainer {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		Trainer jt = (Trainer) ac.getBean("jt");
		Trainer wt = (Trainer) ac.getBean("wt");
		Trainer st = (Trainer) ac.getBean("st");
		
		System.out.println(jt.giveTask());
		jt.giveTime();
		System.out.println(wt.giveTask());
		wt.giveTime();
		System.out.println(st.giveTask());
		st.giveTime();
	}

}
