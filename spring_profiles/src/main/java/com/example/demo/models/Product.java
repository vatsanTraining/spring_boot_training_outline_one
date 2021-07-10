package com.example.demo.models;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.*;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Product {

	private int productId;
	private String productName;

	
//	@Autowired
//	@Qualifier("shyam")
//	private Customer cust;
//	
	
	@Autowired
	private Customer cust;
}
