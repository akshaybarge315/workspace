package com.shopping.model;

public class OrderItem {
	
	private int orderItemId;
    private int orderId;
    private int productId;
    private int quantity;
    private double price;
    
    public OrderItem() {	}

	public OrderItem(int orderItemId, int orderId, int productId, int quantity, double price) {
		super();
		this.orderItemId = orderItemId;
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
	}

	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public static String getTableHeader() {
        return String.format("%-15s %-10s %-10s %-10s %-10s",
            "OrderItemId", "OrderId", "ProductId", "Quantity", "Price");
    }
	
	@Override
	public String toString() {
        return String.format("%-15s %-10s %-10s %-10s %-10s",
            orderItemId, orderId, productId, quantity, price);
    }
}
