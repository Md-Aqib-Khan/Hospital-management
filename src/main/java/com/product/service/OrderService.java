package com.product.service;

import java.util.List;

import com.product.model.OrderItem;

public interface OrderService {

	public OrderItem addOrder(OrderItem order);

	public List<OrderItem> getall();

}
