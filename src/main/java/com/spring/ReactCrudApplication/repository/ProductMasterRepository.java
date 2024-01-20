package com.spring.ReactCrudApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.ReactCrudApplication.entity.ProductMaster;

@Repository
public interface ProductMasterRepository extends JpaRepository<ProductMaster, Integer> {

}
