package com.order.service.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;

import com.google.common.base.Function;
import com.order.dao.OrderRepo;
import com.order.model.Order;
import com.order.model.OrderLineItems;
import com.order.model.Product;
import com.order.service.OrderService;
import com.order.utilMapper.OrderMapper;


@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepo orderRepo;
	
//	@Autowired
//	private RestTemplate restTemplate;
	
	@Autowired
	private OrderMapper orderMapper;
	
//	Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	
	//get all order
	@Override
	public List<Order> getAllOrder() {
		
		List<Order> list = orderRepo.findAll();
		return list;
	}

	
	
//	get single order by id
	@Override
	public Order getOrder(int id) {
		Order order = orderRepo.findById(id);
		// fetching product of above Order from PRODUCT SERVICE
		
//		forobject.add(restTemplate.getForObject("http://localhost:8010/product/products/1", Product.class));
//		order.setProducts(forobject);
//		ArrayList<Product> forObject = restTemplate.getForObject("http://localhost:8010/product/products", ArrayList.class);
//		logger.info("{}",forObject);
		return order;
	}
	
	
	
	
//	delete single order
	@Override
	public void deleteOrder(int id){
		orderRepo.deleteAll();
		orderRepo.deleteById(id);
	}
	

//	create new order
	public String placeOrder(Order order) {
//		List<String> productNames = order.getOrderLineItemsList().stream()
//				.map(OrderLineItems -> OrderLineItems.getProductName())
//				.toList();
		String name= order.getOrderLineItemsList().get(0).getProductName();
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8010/product/name/"+name;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Product> entity = new HttpEntity<>(headers);
		ResponseEntity<Product> response = restTemplate.exchange(url,HttpMethod.GET,entity,Product.class);
		
//		Order order  = orderMapper.mapProductToOrder(response.getBody());
		Boolean result = orderMapper.mapProductToOrder1(response.getBody(), order);
		if(result == true) {
			order.setOrderNumber(UUID.randomUUID().toString());
			orderRepo.save(order);
			return "Order placed successfully";
		}else {
		return "Product not in stock";
		}
	}

//	private Boolean orderInventory() {
//		RestTemplate restTemplate = new RestTemplate();
//		String url = "http://localhost:8010/product";
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		HttpEntity<Product[]> entity = new HttpEntity<>(headers);
//		ResponseEntity<Product[]> response = restTemplate.exchange(url,HttpMethod.GET,entity,Product[].class);
//		int quantity= response.getBody().getProductQuantity();
////		
//		if(quantity<=0) {
//		return false;}
//		else
//		return true;
//	}
	
//	@Override
//	public Order placeOrder(Order ord) {
//		Order order = new Order();
//		order.setOrderNumber(UUID.randomUUID().toString());
//		order.setOrderLineItemsList(ord.getOrderLineItemsList());

//		List<String> productNames = order.getOrderLineItemsList().stream()
//		.map(OrderLineItems -> OrderLineItems.getProductName())
//		.toList();
//		
//		Map<Long, Integer> employeesMap = order.getOrderLineItemsList().stream()
//                .collect( Collectors.toMap(a -> )));
//		
//		Product[] productArray = WebClient.get()
//				.uri("http://localhost:8010/product",
//						UriBuilder -> UriBuilder.queryParam("productNames", productNames).build())
//				.retrieve()
//				.bodyToMono(Product[].class)
//				.block();
		
//	    HttpHeaders headers = new HttpHeaders();
//	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//	      HttpEntity <String> entity = new HttpEntity<String>(headers);
//		restTemplate.exchange("http://localhost:8080/products", HttpMethod.GET, entity, String.class).getBody();
		
		
		
			
				
//		orderRepo.save(order);
//		return order;
//	}
	
	
	
}
