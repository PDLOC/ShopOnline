package com.ps20054.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps20054.DAO.CategoryDAO;
import com.ps20054.entity.Category;
import com.ps20054.service.CategoryService;

@Service
public class CategoryServiceImp implements CategoryService {
	@Autowired
	CategoryDAO categoryDAO;
	
	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return categoryDAO.findAll();
	}

}
