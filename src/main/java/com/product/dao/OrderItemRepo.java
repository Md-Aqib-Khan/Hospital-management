package com.product.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.model.OrderItem;

@Repository
public interface OrderItemRepo extends JpaRepository<OrderItem, Long> {
	
}
