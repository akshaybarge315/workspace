package com.shopping.model;

import java.util.Date;

public class Order {
	
	 private int orderId;
	 private int userId;
	 private int productId;
	 private Date  orderDate; 
	 private String status;
	 private double price;
	 private String paymentMode;
	 
	 public Order() {	}

	

	public Order(int orderId, int userId, int productId, Date  orderDate, String status, double price,
			String paymentMode) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.productId = productId;
		this.orderDate = orderDate;
		this.status = status;
		this.price = price;
		this.paymentMode = paymentMode;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	
	public static String getHeader() {
        return String.format("%-10s %-10s %-10s %-20s %-10s %-10s %-15s", "OrderID", "UserID", "ProductID", "OrderDate", "Status", "Price", "PaymentMode");
    }

	@Override
	public String toString() {
        return String.format("%-10d %-10d %-10d %-20s %-10s %-10.2f %-15s", orderId, userId, productId, orderDate, status, price, paymentMode);
    }

}
