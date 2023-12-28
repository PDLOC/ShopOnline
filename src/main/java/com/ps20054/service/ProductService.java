package com.ps20054.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ps20054.entity.Product;
@Service
public interface ProductService {

	List<Product> findAll();

	Product findById(Integer id);

	List<Product> findByCategoryId(String cid);

	Product create(Product product);

	Product update(Product product);

	void delete(Integer id);


	
}
