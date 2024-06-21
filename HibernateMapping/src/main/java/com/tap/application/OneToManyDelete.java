package com.tap.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tap.model.Customer;
import com.tap.model.CustomerDetails;
import com.tap.model.Orders;

public class OneToManyDelete {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		
		try {
			Configuration cfg = new Configuration().configure().addAnnotatedClass(Customer.class).addAnnotatedClass(CustomerDetails.class).addAnnotatedClass(Orders.class);
			
			sessionFactory = cfg.buildSessionFactory();
			
			session = sessionFactory.openSession();
			
			Transaction transaction = session.beginTransaction();
			
//			CRUD
			
//			Deleting Customer
//			Customer customer = session.get(Customer.class, 1);
//			session.remove(customer);
			
//			Deleting Order data
			Orders order = session.get(Orders.class, 706);
			session.remove(order);
			
			transaction.commit();
			
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
