package com.ak.SpringORM.dao;

import org.hibernate.SessionFactory;

import com.ak.SpringORM.entity.Employee;

public interface EmployeeDAO {
	void addEmployee(Employee e, SessionFactory sf);
}
