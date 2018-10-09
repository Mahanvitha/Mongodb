package com.capgemini.orderapp.service;

import java.util.List;

import com.capgemini.orderapp.entity.Order;
import com.capgemini.orderapp.service.exceptions.OrderAlreadyExistsException;
import com.capgemini.orderapp.service.exceptions.OrderDoesNotExists;

public interface OrderService {
	public Order addProduct(Order order) throws OrderAlreadyExistsException;
	public void deleteProduct(Order order) throws OrderDoesNotExists;
	public List<Order> findOrderByCustomerId(int order) throws OrderDoesNotExists;
	public List<Order> getAllOrders();
	public Order findOrderById(int orderId) throws OrderDoesNotExists;
}
