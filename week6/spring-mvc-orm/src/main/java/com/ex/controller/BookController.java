package com.ex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ex.beans.Book;
import com.ex.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService bs;
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Book>>getAll() {
		List<Book> books = bs.getAll();
		if(books.size()==0) {
			
			return new ResponseEntity<List<Book>>(books, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
		}
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> getById(@PathVariable int id) {
		return new ResponseEntity<Book>(bs.getById(id), HttpStatus.OK);
	}
	
	public ResponseEntity<Book> addBook(Book b) {
		return null;
	}
}
