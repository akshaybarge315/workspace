package com.tap.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tap.model.Customer;
import com.tap.model.CustomerDetails;
import com.tap.model.Orders;
import com.tap.model.Reviews;

public class OneToMany2 {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		
		try {
			Configuration cfg = new Configuration().configure().addAnnotatedClass(Customer.class).addAnnotatedClass(CustomerDetails.class).addAnnotatedClass(Orders.class).addAnnotatedClass(Reviews.class);
			
			sessionFactory = cfg.buildSessionFactory();
			
			session = sessionFactory.openSession();
			
			Transaction transaction = session.beginTransaction();
			
			
			Orders o1 = session.get(Orders.class, 704);
			
			Reviews r1 = new Reviews(1001, "Good Food");
			Reviews r2 = new Reviews(1002, "Good Quality");
			Reviews r3 = new Reviews(1003, "Very testy food");
			
			r1.setOrders(o1);
			r2.setOrders(o1);
			r3.setOrders(o1);
			
			session.persist(r1);
			session.persist(r2);
			session.persist(r3);
			
			
			transaction.commit();
			
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
