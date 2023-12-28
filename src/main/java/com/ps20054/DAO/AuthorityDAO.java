package com.ps20054.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ps20054.entity.Account;
import com.ps20054.entity.Authority;

public interface AuthorityDAO extends JpaRepository<Authority, Integer> {

	@Query("SELECT DISTINCT a FROM Authority a WHERE a.account IN ?1")
	List<Authority> authoritiesOf(List<Account> accounts);

	@Query("SELECT a FROM Authority a WHERE a.account.username LIKE ?1")
	List<Authority> getOneByRole(String username);

}
