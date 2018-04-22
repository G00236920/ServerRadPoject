package com.ships.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ships.model.OrderInfo;
import com.ships.repositories.OrderRepository;

@Service
public class OrderService {
	@Autowired
	OrderRepository orderRepository;
	
	//Get an Iterable list from the SQL Database
	public Iterable<OrderInfo> FindAll() {

		return orderRepository.findAll();
	}
	
	//Add a new Ship to SQL
	public OrderInfo saveOrder(OrderInfo s) {
		
		return orderRepository.save(s);
	}


}
