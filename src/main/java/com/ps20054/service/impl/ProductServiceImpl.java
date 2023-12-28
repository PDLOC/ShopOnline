package com.ps20054.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps20054.DAO.ProductDAO;
import com.ps20054.entity.Product;
import com.ps20054.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductDAO productDAO;

	@Override
	public List<Product> findAll() {
		
		return productDAO.findAll();
	}

	@Override
	public Product findById(Integer id) {
		// TODO Auto-generated method stub
		return productDAO.findById(id).get();
	}

	@Override
	public List<Product> findByCategoryId(String cid) {
		return productDAO.findByCategoryId(cid);
	}

	@Override
	public Product create(Product product) {
		// TODO Auto-generated method stub
		return productDAO.save(product);
	}

	@Override
	public Product update(Product product) {
		// TODO Auto-generated method stub
		return productDAO.save(product);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		productDAO.deleteById(id);
	}
}
