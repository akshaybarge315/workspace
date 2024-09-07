package com.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.Entity.Employee;
import com.dao.EmployeeDAO;

@Component("edaoi")
public class EmployeeDAOImpl implements EmployeeDAO {

	Session s;
	
	@Autowired
	public EmployeeDAOImpl(@Qualifier("sessionfactory") SessionFactory sf) {
		s = sf.openSession();
	}

	@Override
	public void insert(Employee e) {
		System.out.println("Inserting Data from Insert Method");
		
		Transaction t = s.beginTransaction();
		s.persist(e);
		t.commit();
		
	}

	@Override
	public void delete(int empid) {
		Transaction t = s.beginTransaction();
		Employee e = s.get(Employee.class, empid);
		s.remove(e);
		t.commit();
	}

	@Override
	public List<Employee> getAllEmployees() {
		return s.createQuery("from Employee", Employee.class).list();
	}

	@Override
	public void update(Employee e) {
		Transaction t = s.beginTransaction();
        s.merge(e);
        t.commit();
	}

	@Override
	public Employee getEmployee(int empid) {
		return s.get(Employee.class, empid);
	}

}
