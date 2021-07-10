package com.example.demo.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Component
public class Invoice {

	int invoiceNumber;
	Customer customer;
	Product product;
	
	public void setInvoiceNumber(int invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	
	// Setter DI
	
	@Autowired
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Autowired
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	// Constructor DI
	
//	@Autowired
//	public Invoice(Customer customer, Product product) {
//		super();
//		this.customer = customer;
//		this.product = product;
//	}
//	
	
	
	
		
	
}
