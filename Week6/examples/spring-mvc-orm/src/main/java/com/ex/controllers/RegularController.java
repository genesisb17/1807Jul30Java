package com.ex.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ex.beans.Author;
import com.ex.service.AuthorService;

@Controller
public class RegularController {

	@Autowired
	AuthorService service;
	
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	@ResponseBody//must use in @Controller in order to return object as JSON response body
	public List<Author> getAllAuthors(){
		return service.getAll();
	}
	
}
