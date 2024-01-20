package com.spring.ReactCrudApplication.serviceImpl;

import static com.spring.ReactCrudApplication.constants.StatusConstant.*;
import static com.spring.ReactCrudApplication.enums.ApiResponse.*;

import java.util.EnumMap;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.spring.ReactCrudApplication.dto.ProductDto;
import com.spring.ReactCrudApplication.entity.ProductMaster;
import com.spring.ReactCrudApplication.enums.ApiResponse;
import com.spring.ReactCrudApplication.repository.ProductMasterRepository;
import com.spring.ReactCrudApplication.service.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

	private final ProductMasterRepository productMasterRepository;
	private final ModelMapper mapper;

	@Override
	public EnumMap<ApiResponse, Object> saveProduct(ProductDto productDto) {
		EnumMap<ApiResponse, Object> map = new EnumMap<>(ApiResponse.class);
		try {
			ProductMaster product = mapper.map(productDto, ProductMaster.class);
			product = productMasterRepository.save(product);
			map.put(DATA, product);
			map.put(STATUS, SUCCESS);
			map.put(MESSAGE, SAVE_PRODUCT);

		} catch (Exception e) {
			map.put(STATUS, ERROR);
			map.put(MESSAGE, EXCEPTION_OCCUR);
			map.put(EXCEPTION, e);
		}
		return map;
	}

	@Override
	public EnumMap<ApiResponse, Object> saveAllProduct(List<ProductDto> productDto) {
		EnumMap<ApiResponse, Object> map = new EnumMap<>(ApiResponse.class);
		try {
			List<ProductMaster> productList = productDto.parallelStream()
					.map(product -> mapper.map(product, ProductMaster.class)).toList();
			List<ProductMaster> list = productMasterRepository.saveAll(productList);
			map.put(DATA, list);
			map.put(STATUS, SUCCESS);
			map.put(MESSAGE, SAVE_ALL_PRODUCTS);
		} catch (Exception e) {
			map.put(STATUS, ERROR);
			map.put(MESSAGE, EXCEPTION_OCCUR);
			map.put(EXCEPTION, e);
		}
		return map;
	}

	@Override
	public EnumMap<ApiResponse, Object> updateProduct(ProductDto productDto) {
		EnumMap<ApiResponse, Object> map = new EnumMap<>(ApiResponse.class);
		try {
			Optional<ProductMaster> checkProduct = productMasterRepository.findById(productDto.getProductId());
			if (checkProduct.isPresent()) {
				ProductMaster product = checkProduct.get();
				product = mapper.map(productDto, ProductMaster.class);
				product = productMasterRepository.save(product);
				map.put(DATA, product);
				map.put(STATUS, SUCCESS);
				map.put(MESSAGE, PRODUCT_UPDATED);
			} else {
				map.put(STATUS, ERROR);
				map.put(MESSAGE, PRODUCT_NOT_PRESENT);
			}
		} catch (Exception e) {
			map.put(STATUS, ERROR);
			map.put(MESSAGE, EXCEPTION_OCCUR);
			map.put(EXCEPTION, e);
		}
		return map;
	}

	@Override
	public EnumMap<ApiResponse, Object> findProduct(Integer productId) {
		EnumMap<ApiResponse, Object> map = new EnumMap<>(ApiResponse.class);
		try {
			Optional<ProductMaster> product = productMasterRepository.findById(productId);
			if (product.isPresent()) {
				map.put(DATA, mapper.map(product.get(), ProductDto.class));
			} else {
				map.put(MESSAGE, PRODUCT_NOT_PRESENT);
			}
			map.put(STATUS, SUCCESS);
		} catch (Exception e) {
			map.put(STATUS, ERROR);
			map.put(MESSAGE, EXCEPTION_OCCUR);
			map.put(EXCEPTION, e);
		}
		return map;
	}

	@Override
	public EnumMap<ApiResponse, Object> deleteProduct(Integer productId) {
		EnumMap<ApiResponse, Object> map = new EnumMap<>(ApiResponse.class);
		try {
			productMasterRepository.deleteById(productId);
			map.put(MESSAGE, PRODUCT_DELETE);
			map.put(STATUS, SUCCESS);
		} catch (Exception e) {
			map.put(STATUS, ERROR);
			map.put(MESSAGE, EXCEPTION_OCCUR);
			map.put(EXCEPTION, e);
		}
		return map;
	}

	@Override
	public EnumMap<ApiResponse, Object> findAllProduct() {
		EnumMap<ApiResponse, Object> map = new EnumMap<>(ApiResponse.class);
		try {
			List<ProductMaster> products = productMasterRepository.findAll();
			List<ProductDto> productDtoList = products.parallelStream()
					.map(product -> mapper.map(product, ProductDto.class)).toList();
			map.put(DATA, productDtoList);
			map.put(COUNT, productDtoList.size());
			map.put(STATUS, SUCCESS);
		} catch (Exception e) {
			map.put(STATUS, ERROR);
			map.put(MESSAGE, EXCEPTION_OCCUR);
			map.put(EXCEPTION, e);
		}
		return map;
	}

}
