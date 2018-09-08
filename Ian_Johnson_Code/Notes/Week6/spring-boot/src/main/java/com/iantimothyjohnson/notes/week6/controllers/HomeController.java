package com.iantimothyjohnson.notes.week6.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@RequestMapping("/home")
	public String home() {
		return "Welcome to Spring Boot!";
	}
}
