package com.ps20054.rest.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ps20054.entity.Account;
import com.ps20054.entity.Authority;
import com.ps20054.entity.Role;
import com.ps20054.service.AccountService;
import com.ps20054.service.AuthorityService;
import com.ps20054.service.RoleService;

@CrossOrigin("*")
@RestController
@RequestMapping("rest")
public class AuthorityRestController {
	@Autowired
	AuthorityService authorityService;
	
	@GetMapping("authorities")
	public List<Authority> findAll(@RequestParam("admin") Optional<Boolean> admin){
		if(admin.orElse(false)) {
			return authorityService.findAuthoritiesOfAdministrators();
		}
		
		return authorityService.findAll();
	}
	
	@GetMapping("authoritiesOne")
	public List<Authority> getOneByRole(@RequestParam("username") String username){
		return authorityService.getOneByRole(username);
	}
	
	@PostMapping("authorities")
	public Authority post(@RequestBody Authority authority) {
		return authorityService.create(authority);
	}
	
	@DeleteMapping("authorities/{id}")
	public void delete(@PathVariable("id")Integer id) {
		authorityService.delete(id);	
	}
	
	
}
