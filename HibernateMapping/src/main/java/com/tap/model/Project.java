package com.tap.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="projects")
public class Project {
	
	@Id
	@Column(name="id")
	private int id;

	@Column(name="name")
	private String name;
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinTable(name = "employee_project", 
				joinColumns = @JoinColumn( name = "proj_id"),
				inverseJoinColumns = @JoinColumn(name = "emp_id"))
	private List<Employee> empoyees;
	
	public Project() {	}

	public Project(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Employee> getEmpoyees() {
		return empoyees;
	}

	public void setEmpoyees(List<Employee> empoyees) {
		this.empoyees = empoyees;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + "]";
	}
	
}
