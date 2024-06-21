package com.tap.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reviews")
public class Reviews {
	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "comments")
	private String comments;
	
	@JoinColumn(name = "order_id")
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private Orders orders;
	
	public Reviews() {	}

	public Reviews(int id, String comments) {
		super();
		this.id = id;
		this.comments = comments;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Reviews [id=" + id + ", comments=" + comments + ", orders=" + orders + "]";
	}
	
}
