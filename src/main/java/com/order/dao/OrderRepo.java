package com.order.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.order.model.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order , Integer>{
	
	public Order findById(int id);
	
	
}
