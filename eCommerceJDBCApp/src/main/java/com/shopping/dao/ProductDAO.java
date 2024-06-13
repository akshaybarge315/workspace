package com.shopping.dao;

import java.util.List;

import com.shopping.model.Product;

public interface ProductDAO {
	void addProduct(Product product);
	void updateProduct(Product product);
	void deleteProduct(int productId);
	Product getProductByProductId(int productId);
    Product getProductByName(String name);
    List<Product> getAllProducts();
}
