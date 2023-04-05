package com.product.model;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import org.hibernate.annotations.GeneratorType;

import jakarta.persistence.Column;

@Data
@Entity
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long OrderId;
	
	private String productName;
	private int orderQuantity;
}
