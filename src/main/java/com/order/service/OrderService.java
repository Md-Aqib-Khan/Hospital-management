package com.order.service;

import java.util.List;

import com.order.model.Order;

public interface OrderService {

	public List<Order> getAllOrder();

	public Order getOrder(int id);
	
	public String placeOrder(Order order);

	public void deleteOrder(int id);
	
	
}
