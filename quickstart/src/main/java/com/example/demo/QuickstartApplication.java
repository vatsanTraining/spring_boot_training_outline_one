package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.model.Invoice;
import com.example.demo.model.OrderBook;

@SpringBootApplication
public class QuickstartApplication {

	public static void main(String[] args) {
   ConfigurableApplicationContext ctx=		SpringApplication.run(QuickstartApplication.class, args);
	
           Invoice inv = ctx.getBean(Invoice.class);
           
           System.out.println(inv);
           
           OrderBook book = ctx.getBean(OrderBook.class);
           
           System.out.println(book);
	
	}

}
