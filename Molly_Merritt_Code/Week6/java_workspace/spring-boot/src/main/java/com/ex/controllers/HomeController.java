package com.ex.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping("/home")	// if you don't write a method, it assumes GET method
	public String welcome() {
		return "Welcome to Spring Boot!";
	}

}
