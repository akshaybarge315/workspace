package com.shopping.dao;

import java.util.List;

import com.shopping.model.Order;

public interface OrderDAO {
	void addOrder(Order order);
    void updateOrder(Order order);
    void deleteOrder(int orderId);
    Order getOrderById(int orderId);
    List<Order> getAllOrders();
}
