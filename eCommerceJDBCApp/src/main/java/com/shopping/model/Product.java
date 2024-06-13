package com.shopping.model;

public class Product {
	
	private int productId;
    private String name;
    private String description;
    private double rating; 
    private double price;
    private String category;
    
    public Product() {	}

	public Product(int productId, String name, String description, double rating, double price, String category) {
		super();
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.rating = rating;
		this.price = price;
		this.category = category;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "[productId=" + productId + ", name=" + name + ", description=" + description + ", rating="
				+ rating + ", price=" + price + ", category=" + category + "]\n";
	}

}
