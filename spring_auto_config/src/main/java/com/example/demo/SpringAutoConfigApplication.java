package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

import com.example.demo.auto.config.conditions.CustomerCreationCondition;
import com.example.demo.models.Customer;

@SpringBootApplication
public class SpringAutoConfigApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext	ctx=SpringApplication.run(SpringAutoConfigApplication.class, args);
	
	
	   System.out.println(ctx.getBean(Customer.class));
	   
	
	}

	
	@Bean
	@Conditional(CustomerCreationCondition.class)
	public Customer ramesh() {
		
		return new Customer(101,"Ramesh","ram@abc.com");
	}
	
	@Bean
	@ConditionalOnProperty(name="spring.application.name",  havingValue = "car-config")
	public Customer suresh() {
		
		return new Customer(102,"Suresh","sur@abc.com");
	}
	
}
