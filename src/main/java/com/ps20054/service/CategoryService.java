package com.ps20054.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ps20054.entity.Category;

@Service
public interface CategoryService {

	List<Category> findAll();

}
