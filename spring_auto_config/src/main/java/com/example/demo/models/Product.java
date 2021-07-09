package com.example.demo.models;
import lombok.*;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor

public class Product {

	private int productId;
	private String productName;

}
