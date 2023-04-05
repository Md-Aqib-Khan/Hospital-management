package com.product.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.dao.OrderItemRepo;
import com.product.model.OrderItem;
import com.product.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderItemRepo orderItemRepo;

	@Override
	public OrderItem addOrder(OrderItem order) {
		
		return orderItemRepo.save(order);
	}

	@Override
	public List<OrderItem> getall() {
		return orderItemRepo.findAll();
	}

}
