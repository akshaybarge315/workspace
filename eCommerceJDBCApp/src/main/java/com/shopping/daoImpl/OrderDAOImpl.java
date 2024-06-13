package com.shopping.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.shopping.dao.OrderDAO;
import com.shopping.model.Order;
import com.shopping.util.ConnectionUtil;

public class OrderDAOImpl implements OrderDAO {

	private static Connection connection = null;
    private static PreparedStatement prepareStatement = null;
    private static Statement statement = null;
    private static ResultSet res = null;

    private static final String INSERT_QUERY = "INSERT INTO OrderTable (userId, productId, status, price, paymentMode) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE orderTable SET userId = ?, productId = ?, status = ?, price = ?,  paymentMode = ? WHERE orderId = ?";
    private static final String DELETE_QUERY = "DELETE FROM orderTable WHERE orderId = ?";
    private static final String SELECT_QUERY = "SELECT * FROM orderTable WHERE orderId = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM orderTable";
    private static final String SELECT_PRODUCT_PRICE_QUERY = "SELECT price FROM Products WHERE productId = ?";

    public OrderDAOImpl() {
    	connection = ConnectionUtil.getConnection();
    }
    
	@Override
	public void addOrder(Order order) {
		try {
			double productPrice = getProductPrice(order.getProductId());
			
			prepareStatement = connection.prepareStatement(INSERT_QUERY);
	        prepareStatement.setInt(1, order.getUserId());
	        prepareStatement.setInt(2, order.getProductId());
	        prepareStatement.setString(3, order.getStatus());
	        prepareStatement.setDouble(4, productPrice);
	        prepareStatement.setString(5, order.getPaymentMode());
	        prepareStatement.executeUpdate();
		} catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void updateOrder(Order order) {
		try {
			double productPrice = getProductPrice(order.getProductId());
			
            prepareStatement = connection.prepareStatement(UPDATE_QUERY);
            prepareStatement.setInt(1, order.getUserId());
            prepareStatement.setInt(2, order.getProductId());
            prepareStatement.setString(3, order.getStatus());
            prepareStatement.setDouble(4, productPrice);
            prepareStatement.setString(5, order.getPaymentMode());
            prepareStatement.setInt(6, order.getOrderId());
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	private double getProductPrice(int productId) throws SQLException {
        prepareStatement = connection.prepareStatement(SELECT_PRODUCT_PRICE_QUERY);
        prepareStatement.setInt(1, productId);
        res = prepareStatement.executeQuery();

        if (res.next()) {
            return res.getDouble("price");
        } else {
            throw new SQLException("Product not found");
        }
    }
	
	@Override
	public void deleteOrder(int orderId) {
		try {
            prepareStatement = connection.prepareStatement(DELETE_QUERY);
            prepareStatement.setInt(1, orderId);
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public Order getOrderById(int orderId) {
        try {
            prepareStatement = connection.prepareStatement(SELECT_QUERY);
            prepareStatement.setInt(1, orderId);
            res = prepareStatement.executeQuery();
            if (res.next()) {
            	Order order = new Order();
                order.setOrderId(res.getInt("orderId"));
                order.setUserId(res.getInt("userId"));
                order.setProductId(res.getInt("productId"));
                order.setOrderDate(res.getDate("orderDate"));
                order.setStatus(res.getString("status"));
                order.setPrice(res.getDouble("price"));
                order.setPaymentMode(res.getString("paymentMode"));
                return order;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
	}

	@Override
	public List<Order> getAllOrders() {
		List<Order> orders = new ArrayList<>();
        try {
        	statement = connection.createStatement();
            res = statement.executeQuery(SELECT_ALL_QUERY);
            while(res.next()) {
            	int orderId = res.getInt("orderId");
            	int userId = res.getInt("userId");
            	int productId = res.getInt("productId");
            	Date orderDate = res.getDate("orderDate");
            	String status = res.getString("status");
            	double price = res.getDouble("price");
            	String paymentMode = res.getString("paymentMode");
            	
            	orders.add( new Order(orderId, userId, productId, orderDate, status, price, paymentMode));
            } 
        }catch (SQLException e) {
        	e.printStackTrace();
        }
        return orders;
	}


}
