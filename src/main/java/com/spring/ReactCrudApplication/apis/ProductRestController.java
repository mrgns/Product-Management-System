package com.spring.ReactCrudApplication.apis;

import java.util.EnumMap;
import java.util.List;

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

import com.spring.ReactCrudApplication.dto.ProductDto;
import com.spring.ReactCrudApplication.enums.ApiResponse;
import com.spring.ReactCrudApplication.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductRestController {
	
	private final ProductService productService;
	
	@PostMapping("/add")
	public ResponseEntity<EnumMap<ApiResponse, Object>> addProduct(@RequestBody ProductDto productDto){
		return new ResponseEntity<>(productService.saveProduct(productDto),HttpStatus.OK);
	}
	
	@PostMapping("addAll")
	public ResponseEntity<EnumMap<ApiResponse, Object>> addProduct(@RequestBody List<ProductDto> productDto){
		return new ResponseEntity<>(productService.saveAllProduct(productDto),HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<EnumMap<ApiResponse, Object>> updateProduct(@RequestBody ProductDto productDto){
		return new ResponseEntity<>(productService.updateProduct(productDto),HttpStatus.OK);
	}
	
	@GetMapping("/{productId}")
	public ResponseEntity<EnumMap<ApiResponse, Object>> findProduct(@PathVariable("productId") Integer productId){
		return new ResponseEntity<>(productService.findProduct(productId),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{productId}")
	public ResponseEntity<EnumMap<ApiResponse, Object>> deleteProduct(@PathVariable("productId") Integer productId){
		return new ResponseEntity<>(productService.deleteProduct(productId),HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<EnumMap<ApiResponse, Object>> findAllProduct(){
		return new ResponseEntity<>(productService.findAllProduct(),HttpStatus.OK);
	}
	
}
