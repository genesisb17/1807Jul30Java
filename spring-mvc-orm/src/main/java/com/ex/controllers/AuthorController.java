package com.ex.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ex.beans.Author;
import com.ex.service.AuthorService;

@RestController
@RequestMapping("/authors")
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@RequestMapping(method=RequestMethod.GET
			,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Author>> getAll() {
		List<Author> authors = authorService.getAll();
		if (authors.size() == 0) {
			//send not found
			return new ResponseEntity<List<Author>>(authors, HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<List<Author>>(authors, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Author> getByID(@PathVariable int id) {
		return new ResponseEntity<Author>(authorService.getById(id), HttpStatus.OK);
		
	}

	public ResponseEntity<Author> addAuthor(Author a) {
		return null;
		
	}
	
}
