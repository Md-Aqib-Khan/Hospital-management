package com.product.service;

import java.util.List;

import com.product.model.Order;
import com.product.model.OrderItem;
import com.product.model.Product;


public interface ProductService {
	

	public List<Product> getAllProducts();
	
	public Product getProductById(int productId);
	
	public Product addProduct(Product product);

	public Product  updateProduct(Product product, int productId);

	public void deleteProduct(int productId);
	
	public Product findByProductName(String name);
	
	public List<Product> findByProductNameIn(List<String> name);
	

	public List<Product> findByProductCategory(String cat);

	public Product orderProductById(int id, int quantity);
	
	public String placeOrder(Product product);

}
