package com.capgemini.orderapp.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.orderapp.entity.Order;
import com.capgemini.orderapp.service.OrderService;
import com.capgemini.orderapp.service.exceptions.OrderAlreadyExistsException;
import com.capgemini.orderapp.service.exceptions.OrderDoesNotExists;


@RestController
public class OrderController {
	private final static Logger LOGGER = Logger.getLogger(OrderController.class.getName());
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/order")
	public ResponseEntity<Order> addProduct(@RequestBody Order order) throws OrderAlreadyExistsException{
		ResponseEntity<Order> responseEntity = new ResponseEntity<Order>(orderService.addProduct(order),HttpStatus.OK);
		LOGGER.info("addOrder");
		return responseEntity;
	}
	@DeleteMapping("/order/{orderId}")
	public ResponseEntity<Order> deleteProduct(@PathVariable int orderId) throws OrderDoesNotExists {
		Order order = orderService.findOrderById(orderId);
		System.out.println(order);
		orderService.deleteProduct(order);
		return new ResponseEntity<Order>(HttpStatus.OK);	
		
	}
	@GetMapping("/v1/order/{orderId}")
	public ResponseEntity<Order> findOrderById(@PathVariable int orderId) throws OrderDoesNotExists {
		LOGGER.info("Get order" + orderId);
		return new ResponseEntity<Order>(orderService.findOrderById(orderId), HttpStatus.OK);
	}
	@GetMapping("/v1/order/customer/{customerId}")
	public ResponseEntity<List<Order>> findOrderByCustomerId(@PathVariable int customerId) throws OrderDoesNotExists {
		LOGGER.info("Get order of customer" + customerId);
		return new ResponseEntity<List<Order>>(orderService.findOrderByCustomerId(customerId), HttpStatus.OK);
	}

	@GetMapping("/v1/orders")
	public ResponseEntity<List<Order>> findAllOrder() {
		LOGGER.info("Get All orders");
		return new ResponseEntity<List<Order>>(orderService.getAllOrders(), HttpStatus.OK);
	}}
