package com.tap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Program3 {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Employee.class);
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
//		Logic
		Employee e = session.get(Employee.class, 1);
		System.out.println(e);
		e.setSalary(21000);
		session.update(e);
		session.merge(e);
		
		transaction.commit();	
		
	}

}
