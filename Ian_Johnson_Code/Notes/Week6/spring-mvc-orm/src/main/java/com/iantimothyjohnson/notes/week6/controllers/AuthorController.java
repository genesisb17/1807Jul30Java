package com.iantimothyjohnson.notes.week6.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iantimothyjohnson.notes.week6.beans.Author;
import com.iantimothyjohnson.notes.week6.service.AuthorService;

@RestController
@RequestMapping("/authors")
public class AuthorController {
	@Autowired
	private AuthorService service;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Author>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Author> getById(@PathVariable int id) {
		Author a = service.getById(id);
		return a == null ? new ResponseEntity<>(a, HttpStatus.NOT_FOUND) : ResponseEntity.ok(a);
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Author> add(@RequestBody Author a) {
		return new ResponseEntity<>(service.addAuthor(a), HttpStatus.CREATED);
	}
}
