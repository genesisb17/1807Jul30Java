package com.iantimothyjohnson.notes.week6.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iantimothyjohnson.notes.week6.beans.Book;
import com.iantimothyjohnson.notes.week6.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	@Autowired
	private BookService bookService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Book>> getAll() {
		return ResponseEntity.ok(bookService.getAll());
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> add(@RequestBody Book b) {
		return new ResponseEntity<Book>(bookService.add(b), HttpStatus.CREATED);
	}
}
