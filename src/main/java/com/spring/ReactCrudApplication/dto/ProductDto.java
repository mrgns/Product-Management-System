package com.spring.ReactCrudApplication.dto;

import lombok.Data;

@Data
public class ProductDto {

	private Integer productId;

	private String name;

	private String company;

	private Double price;

	private Integer inStocked;

}
