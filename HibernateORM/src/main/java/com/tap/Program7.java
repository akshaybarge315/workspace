package com.tap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Program7 {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = null;
		Session session = null;
		
		try {
			Configuration cfg = new Configuration().configure().addAnnotatedClass(Employee.class);
			
			sessionFactory = cfg.buildSessionFactory();
			
			session = sessionFactory.openSession();
			
			Transaction transaction = session.beginTransaction();
			
//			Logic
//			Query query = session.createQuery("from Employee");
			Query query = session.createQuery("Update Employee e set e.salary = e.salary + 2000 where e.department = 'HR'", Employee.class);
			int i = query.executeUpdate();
			System.out.println(i);
			
			transaction.commit();
			
		} finally {
			session.close();
			sessionFactory.close();
		}
		
	}

}
