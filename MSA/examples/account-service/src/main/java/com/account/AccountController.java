package com.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.account.beans.Account;
import com.account.service.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	AccountService service;
	
	@GetMapping
	public List<Account> getAllAccounts(){
		return service.findAll();
	}
	
	@RequestMapping("/hello")
	public String hello() {
		return "HELLO MICROSERVICES!";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Account> addAccount(@RequestBody Account acc){
		return new ResponseEntity<Account>(service.add(acc), HttpStatus.CREATED);
	}

}
