package com.ex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ex.beans.User;
import com.ex.service.UserService;

@RestController("/users")
public class UserController {
	
	@Autowired
	private UserService uService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<User> getAll() {
		return uService.getAll();
	}
}
