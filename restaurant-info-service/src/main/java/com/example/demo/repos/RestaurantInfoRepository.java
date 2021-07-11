package com.example.demo.repos;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.RestaurantInfo;

import java.util.*;
@Repository
public interface RestaurantInfoRepository extends JpaRepository<RestaurantInfo, Integer> {

	List<RestaurantInfo> findByserviceArea(String srchString);
	
}
