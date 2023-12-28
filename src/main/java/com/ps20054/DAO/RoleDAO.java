package com.ps20054.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ps20054.entity.Account;
import com.ps20054.entity.Role;

public interface RoleDAO extends JpaRepository<Role, String> {

}
