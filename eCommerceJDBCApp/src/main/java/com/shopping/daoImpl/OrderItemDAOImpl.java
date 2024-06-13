package com.shopping.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dao.OrderItemDAO;
import com.shopping.model.OrderItem;
import com.shopping.util.ConnectionUtil;

public class OrderItemDAOImpl implements OrderItemDAO{
	
	private static Connection connection = null;
    private static PreparedStatement prepareStatement = null;
    private static Statement statement = null;
    private static ResultSet res = null;

    private static final String INSERT_QUERY = "INSERT INTO OrderItem (orderId, productId, quantity, totalPrice) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE OrderItem SET orderId = ?, productId = ?, quantity = ?, totalPrice = ? WHERE orderItemId = ?";
    private static final String DELETE_QUERY = "DELETE FROM OrderItem WHERE orderItemId = ?";
    private static final String SELECT_QUERY = "SELECT * FROM OrderItem WHERE orderItemId = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM OrderItem WHERE orderId = ?";
    private static final String SELECT_ORDER_PRODUCT_QUERY = "SELECT productId FROM OrderTable WHERE orderId = ?";
    private static final String SELECT_PRODUCT_PRICE_QUERY = "SELECT price FROM Products WHERE productId = ?";

    public OrderItemDAOImpl() {
        connection = ConnectionUtil.getConnection();
    }

	@Override
	public void addOrderItem(OrderItem orderItem) {
		try {
			int productId = getProductIdByOrderId(orderItem.getOrderId());
			double productPrice = getProductPrice(productId);
            double totalPrice = orderItem.getQuantity() * productPrice;
            
			prepareStatement = connection.prepareStatement(INSERT_QUERY);
	        prepareStatement.setInt(1, orderItem.getOrderId());
	        prepareStatement.setInt(2, productId);
	        prepareStatement.setInt(3, orderItem.getQuantity());
	        prepareStatement.setDouble(4, totalPrice);
	        prepareStatement.executeUpdate();
		} catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void updateOrderItem(OrderItem orderItem) {
		try {
			int productId = getProductIdByOrderId(orderItem.getOrderId());
			double productPrice = getProductPrice(productId);
            double totalPrice = orderItem.getQuantity() * productPrice;
            
			prepareStatement = connection.prepareStatement(UPDATE_QUERY);
	        prepareStatement.setInt(1, orderItem.getOrderId());
	        prepareStatement.setInt(2, productId);
	        prepareStatement.setInt(3, orderItem.getQuantity());
	        prepareStatement.setDouble(4, totalPrice);
	        prepareStatement.setInt(5, orderItem.getOrderItemId());
	        prepareStatement.executeUpdate();
		} catch (SQLException e) {
            e.printStackTrace();
        }	
	}

	private int getProductIdByOrderId(int orderId) throws SQLException {
	    prepareStatement = connection.prepareStatement(SELECT_ORDER_PRODUCT_QUERY);
	    prepareStatement.setInt(1, orderId);
	    res = prepareStatement.executeQuery();

	    if (res.next()) {
	        return res.getInt("productId");
	    } else {
	        throw new SQLException("Order not found");
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
	public void deleteOrderItem(int orderItemId) {
		try {
			prepareStatement = connection.prepareStatement(DELETE_QUERY);
	        prepareStatement.setInt(1, orderItemId);
	        prepareStatement.executeUpdate();
		} catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public OrderItem getOrderItemById(int orderItemId) {
		try {
			prepareStatement = connection.prepareStatement(SELECT_QUERY);
	        prepareStatement.setInt(1, orderItemId);
	        res = prepareStatement.executeQuery();

	        if (res.next()) {
	            return new OrderItem(
	            		res.getInt("orderItemId"),
	                    res.getInt("orderId"),
	                    res.getInt("productId"),
	                    res.getInt("quantity"),
	                    res.getDouble("totalPrice")
	            );
	        }
		} catch (SQLException e) {
            e.printStackTrace();
        }
		return null;
	}

	@Override
	public List<OrderItem> getOrderItemsByOrderId(int orderId) {
		List<OrderItem> orderItems = new ArrayList<>();

		try {
	        prepareStatement = connection.prepareStatement(SELECT_ALL_QUERY);
	        prepareStatement.setInt(1, orderId);
	        res = prepareStatement.executeQuery();

	        while (res.next()) {
	            orderItems.add(new OrderItem(
	            		res.getInt("orderItemId"),
	                    res.getInt("orderId"),
	                    res.getInt("productId"),
	                    res.getInt("quantity"),
	                    res.getDouble("totalPrice")
	            ));
	        }
		} catch (SQLException e) {
            e.printStackTrace();
        }
		return orderItems;
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
