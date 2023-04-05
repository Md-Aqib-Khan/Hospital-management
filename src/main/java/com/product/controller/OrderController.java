package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.OrderItem;
import com.product.service.OrderService;
import com.product.service.serviceImpl.OrderServiceImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/product2")	
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	//create Order
			@PostMapping("/addOrder")
			public OrderItem addOrder(@RequestBody OrderItem order) {
				OrderItem result = orderService.addOrder(order);
			return result;	
			}
			
	//get order
			@GetMapping("/getAll")
			public List<OrderItem> getAll() {
				return orderService.getall();
			}
}
