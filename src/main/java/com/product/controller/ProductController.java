package com.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.dao.ProductRepo;
import com.product.model.Order;
import com.product.model.OrderItem;
import com.product.model.Product;
import com.product.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/product")	
public class ProductController {

	@Autowired
	private ProductService productService;

	// get all products handler
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProduct() {
		log.info("success");
		List<Product> list = productService.getAllProducts();
		if (list.size() <= 0) {
			//if error occur
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		//if event occur perfectly
		return ResponseEntity.of(Optional.of(list));
	}

	// get single product handler
	@GetMapping("/products/{productid}")
	public ResponseEntity<Product> getProductById(@PathVariable("productid") int id) {
		Product product = productService.getProductById(id);
		if (product == null) {
			//if error occur
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		log.info("success");
		//if event occur perfectly
		return ResponseEntity.of(Optional.of(product));
	}

	// add new product handler
	@PostMapping("/products")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {

		try {
			Product p = productService.addProduct(product);
			//if event occur perfectly
			return ResponseEntity.of(Optional.of(p));
		} catch (Exception e) {
			e.printStackTrace();
		}
		//if error occur
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	// update product handler
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable("id") int id) {
		try {
			Product p = productService.updateProduct(product, id);
			//if event occur perfectly
			return ResponseEntity.of(Optional.of(p));
		} catch (Exception e) {
			// TODO: handle exception
		}
		//if error occur
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	// delete product handler
	@DeleteMapping("/products/{ProductId}")
	public ResponseEntity<Void> deleteProduct(@PathVariable("ProductId") int id) {
		try {
			productService.deleteProduct(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

	}

	@GetMapping("/ping")
	public String ping() {
		log.info("successfully created ping");
		return "Success";

	}

	//get by name
	@GetMapping("name/{name}")
	public Product findByName(@PathVariable("name") String name) {
		Product p = productService.findByProductName(name);
		return p;
	}

	@GetMapping("/products/category/{category}")
	public List<Product> findByCategory(@PathVariable("category") String cat) {
		List<Product> p = productService.findByProductCategory(cat);
		return p;
	}

	@GetMapping("/products/{id}/{quantity}")
	public Product orderById(@PathVariable("id") int id, @PathVariable("quantity") int quantity) {
		Product product = productService.orderProductById(id, quantity);
		return product;
	}
	
	//get by name
		@GetMapping
		public List<Product> findByName(@RequestParam List<String> name) {
			List<Product> p = productService.findByProductNameIn(name);
			return p;
		}
		
		@PostMapping("/placeOrder")
		public String placeOrder(@RequestBody Product product) {
			productService.placeOrder(product);
			return "order placed successfully";
		}
		
		
}
