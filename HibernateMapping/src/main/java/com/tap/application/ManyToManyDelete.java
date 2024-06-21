package com.tap.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tap.model.Employee;
import com.tap.model.Project;

public class ManyToManyDelete {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		
		try {
			Configuration cfg = new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Project.class);
			
			sessionFactory = cfg.buildSessionFactory();
			
			session = sessionFactory.openSession();
			
			Transaction transaction = session.beginTransaction();
			
//			CRUD Opertion
			
//			Project project = session.get(Project.class, 1);
//			session.remove(project);
			
			Employee employee = session.get(Employee.class, 3);
			session.remove(employee);
			
			
			transaction.commit();
			
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
