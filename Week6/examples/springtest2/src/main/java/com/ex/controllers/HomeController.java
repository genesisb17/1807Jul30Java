package com.ex.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("/home")
public class HomeController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String test() {
		return "HELLO SPRING";
	}
	

}
