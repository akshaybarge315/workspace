package com.tap.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tap.model.Customer;
import com.tap.model.CustomerDetails;
import com.tap.model.Orders;

public class OneToMany1 {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		
		try {
			Configuration cfg = new Configuration().configure().addAnnotatedClass(Customer.class).addAnnotatedClass(CustomerDetails.class).addAnnotatedClass(Orders.class);
			
			sessionFactory = cfg.buildSessionFactory();
			
			session = sessionFactory.openSession();
			
			Transaction transaction = session.beginTransaction();
			
//			Set the Data for Existing customer
//			Create Orders
//			Orders o1 = new Orders(704, "Chapati", 300);
//			Orders o2 = new Orders(705, "Rice", 350);
//			Orders o3 = new Orders(706, "Chapati", 300);
//			
////			Fetch the Customer
//			Customer cust = session.get(Customer.class, 2);
//			
////			set customer to orders
//			o1.setCustomer(cust);
//			o2.setCustomer(cust);
//			o3.setCustomer(cust);
//			
////			Save to database
//			session.persist(o1);
//			session.persist(o2);
//			session.persist(o3);
			
			
			
//			Set the data for new employee
//			Add new Customer CRUD operation
			Customer customer = new Customer(3, "Sita");
			CustomerDetails customerDetails = new CustomerDetails(503, "sita@gmail.com", "9920459894", "Satara");
			customer.setCustomerDetails(customerDetails);
			
//			Create Orders
			Orders o1 = new Orders(707, "Daal", 330);
			Orders o2 = new Orders(708, "Roti", 350);
			Orders o3 = new Orders(709, "Chapati", 30);
			
//			set customer to orders
			o1.setCustomer(customer);
			o2.setCustomer(customer);
			o3.setCustomer(customer);
			
//			Save to database
			session.persist(o1);
			session.persist(o2);
			session.persist(o3);
			
			transaction.commit();
			
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
