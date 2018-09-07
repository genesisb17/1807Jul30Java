package com.iantimothyjohnson.notes.week6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iantimothyjohnson.notes.week6.beans.Genre;
import com.iantimothyjohnson.notes.week6.repositories.GenreRepository;

@Service
public class GenreService {
	@Autowired
	private GenreRepository genreRepository;
	
	public List<Genre> getAll() {
		return genreRepository.getAll();
	}
	
	public Genre add(Genre g) {
		return genreRepository.add(g);
	}
}
