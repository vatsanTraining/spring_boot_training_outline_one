package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.RestaurantInfo;
import com.example.demo.services.RestaurantService;

import io.swagger.v3.oas.annotations.Operation;

import java.util.*;
@RestController
@RequestMapping(path = "/api/v1")
public class RestaurantController {

	
	@Autowired
	private RestaurantService service;
	
	
	@Operation(description = "This Endpoint bring all Registred Restaurant")
	@GetMapping(path = "/restaurants",produces = "application/json")
	public List<RestaurantInfo> getAll(){
		
		return this.service.getAll();
	}
	
	@GetMapping(path = "/restaurants/{id}",produces = "application/json")
	public ResponseEntity<RestaurantInfo> findById(@PathVariable("id") int id){
		
	 RestaurantInfo foundEntity =	 this.service.findById(id)
				 .orElseThrow( () -> new NoSuchElementException("Element Not Found"));
	 
	   return ResponseEntity.ok().body(foundEntity);
	
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
	public ResponseEntity<RestaurantInfo> remove(@RequestBody RestaurantInfo entity){

		  
	 
	   return ResponseEntity.ok().body(this.service.remove(entity));
	
	}

	
	@GetMapping("/restaurants/pages/{pageNo}/{size}/{sortProp}")
	public List<RestaurantInfo> getPages(@PathVariable("pageNo") int page , 
			@PathVariable("size") int size, @PathVariable("sortProp") String sortProp){
		
		
		return this.service.getPages(page, size, sortProp);
	}
	
	
	@PatchMapping(path = "/restaurants/{timing}")
	public ResponseEntity<String> updateTiming(@PathVariable("timing") String timing) {
		
		int count = this.service.updateTimining(timing);
		
		return ResponseEntity.ok().body("Updated Timing of "+count +"Restaurants");
	}
	

	@GetMapping(path = "/restaurants/srch/{city}")
	public List<RestaurantInfo> getByCity(@PathVariable("city") String city) {
		
		
		return this.service.getByLocation(city);
	}

	
	
}
