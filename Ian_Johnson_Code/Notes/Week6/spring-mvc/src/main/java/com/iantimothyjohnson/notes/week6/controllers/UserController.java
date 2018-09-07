package com.iantimothyjohnson.notes.week6.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iantimothyjohnson.notes.week6.beans.User;
import com.iantimothyjohnson.notes.week6.services.UserService;

// Our first @RestController! Comment out the below line to make LoginController
// work:
// @RestController("/users")
public class UserController {
	@Autowired
	private UserService service;

	@RequestMapping(method=RequestMethod.GET)
	public List<User> getAll() {
		return service.getAll();
	}
}
