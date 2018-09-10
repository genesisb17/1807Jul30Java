package com.ex.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ex.beans.Author;
import com.ex.service.AuthorService;
@RestController
@RequestMapping("/authors")
public class AuthorController {
	
	@Autowired
	private AuthorService as;
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Author>>getAll() {
		List<Author> authors = as.getAll();
		if(authors.size()==0) {
			
			return new ResponseEntity<List<Author>>(authors, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<Author>>(authors, HttpStatus.OK);
		}
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Author> getById(@PathVariable int id) {
		return new ResponseEntity<Author>(as.getById(id), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE, //request body content
			produces=MediaType.APPLICATION_JSON_VALUE) //response body content
	public ResponseEntity<Author> addAuthor(@Valid @RequestBody Author a){ //indicate that the author will be found in the request body
		a = as.addAuthor(a);
		if(a == null) {
			return new ResponseEntity<Author>(a, HttpStatus.CONFLICT); //if there is issue with adding return with status of conflict
		}
		else {
			return new ResponseEntity<Author>(a, HttpStatus.CREATED); // return w 201 status
		}
	}
}
