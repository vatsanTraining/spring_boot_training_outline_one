package com.example.demo.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Columns;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "restaurants")
public class RestaurantInfo {

	@Id
    private int id;
	private String name;
	private String serviceArea;  //service_Area
    private String emailAddress;  // email_Address
    private String menuType;
    private String openingHours;

}
