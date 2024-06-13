package com.employee.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.employee.DAO.EmployeeDAO;
import com.employee.model.Employee;
import com.employee.util.ConnectorFactory;

public class EmployeeDAOImpl implements EmployeeDAO{

	public List getEmployees() {
		ArrayList<Employee> emplist = null;
		try {
			Connection con = ConnectorFactory.requestConnection();
			
			String query = "select * from emp";
			
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);
			
			emplist = new ArrayList<Employee>();
			
			while(res.next()==true)
			{
				int id = res.getInt(1);
				String name = res.getString(2);
				String designation = res.getString(3);
				int salary= res.getInt(4);
				
				Employee e = new Employee(id,name,designation,salary);
				emplist.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emplist;
	}
	
	public Employee getEmployee(int id) {
		Employee e = null;
		try {
		Connection con = ConnectorFactory.requestConnection();
		String query = "select * from emp where id = ?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, id);
		ResultSet res = pstmt.executeQuery();
		res.next();
		e = new
		Employee(res.getInt(1),res.getString(2),res.getString(3),res.getInt(4));
		} catch (Exception e2) {
		e2.printStackTrace();
		}
		return e;
	}
	
	public boolean insertEmployee(int id, String name, String designation, int salary) {
		return false;
	}

	public boolean updateEmployee(Employee e) {
		int i = 0;
		try {
			Connection con = ConnectorFactory.requestConnection();
			String query = "update emp set salary = ? where id = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, e.getSalary());
			pstmt.setInt(2, e.getId());
			
			i = pstmt.executeUpdate();
		}
		catch (Exception e2) {
			e2.printStackTrace();
		}
		
		if(i==1) {
			return true;
		}
		else {
			return false;
		}
	}
		
	public boolean deleteEmployee(int id) {
		return false;
	}

}
