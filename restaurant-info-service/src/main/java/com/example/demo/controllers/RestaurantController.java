package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	
	@GetMapping(path = "/restaurants",produces = "application/json")
	public List<RestaurantInfo> getAll(){
		
		return this.service.getAll();
	}
	
	@PostMapping(path = "/restaurants",produces = "application/json", consumes = "application/json")
	public RestaurantInfo add(@RequestBody RestaurantInfo entity) {
		
		return this.service.add(entity);
	}
	
}
