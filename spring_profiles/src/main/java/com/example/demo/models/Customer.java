package com.example.demo.models;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import lombok.*;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor

public class Customer {

	private int customerId;
	private String customerName;
	private String email;

	
	
	@Autowired
	private Environment env;
		
	@PostConstruct
	public void init() {
		
		 String[] list =env.getActiveProfiles();
		
				for(String eachItem: list) {
					System.out.println("Profile:="+eachItem);
				}
	}
	
	@PreDestroy
	public void destroy() {
		
		System.out.println(" Customer Bean REMOVED ================");
	}


	public Customer() {
		super();
		System.out.println("Inside Constructor "+env.getActiveProfiles());
		
	}

	public Customer(int customerId, String customerName, String email) {
		super();
		
		System.out.println("Inside Constructor "+env);

		this.customerId = customerId;
		this.customerName = customerName;
		this.email = email;
	}
}
