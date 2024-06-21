package com.tap.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {
	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "item")
	private String item;

	@Column(name = "price")
	private int price;
	
	@JoinColumn(name = "cust_id")
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})  // If One order want to delete the customer data and customer details data not get deleted
	private Customer customer;
	
	@OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
	private List<Reviews> reviews;
	
	public Orders() {	}

	public Orders(int id, String item, int price) {
		super();
		this.id = id;
		this.item = item;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", item=" + item + ", price=" + price + ", customer=" + customer + "]";
	}
	
}
