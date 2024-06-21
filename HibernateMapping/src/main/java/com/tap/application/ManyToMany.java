package com.tap.application;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tap.model.Employee;
import com.tap.model.Project;

public class ManyToMany {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		
		try {
			Configuration cfg = new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Project.class);
			
			sessionFactory = cfg.buildSessionFactory();
			
			session = sessionFactory.openSession();
			
			Transaction transaction = session.beginTransaction();
			
//			CRUD Operation
			
//			Adding Employees
			Employee alex = new Employee(1, "ALex", "alex@gmail.com");
			Employee bob = new Employee(2, "Bob", "bob@gmail.com");
			Employee charli = new Employee(3, "Charli", "charli@gmail.com");
			
//			Creating projects
			Project pr = new Project(1, "PremierPro");
			Project af = new Project(2, "AfterEffects");
			
//			Creating List to add Employees in project
			ArrayList<Employee> preEmployees = new ArrayList<Employee>();
			ArrayList<Employee> afEmployees = new ArrayList<Employee>();
			
//			Assigning employees to premier pro project
			preEmployees.add(alex);
			preEmployees.add(bob);
			preEmployees.add(charli);
			pr.setEmpoyees(preEmployees);
			
//			Assigning employees to After Effects project
			afEmployees.add(alex);
			afEmployees.add(charli);
			af.setEmpoyees(afEmployees);
			
//			Adding the data in database
			session.persist(alex);
			session.persist(bob);
			session.persist(charli);

			session.persist(pr);
			session.persist(af);
			
			
			transaction.commit();
			
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
