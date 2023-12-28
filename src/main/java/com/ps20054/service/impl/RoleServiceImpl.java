package com.ps20054.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps20054.DAO.RoleDAO;
import com.ps20054.entity.Role;
import com.ps20054.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleDAO roleDAO;
	
	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roleDAO.findAll();
	}

}
