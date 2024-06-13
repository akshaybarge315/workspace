package com.shopping.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dao.UserDAO;
import com.shopping.model.User;
import com.shopping.util.ConnectionUtil;

public class UserDAOImpl implements UserDAO{
	
	private static Connection connection = null;
    private static PreparedStatement prepareStatement = null;
    private static Statement statement = null;
    private static ResultSet res = null;

    private static final String INSERT_QUERY = "INSERT INTO User (name, username, password, email, phone) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE User SET name = ?, username = ?, password = ?, email = ?, phone = ? WHERE userId = ?";
    private static final String DELETE_QUERY = "DELETE FROM User WHERE userId = ?";
    private static final String SELECT_QUERY = "SELECT * FROM User WHERE userId = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM User";

    public UserDAOImpl() {
        connection = ConnectionUtil.getConnection();
    }

	@Override
	public void addUser(User user) {
		try {
			prepareStatement = connection.prepareStatement(INSERT_QUERY);
			prepareStatement.setString(1, user.getName());
			prepareStatement.setString(2, user.getUsername());
			prepareStatement.setString(3, user.getPassword());
			prepareStatement.setString(4, user.getEmail());
			prepareStatement.setString(5, user.getPhone());
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void updateUser(User user) {
		try {
			prepareStatement = connection.prepareStatement(UPDATE_QUERY);
			prepareStatement.setString(1, user.getName());
			prepareStatement.setString(2, user.getUsername());
			prepareStatement.setString(3, user.getPassword());
			prepareStatement.setString(4, user.getEmail());
			prepareStatement.setString(5, user.getPhone());
			prepareStatement.setInt(6, user.getUserId());
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void deleteUser(int userId) {
		try {
			prepareStatement = connection.prepareStatement(DELETE_QUERY);
	        prepareStatement.setInt(1, userId);
	        prepareStatement.executeUpdate();
		} catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public User getUser(int userId) {
		try {
			prepareStatement = connection.prepareStatement(SELECT_QUERY);
	        prepareStatement.setInt(1, userId);
	        res = prepareStatement.executeQuery();

	        if (res.next()) {
	            return new User(
	            		res.getInt("userId"),
	                    res.getString("name"),
	                    res.getString("username"),
	                    res.getString("password"),
	                    res.getString("email"),
	                    res.getString("phone"),
	                    res.getDate("createdDate")
	            );
	        }
		} catch (SQLException e) {
            e.printStackTrace();
        }
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		
		try {
			statement = connection.createStatement();
			res = statement.executeQuery(SELECT_ALL_QUERY);
	        while (res.next()) {
	            users.add(new User(
	            		res.getInt("userId"),
	                    res.getString("name"),
	                    res.getString("username"),
	                    res.getString("password"),
	                    res.getString("email"),
	                    res.getString("phone"),
	                    res.getDate("createdDate")
	            ));
	        }
		} catch (SQLException e) {
            e.printStackTrace();
        }
		return users;
	}
	
	@Override
    public void finalize() throws Throwable {
        if (res != null) {
            res.close();
        }
        if (prepareStatement != null) {
            prepareStatement.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

}
