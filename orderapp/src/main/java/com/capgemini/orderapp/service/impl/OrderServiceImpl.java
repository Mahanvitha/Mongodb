package com.capgemini.orderapp.service.impl;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.orderapp.entity.Order;
import com.capgemini.orderapp.repository.OrderRepository;
import com.capgemini.orderapp.service.OrderService;
import com.capgemini.orderapp.service.exceptions.OrderAlreadyExistsException;
import com.capgemini.orderapp.service.exceptions.OrderDoesNotExists;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	OrderRepository orderRepository;

	@Override
	public Order addProduct(Order order) throws OrderAlreadyExistsException {
		Optional<Order> orderDb = orderRepository.findById(order.getOrderId());
		if(!orderDb.isPresent()) {
		return orderRepository.save(order);	
		}
		throw new OrderAlreadyExistsException("Order id " + order.getOrderId() + " is already done.");	
	}

	@Override
	public void deleteProduct(Order order) throws OrderDoesNotExists {
		Optional<Order> orderDb = orderRepository.findById(order.getOrderId());
		if(orderDb.isPresent()) {
			orderRepository.delete(order);
		}
		throw new OrderDoesNotExists("Order Id"+order.getOrderId()+"does not exists");
	}

	@Override
	public List<Order> findOrderByCustomerId(int customerId) throws OrderDoesNotExists {
		return orderRepository.findByCustomerId(customerId);
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	
		public Order findOrderById(int orderId) throws OrderDoesNotExists {
			Optional<Order> orderFromDb = orderRepository.findById(orderId);
			if (orderFromDb.isPresent()) {
				return orderFromDb.get();
			}
			throw new OrderDoesNotExists("Order id " + orderId + " does not exists to search");
		}
	}



