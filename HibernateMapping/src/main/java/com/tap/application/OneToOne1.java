package com.tap.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tap.model.Customer;
import com.tap.model.CustomerDetails;

public class OneToOne1 {

	public static void main(String[] args) {
		
				SessionFactory sessionFactory = null;
				Session session = null;
				
				try {
					Configuration cfg = new Configuration().configure().addAnnotatedClass(Customer.class).addAnnotatedClass(CustomerDetails.class);
					
					sessionFactory = cfg.buildSessionFactory();
					
					session = sessionFactory.openSession();
					
					Transaction transaction = session.beginTransaction();
					
//			Logic
					Customer c1 = new Customer(1, "Akki");
					CustomerDetails cd1 = new CustomerDetails(501, "ak@gmail.com", "9867919042", "Mumbai");
					
					c1.setCustomerDetails(cd1);
					
					session.persist(c1);
					
					
					transaction.commit();
					
				} finally {
					session.close();
					sessionFactory.close();
				}
	}

}
