package com.tap;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Program5 {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Employee.class);
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
//		Logic
//		Query query = session.createQuery("from Employee");
		Query query = session.createQuery("from Employee e where e.salary > 18000", Employee.class);
		
		List list = query.getResultList();
		
		for (Object e : list) {
			System.out.println(e);
		}
		
		transaction.commit();	
		
	}

}
