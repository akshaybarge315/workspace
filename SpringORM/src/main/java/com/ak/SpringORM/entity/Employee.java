package com.ak.SpringORM.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name="employee")
public class Employee {
	@Id
	@Column(name="empid")
	private int empId;
	
	@Column(name="fname")
	private String fName;
	
	@Column(name="lname")
	private String lName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="role")
	private String role;
	
	@Column(name="department")
	private String department;
	
//	public Employee() {	}
	
	@Autowired
	public Employee(@Value("5") int empId, 
			@Value("Ram") String fName, 
			@Value("Sita") String lName, 
			@Value("ram@god.com") String email, 
			@Value("Head") String role, 
			@Value("CEO") String department) {
		super();
		this.empId = empId;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.role = role;
		this.department = department;
	}

	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
