package com.springmvc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class StudentEntity {
	@Id
	@Column(name = "id")
	int id;
	
	@Column(name = "name")
	String name;
	
	@Column(name = "email")
	String email;
	
	@Column(name = "sem")
	String sem;
	
	@Column(name = "marks")
	String marks;
	
	public StudentEntity() {
		super();
	}

	public StudentEntity(int id, String name, String email, String sem, String marks) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.sem = sem;
		this.marks = marks;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSem() {
		return sem;
	}

	public void setSem(String sem) {
		this.sem = sem;
	}

	public String getMarks() {
		return marks;
	}

	public void setMarks(String marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", name=" + name + ", email=" + email + ", sem=" + sem + ", marks=" + marks
				+ "]";
	}
	
}
