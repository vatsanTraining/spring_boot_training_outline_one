package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.RestaurantInfo;
import com.example.demo.services.RestaurantService;


import java.util.*;
@RestController
@RequestMapping(path = "/api/v1")
public class RestaurantController {

	
	@Autowired
	private RestaurantService service;
	
	
	@GetMapping(path = "/restaurants/{id}",produces = "application/json")
	public ResponseEntity<RestaurantInfo> findById(@PathVariable("id") int id){
		
	 RestaurantInfo foundEntity =	 this.service.findById(id)
				 .orElseThrow( () -> new NoSuchElementException("Element Not Found"));
	 
	   return ResponseEntity.ok().body(foundEntity);
	
	}
	
	@GetMapping(path = "/restaurants/{}",produces = "application/json")
	public List<RestaurantInfo> getAll(){
		
		return this.service.getAll();
	}
	@PostMapping(path = "/restaurants",produces = "application/json", consumes = "application/json")
	public ResponseEntity<RestaurantInfo> add(@RequestBody RestaurantInfo entity) {
		
		
		return  ResponseEntity.status(HttpStatus.CREATED).body(this.service.add(entity));
		
	}
	
	@PutMapping(path = "/restaurants",produces = "application/json", consumes = "application/json")
	public ResponseEntity<RestaurantInfo> update(@RequestBody RestaurantInfo entity) {
		
		
		return  ResponseEntity.status(HttpStatus.OK).body(this.service.add(entity));
		
	}
	
	@DeleteMapping(path = "/restaurants",produces = "application/json")
	public ResponseEntity<RestaurantInfo> remove(RestaurantInfo entity){

		  
	 
	   return ResponseEntity.ok().body(this.service.remove(entity));
	
	}

	
	@GetMapping("/restaurants/pages/{pageNo}/{size}/{sortProp}")
	public List<RestaurantInfo> getPages(@PathVariable("pageNo") int page , 
			@PathVariable("size") int size, @PathVariable("sortProp") String sortProp){
		
		
		return this.service.getPages(page, size, sortProp);
	}
	
	
	
}
