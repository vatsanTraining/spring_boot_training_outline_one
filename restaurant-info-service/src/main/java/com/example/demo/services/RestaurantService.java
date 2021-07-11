package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.RestaurantInfo;
import com.example.demo.repos.RestaurantInfoRepository;
import java.util.*;
@Service
public class RestaurantService {

	@Autowired
	RestaurantInfoRepository repo;
	
	
	   public List<RestaurantInfo> getAll(){
		   
		   return repo.findAll();
	   }
	
	   
	   public RestaurantInfo  add(RestaurantInfo entity) {
		   
		   return repo.save(entity);
	   }
	
	}


	
	
	

