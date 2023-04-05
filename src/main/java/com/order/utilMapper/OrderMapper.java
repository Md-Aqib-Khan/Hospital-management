package com.order.utilMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.order.model.Order;
import com.order.model.OrderLineItems;
import com.order.model.Product;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OrderMapper{

	public Order mapProductToOrder(Product product) {
		Order order = new Order();
//		Product product1 = new Product();
		OrderLineItems orderLineItems = new OrderLineItems();
		List<OrderLineItems> orderLineItemList = new ArrayList<>();
		order.setOrderNumber(UUID.randomUUID().toString());
		orderLineItems.setProductName(product.getProductName());
		orderLineItems.setQuantity(product.getProductQuantity());
		order.setOrderLineItemsList(orderLineItemList);
//		product1.setProductName(product.getProductName());
//		product1.setProductQuantity(product.getProductQuantity());
		return order;
	}
	
	
	public Boolean mapProductToOrder1(Product product, Order order1) {
		Product product1 = new Product();
		if(product.getProductQuantity()>=order1.getOrderLineItemsList().get(0).getQuantity() && 
				product.getProductName().equals(order1.getOrderLineItemsList().get(0).getProductName())) {
			product1.setProductBrand(product.getProductBrand());
			product1.setProductCategory(product.getProductCategory());
			product1.setProductId(product.getProductId());
			product1.setProductName(product.getProductName());
			product1.setProductPrice(product.getProductPrice());
			product1.setProductQuantity(product.getProductQuantity());
			return true;
		}
		return false;
	}
}
