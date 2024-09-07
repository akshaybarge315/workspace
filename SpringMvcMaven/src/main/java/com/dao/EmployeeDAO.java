package com.dao;

import java.util.List;

import com.Entity.Employee;

public interface EmployeeDAO {
	void insert(Employee e);
	void update(Employee e);
	void delete(int empid);
	Employee getEmployee(int empid);
	List<Employee> getAllEmployees();
}
