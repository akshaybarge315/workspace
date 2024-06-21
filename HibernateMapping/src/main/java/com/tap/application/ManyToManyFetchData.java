package com.tap.application;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tap.model.Employee;
import com.tap.model.Project;

public class ManyToManyFetchData {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		
		try {
			
			Configuration cfg = new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Project.class);
			
			sessionFactory = cfg.buildSessionFactory();
			
			session = sessionFactory.openSession();
			
			Transaction transaction = session.beginTransaction();
			
//			CRUD Operation
//			Employee employee = session.get(Employee.class, 2);
//			List<Project> projects = employee.getProjects();
//			
//			System.out.println(employee);
//			
//			for (Project project : projects) {
//				System.out.println(project);
//			}
			
			Project project = session.get(Project.class, 2);
			List<Employee> empoyees = project.getEmpoyees();
			
			System.out.println(project);
			
			for (Employee employee : empoyees) {
				System.out.println(employee);
			}
			
			
			transaction.commit();
			
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
