package com.order.model;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	private int productId;
	
	private String productCategory;
	
	private String productBrand;
	
	private String productName;
	
	private double productPrice;
	
	private int productQuantity;
	
	
	
	
}
