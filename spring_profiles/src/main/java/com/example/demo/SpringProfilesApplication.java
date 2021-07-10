package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.example.demo.models.Customer;
import com.example.demo.models.Product;

@SpringBootApplication
public class SpringProfilesApplication {

	public static void main(String[] args) {
	
		ConfigurableApplicationContext ctx= SpringApplication.run(SpringProfilesApplication.class, args);
	
//		      Customer cust = ctx.getBean(Customer.class);
//		      
//		      System.out.println(cust);
//		      
		System.out.println(ctx.getBean(Product.class));
		      ctx.close();
	}

	
	@Bean
	@Profile(value = "dev")
	public Customer ram() {
		
		return new Customer(101, "Devloper Ramesh", "ram@abc.com");
	}
	
	@Bean
	@Profile(value = "prod")
	public Customer shyam() {
		
		return new Customer(102, "Admin Shyam", "shyam@abc.com");
	}
	
	@Bean
	@Profile(value = "prod")
	@Primary
	public Customer rahul() {
		
		return new Customer(103, "QA Rahul", "rahul@abc.com");
	}
}
