package com.ps20054.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ps20054.entity.Authority;

@Service
public interface AuthorityService {

	public List<Authority> findAuthoritiesOfAdministrators();

	public List<Authority> findAll();

	public Authority create(Authority authority);

	public void delete(Integer id);

	public List<Authority> getOneByRole(String username);

}
