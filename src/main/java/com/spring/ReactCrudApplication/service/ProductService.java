package com.spring.ReactCrudApplication.service;

import java.util.EnumMap;
import java.util.List;

import com.spring.ReactCrudApplication.dto.ProductDto;
import com.spring.ReactCrudApplication.enums.ApiResponse;

public interface ProductService {

	EnumMap<ApiResponse, Object> saveProduct(ProductDto productDto);

	EnumMap<ApiResponse, Object> saveAllProduct(List<ProductDto> productDto);

	EnumMap<ApiResponse, Object> updateProduct(ProductDto productDto);

	EnumMap<ApiResponse, Object> findProduct(Integer productId);

	EnumMap<ApiResponse, Object> findAllProduct();

	EnumMap<ApiResponse, Object> deleteProduct(Integer productId);

}
