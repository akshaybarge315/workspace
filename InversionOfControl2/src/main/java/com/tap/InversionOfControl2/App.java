package com.tap.InversionOfControl2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tap.InversionOfControl2.classes.JavaTrainer;
import com.tap.InversionOfControl2.interfaces.Trainer;

public class App
{
    public static void main( String[] args )
    {
    	ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
    	
    	ApplicationContext ac1 = new ClassPathXmlApplicationContext("beans.xml");
    	
    	Trainer jt = (JavaTrainer) ac.getBean("jt");
    	Trainer jt1 = (JavaTrainer) ac1.getBean("jt");
    	Trainer jt2 = (JavaTrainer) ac1.getBean("jt");
    	
    	System.out.println(jt);
    	System.out.println(jt1);
    	System.out.println(jt2);
    	
//    	Trainer wt = (WebTrainer) ac.getBean("wt");
//    	Trainer st = (SQLTrainer) ac.getBean("st");
//    	
//    	jt.giveTask();
//    	wt.giveTask();
//    	st.giveTask();
    }
}
