package com.spring.ReactCrudApplication.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="Products")
public class ProductMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private Integer productId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="company")
	private String company;
	
	@Column(name="price")
	private Double price;
	
	@Column(name="in_stocked")
	private boolean inStocked;

}
