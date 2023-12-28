package com.ps20054.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ps20054.entity.Account;
@Service
public interface AccountService {
	public Account findById(String username);

	public List<Account> getAdministrators();

	public List<Account> findAll();

	public Account create(Account account);

	public Account update(Account account);
}
