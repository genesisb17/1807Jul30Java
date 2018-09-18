package com.account.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.account.beans.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{

	List<Account> findByCustomerId(int id);
	
}
