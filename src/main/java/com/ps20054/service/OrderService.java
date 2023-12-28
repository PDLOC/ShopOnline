package com.ps20054.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.ps20054.entity.Order;

@Service
public interface OrderService {

	Order create(JsonNode orderData);

	Object findById(Long id);

	List<Order> findByUsername(String username);

}
