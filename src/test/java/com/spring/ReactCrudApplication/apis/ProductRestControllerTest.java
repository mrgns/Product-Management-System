package com.spring.ReactCrudApplication.apis;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.ReactCrudApplication.dto.ProductDto;
import com.spring.ReactCrudApplication.service.ProductService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ProductRestControllerTest {

	@InjectMocks
	ProductRestController productRestController;
	
	@Mock
	ProductService productService;
	
	@Mock
	ProductDto productDto;
	
	@Test
	void test() {
		//when(productService.saveProduct(productDto)).thenReturn(null);
		assertNotNull(productRestController.addProduct(productDto));
	}

}
