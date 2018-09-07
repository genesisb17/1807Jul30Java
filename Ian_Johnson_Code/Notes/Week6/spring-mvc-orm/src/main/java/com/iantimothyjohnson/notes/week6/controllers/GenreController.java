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

import com.iantimothyjohnson.notes.week6.beans.Genre;
import com.iantimothyjohnson.notes.week6.service.GenreService;

@RestController
@RequestMapping("/genres")
public class GenreController {
	@Autowired
	private GenreService genreService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Genre>> getAll() {
		return ResponseEntity.ok(genreService.getAll());
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Genre> add(@RequestBody Genre g) {
		return new ResponseEntity<Genre>(genreService.add(g), HttpStatus.CREATED);
	}
}
