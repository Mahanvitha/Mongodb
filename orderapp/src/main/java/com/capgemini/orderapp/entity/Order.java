package com.capgemini.orderapp.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name = "Order")
public class Order {
	
	@Id
	private int orderId;
	private int customerId;
	private int products;
	LocalDate orderDate;
	
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Order(int orderId, int customerId, int products, LocalDate orderDate) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.products = products;
		this.orderDate = orderDate;
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public int getProducts() {
		return products;
	}


	public void setProducts(int products) {
		this.products = products;
	}


	public LocalDate getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
}
	
	