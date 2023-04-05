package com.order.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.order.model.Order;
import com.order.service.OrderService;



@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	
	
	//create order
	@PostMapping("/placeOrder")
	@ResponseStatus(HttpStatus.CREATED)
	public String placeOrder(@RequestBody Order order) {
		String ord = orderService.placeOrder(order);
		return ord;
	}
	
	//get all orders
	@GetMapping("/orders")
	@ResponseStatus(HttpStatus.OK)
	public List<Order> getAllOrder(){
		List<Order> list = orderService.getAllOrder();
		return list;
	}
	
	//get single order
//	@GetMapping("/orders/{id}")
//	public Order getOrder(@PathVariable("id") int id) {
//		Order order = orderService.getOrder(id);
//		
//		return order;
//	}
	
//	 delete order
	@DeleteMapping("/orders/{id}")
	public void deleteOrder(@PathVariable("id") int id){
		
		orderService.deleteOrder(id);
	}
	

}
