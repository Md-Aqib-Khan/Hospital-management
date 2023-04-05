package com.product.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.product.dao.ProductRepo;
import com.product.model.Order;
import com.product.model.OrderItem;
import com.product.model.Product;
import com.product.service.ProductService;

import lombok.extern.slf4j.Slf4j;


@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	

	public ProductServiceImpl() {

	}

//	private static List<Product> list = new ArrayList<>();
//	static {
//		list.add(new Product(1, "mobile", "oneplus", "10R", 35000));
//		list.add(new Product(1, "bike", "bajaj", "pulsar 150cc", 135000));
//		list.add(new Product(1, "cloth", "blackberry", "blzzer", 000));
//
//	}

	
//	get all products
	@Override
	public List<Product> getAllProducts() {
//			List<Product> list=this.productRepo.findAll();
		return productRepo.findAll();
	}
	
	// get single product
	@Override
	public Product getProductById(int productId) {
		Product product = this.productRepo.findById(productId);
		
		return product;
	}

	// create new product
	@Override
	public Product addProduct(Product product) {
		Product result = productRepo.save(product);
		return result;
	}

	// update product
	@Override
	public Product updateProduct(Product product, int productId) {
		product.setProductId(productId);
		productRepo.save(product);
		return product;
	}
	
//	@Override
//	public Product updateProduct(Product product, int productId) {
//		Product updateProduct = productRepo.findById(productId);
//		updateProduct.setProductName(product.getProductName());
//		updateProduct.setProductCategory(product.getProductCategory());
//		updateProduct.setProductPrice(product.getProductPrice());
//		updateProduct.setProductBrand(product.getProductBrand());
//		updateProduct.setProductId(product.getProductId());	
//		updateProduct.setProductQuantity(product.getProductQuantity());
//		productRepo.save(updateProduct);
//		return product;
//	}

	// delete product
	@Override
	public void deleteProduct(int productId) {
		productRepo.deleteById(productId);
	}
	
	@Override
	public Product findByProductName(String name){
		Product p = this.productRepo.findByProductName(name);
		System.out.println(p.getProductName());
		return p;
	}

	
	@Override
	public List<Product> findByProductCategory(String cat) {
		List<Product> p = productRepo.findByProductCategory(cat);
		return p;
	}

	@Override
	public Product orderProductById(int id, int quantity) {
		Product product = productRepo.findById(id);
			product.getProductQuantity();
			product.setProductQuantity(product.getProductQuantity()-quantity);
			return productRepo.save(product);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Product> findByProductNameIn(List<String> productName) {
		List<Product> p = this.productRepo.findByProductNameIn(productName);
		return p;
	}
	
	Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	public String placeOrder(Product product) {
	Object forObject= restTemplate.getForObject("http://localhost:8012/order/placeOrder", Object.class);
	logger.info("{}",forObject);
		return "order placed successfully";
	}

	
	
	
	
}
