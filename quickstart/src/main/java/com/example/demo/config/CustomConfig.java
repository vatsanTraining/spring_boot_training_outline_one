package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Customer;
import com.example.demo.model.Product;

@Configuration
public class CustomConfig {

	
	
	@Bean
	public Customer ramesh() {
		
		return new Customer(101,"Ramesh","ram@abc.com");
	}
	
	@Bean
	public Product tv() {
		
		return new Product(202,"sony tv",2);
	}
	

}
