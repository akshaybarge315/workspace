package com.employee.DAO;

import java.util.List;

import com.employee.model.Employee;

public interface EmployeeDAO {
	List<Employee> getEmployees();
	Employee getEmployee(int id);
	boolean insertEmployee(int id, String name, String designation, int
	salary);
	boolean updateEmployee(Employee e);
	boolean deleteEmployee(int id);

}
