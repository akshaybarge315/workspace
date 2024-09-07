package com.ak.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="emp1")
public class StudentEntity {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int empid;
	@Column(name="name")
	private String name;
	@Column(name="designation")
	private String designation;
	@Column(name="salary")
	private int salary;
	
	public StudentEntity() {	}

	public StudentEntity(String name, String designation, int salary) {
		super();
		this.name = name;
		this.designation = designation;
		this.salary = salary;
	}

	public int getEmpid() {
		return empid;
	}

	public String getName() {
		return name;
	}

	public String getDesignation() {
		return designation;
	}

	public int getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "StudentEntity [empid=" + empid + ", name=" + name + ", designation=" + designation + ", salary="
				+ salary + "]";
	}
	
}
