package com.ps20054.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps20054.DAO.AccountDAO;
import com.ps20054.DAO.AuthorityDAO;
import com.ps20054.entity.Account;
import com.ps20054.entity.Authority;
import com.ps20054.service.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService{
	@Autowired
	AccountDAO accountDAO;
	@Autowired
	AuthorityDAO authorityDAO;
	
	@Override
	public List<Authority> findAuthoritiesOfAdministrators() {
		List<Account> accounts = accountDAO.getAdministrators();
		return authorityDAO.authoritiesOf(accounts);
	}

	@Override
	public List<Authority> findAll() {
		return authorityDAO.findAll();
	}

	@Override
	public Authority create(Authority authority) {
		return  authorityDAO.save(authority);
	}

	@Override
	public void delete(Integer id) {
		authorityDAO.deleteById(id);
	}

	@Override
	public List<Authority> getOneByRole(String username) {
		// TODO Auto-generated method stub
		return authorityDAO.getOneByRole(username);
	}

}
