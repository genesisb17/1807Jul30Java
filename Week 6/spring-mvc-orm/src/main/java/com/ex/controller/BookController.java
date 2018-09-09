package com.ex.controller;

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

import com.ex.beans.Book;
import com.ex.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Book>> getAll() {
		List<Book> books = bookService.getAll();
		if(books.size() == 0) {
			books = null;
			return new ResponseEntity<List<Book>>(books, HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> getByID(@PathVariable int id){
		return new ResponseEntity<Book>(bookService.getById(id), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE, //request body content
			produces=MediaType.APPLICATION_JSON_VALUE) //response body content
	public ResponseEntity<Book> addBook(@RequestBody Book a){ //indicate that the author will be found in the request body
		a = bookService.addBook(a);
		if(a == null) {
			return new ResponseEntity<Book>(a, HttpStatus.CONFLICT); //if there is issue with adding return with status of conflict
		}
		else {
			return new ResponseEntity<Book>(a, HttpStatus.CREATED); // return w 201 status
		}
	}
	
}
