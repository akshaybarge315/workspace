package com.ak.SpringORM.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.ak.SpringORM.dao.EmployeeDAO;
import com.ak.SpringORM.entity.Employee;

@Component("edao")
public class EmployeeDAOImpl implements EmployeeDAO {
	
	Session session = null;

	@Override
	public void addEmployee(Employee e, SessionFactory sf) {
		session = sf.openSession();
		Transaction t = session.beginTransaction();
		
		session.save(e);
		System.out.println("Data Inserted");
		t.commit();
	}

}
