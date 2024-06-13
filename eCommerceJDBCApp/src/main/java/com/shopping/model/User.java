package com.shopping.model;

import java.util.Date;

public class User {
	
	private int userId;
    private String name;
    private String username;
    private String password;
    private String email;
    private String phone;
    private Date createdDate;
    
    public User() { }
    
	public User(int userId, String name, String username, String password, String email, String phone, Date createdDate) {
		super();
		this.userId = userId;
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.createdDate = createdDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreatedDate() {
		return createdDate;
	}
	
	public static String getTableHeader() {
	    return String.format("%-10s %-20s %-15s %-15s %-25s %-15s %-20s\n", 
	                          "userId", "name", "username", "password", "email", "phone", "createdDate");
	}

	@Override
	public String toString() {
	    return String.format("%-10s %-20s %-15s %-15s %-25s %-15s %-20s\n", 
	                          userId, name, username, password, email, phone, createdDate);
	}

}
