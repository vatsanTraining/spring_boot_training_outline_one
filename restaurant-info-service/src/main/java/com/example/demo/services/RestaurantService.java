package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
	

        public Optional<RestaurantInfo>  findById(int id) {
		   
		   return repo.findById(id);
	   }
        
        public RestaurantInfo  update(RestaurantInfo entity) {
 		   
 		   return repo.save(entity);
 	   }
        

        public RestaurantInfo  remove(RestaurantInfo entity) {
  		   
               if(repo.existsById(entity.getId())) {
            	   
            	   repo.delete(entity);
               } else {
            	   
            	   throw new NoSuchElementException("Element With Id "+entity.getId() +"present");
               }
               
               return entity;
        }

        public List<RestaurantInfo>  getPages(int page , int size, String sortProp) {
        	
        	
        	PageRequest paging = PageRequest.of(page,size,Sort.by(sortProp).ascending ());
            
            Page<RestaurantInfo> pagedResult = repo.findAll(paging);
             
             if(pagedResult.hasContent()) {
                 return pagedResult.getContent();
                      } else {
                 return null;
                  }        }
	}


	
	
	

