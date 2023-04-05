package com.product.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "p_id")
	private int productId;
	
	@Column(name = "p_category")
	private String productCategory;
	
	@Column(name = "p_brand")
	private String productBrand;
	
	@Column(name = "p_name", length=20)
	private String productName;
	
	@Column(name = "p_price")
	private double productPrice;
	
	@Column(name= "P_Quantity")
	private int productQuantity;
	
	
	
	
}
