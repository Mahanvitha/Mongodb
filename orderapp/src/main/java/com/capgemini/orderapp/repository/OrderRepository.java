package com.capgemini.orderapp.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.orderapp.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	List<Order> findByCustomerId(int customerId);

}
