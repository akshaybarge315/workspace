package com.shopping.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dao.ProductDAO;
import com.shopping.model.Product;
import com.shopping.util.ConnectionUtil;

public class ProductDAOImpl implements ProductDAO{
	
	private static Connection connection = null;
    private static PreparedStatement prepareStatement = null;
    private static Statement statement = null;
    private static ResultSet res = null;

    private static final String INSERT_QUERY = "INSERT INTO Products (name, description, rating, price, category) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE Products SET name = ?, description = ?, rating = ?, price = ?, category = ? WHERE productId = ?";
    private static final String DELETE_QUERY = "DELETE FROM Products WHERE productId = ?";
    private static final String SELECT_QUERY = "SELECT * FROM Products WHERE id = ?";
    private static final String SELECT_QUERY_NAME = "SELECT * FROM Products WHERE name = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM Products";

    public ProductDAOImpl() {
        connection = ConnectionUtil.getConnection();
    }	

	@Override
	public void addProduct(Product product) {
		try {
			prepareStatement = connection.prepareStatement(INSERT_QUERY);
	        prepareStatement.setString(1, product.getName());
	        prepareStatement.setString(2, product.getDescription());
	        prepareStatement.setDouble(3, product.getRating());
	        prepareStatement.setDouble(4, product.getPrice());
	        prepareStatement.setString(5, product.getCategory());
	        prepareStatement.executeUpdate();
		}catch (SQLException e) {
        	e.printStackTrace();
        }
	}

	@Override
	public void updateProduct(Product product) {
		try {
			prepareStatement = connection.prepareStatement(UPDATE_QUERY);
	        prepareStatement.setString(1, product.getName());
	        prepareStatement.setString(2, product.getDescription());
	        prepareStatement.setDouble(3, product.getRating());
	        prepareStatement.setDouble(4, product.getPrice());
	        prepareStatement.setString(5, product.getCategory());
	        prepareStatement.setInt(6, product.getProductId());
	        prepareStatement.executeUpdate();
		}catch (SQLException e) {
        	e.printStackTrace();
        }
	}

	@Override
	public void deleteProduct(int productId) {
		try {
			prepareStatement = connection.prepareStatement(DELETE_QUERY);
	        prepareStatement.setInt(1, productId);
	        prepareStatement.executeUpdate();
		}catch (SQLException e) {
        	e.printStackTrace();
        }
	}
	
	@Override
	public Product getProductByProductId(int id) {
		try {
			prepareStatement = connection.prepareStatement(SELECT_QUERY);
	        prepareStatement.setInt(1, id);
	        res = prepareStatement.executeQuery();

	        if (res.next()) {
	            return new Product(
	            		res.getInt("productId"),
	                    res.getString("name"),
	                    res.getString("description"),
	                    res.getDouble("rating"),
	                    res.getDouble("price"),
	                    res.getString("category")
	            );
	        }
		}catch (SQLException e) {
        	e.printStackTrace();
        }
		return null;
	}

	@Override
	public Product getProductByName(String name) {
		try {
			prepareStatement = connection.prepareStatement(SELECT_QUERY_NAME);
	        prepareStatement.setString(1, name);
	        res = prepareStatement.executeQuery();

	        if (res.next()) {
	            return new Product(
	            		res.getInt("productId"),
	                    res.getString("name"),
	                    res.getString("description"),
	                    res.getDouble("rating"),
	                    res.getDouble("price"),
	                    res.getString("category")
	            );
	        }
		}catch (SQLException e) {
        	e.printStackTrace();
        }
		return null;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<>();

		try {
	        statement = connection.createStatement();
	        res = statement.executeQuery(SELECT_ALL_QUERY);

	        while (res.next()) {
	            products.add(new Product(
	            		res.getInt("productId"),
	                    res.getString("name"),
	                    res.getString("description"),
	                    res.getDouble("rating"),
	                    res.getDouble("price"),
	                    res.getString("category")
	            ));
	        }
		}catch (SQLException e) {
        	e.printStackTrace();
        }
		return products;
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
