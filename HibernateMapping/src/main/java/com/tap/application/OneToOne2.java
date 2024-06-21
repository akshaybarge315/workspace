package com.tap.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tap.model.Customer;
import com.tap.model.CustomerDetails;

public class OneToOne2 {

	public static void main(String[] args) {
		
				SessionFactory sessionFactory = null;
				Session session = null;
				
				try {
					Configuration cfg = new Configuration().configure().addAnnotatedClass(Customer.class).addAnnotatedClass(CustomerDetails.class);
					
					sessionFactory = cfg.buildSessionFactory();
					
					session = sessionFactory.openSession();
					
					Transaction transaction = session.beginTransaction();
					
//					CRUD
//					Customer customer = session.get(Customer.class, 1);
//					CustomerDetails customerDetails = customer.getCustomerDetails();
//					System.out.println(customer);
//					System.out.println(customerDetails);
					
					CustomerDetails customerDetails = session.get(CustomerDetails.class, 501);
					Customer customer = customerDetails.getCustomer();
					System.out.println(customerDetails);
					System.out.println(customer);
					
					
					transaction.commit();
					
				} finally {
					session.close();
					sessionFactory.close();
				}
	}

}
