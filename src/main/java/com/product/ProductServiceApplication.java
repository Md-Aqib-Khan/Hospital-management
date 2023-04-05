package com.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import lombok.extern.slf4j.Slf4j;


@SpringBootApplication
//@EntityScan(basePackages = {"com.shopping.main.model"})
//@ComponentScan(basePackageClasses = ProductController.class )
@Slf4j
@EnableDiscoveryClient
public class ProductServiceApplication {

	public static void main(String[] args) {
		log.info("main class work");
		SpringApplication.run(ProductServiceApplication.class, args);
		
	}

	
}
