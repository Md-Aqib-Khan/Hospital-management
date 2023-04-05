package com.product.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.model.OrderItem;
import com.product.model.Product;



public interface ProductRepo extends JpaRepository<Product, Integer> {
	public Product findById(int id);

//	public List<Product> getProductName(String name);

	public Product findByProductName(String name);
	
	public List<Product> findByProductCategory(String cat);
	
//	@Query("select * from product where productName :n")
//	public List<Product> getProductName(@Param("n") String name);

	public List<Product> findByProductNameIn(List<String> name);

	
}
