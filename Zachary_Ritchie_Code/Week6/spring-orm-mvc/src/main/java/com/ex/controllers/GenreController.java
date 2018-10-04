package com.ex.controllers;

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

import com.ex.beans.Genre;
import com.ex.service.GenreService;

@RestController
@RequestMapping("/genre")
public class GenreController 
{
	@Autowired
	private GenreService genreService;
	
	@RequestMapping(method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Genre>> getAll() {
		List<Genre> genres = genreService.getAll();
		if(genres.size() == 0) {
			genres = null;
			return new ResponseEntity<List<Genre>>(genres, HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<Genre>>(genres, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Genre> getByID(@PathVariable int id){
		return new ResponseEntity<Genre>(genreService.getById(id), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE, //request body content
			produces=MediaType.APPLICATION_JSON_VALUE) //response body content
	public ResponseEntity<Genre> addGenre(@RequestBody Genre a){ //indicate that the author will be found in the request body
		a = genreService.addGenre(a);
		if(a == null) {
			return new ResponseEntity<Genre>(a, HttpStatus.CONFLICT); //if there is issue with adding return with status of conflict
		}
		else {
			return new ResponseEntity<Genre>(a, HttpStatus.CREATED); // return w 201 status
		}
	}
}
