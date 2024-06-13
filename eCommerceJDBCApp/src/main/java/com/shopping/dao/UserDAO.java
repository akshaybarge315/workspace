package com.shopping.dao;

import java.util.List;

import com.shopping.model.User;

public interface UserDAO {
	void addUser(User user);
	void updateUser(User user);
	void deleteUser(int userId);
	User getUser(int userId);
	List<User> getAllUsers();
}
