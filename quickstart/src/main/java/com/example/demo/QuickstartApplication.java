package com.example.demo;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.model.Invoice;
import com.example.demo.model.OrderBook;
import com.example.demo.model.Student;

@SpringBootApplication
public class QuickstartApplication {

	public static void main(String[] args) {
  // ConfigurableApplicationContext ctx= SpringApplication.run(QuickstartApplication.class, args);
	
		 ConfigurableApplicationContext ctx = 
				  new SpringApplicationBuilder(QuickstartApplication.class)
				  .properties("spring.config.name:module1").bannerMode(Banner.Mode.OFF).
				      run(args);
		 
		
		
//           Invoice inv = ctx.getBean(Invoice.class);
//           
//           System.out.println(inv);
//           
//           OrderBook book = ctx.getBean(OrderBook.class);
//           
//           System.out.println(book);
	
        Student ram = ctx.getBean(Student.class);
        
        System.out.println(ram);
        
        System.out.println("Is Singleton: ="+ ctx.isSingleton("student"));
        System.out.println("Is Prototype: ="+ ctx.isPrototype("student"));
        
        
   
      //ctx.close();
	}

}
