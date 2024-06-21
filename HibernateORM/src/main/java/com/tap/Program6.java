package com.tap;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Program6 {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Employee.class);
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
//		Logic
//		Query query = session.createQuery("from Employee");
		Query query = session.createQuery("Delete Employee e where e.salary < 14000", Employee.class);
		int i = query.executeUpdate();
		System.out.println(i);
		
		
		transaction.commit();	
		
	}

}
