package com.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@Column(name="empid")
	int empid;
	@Column(name="ename")
	String ename;
	@Column(name="jobrole")
	String jobrole;
	@Column(name="dept")
	String dept;
	@Column(name="deptid")
	int deptid;
	
	public Employee() {
		super();
	}
	
	public Employee(int empid, String ename, String jobrole, String dept, int deptid) {
		super();
		this.empid = empid;
		this.ename = ename;
		this.jobrole = jobrole;
		this.dept = dept;
		this.deptid = deptid;
	}
	
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJobrole() {
		return jobrole;
	}
	public void setJobrole(String jobrole) {
		this.jobrole = jobrole;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", ename=" + ename + ", jobrole=" + jobrole + ", dept=" + dept + ", deptid="
				+ deptid + "]";
	}
	
}
