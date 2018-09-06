package com.iantimothyjohnson.notes.week6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iantimothyjohnson.notes.week6.beans.Author;
import com.iantimothyjohnson.notes.week6.repositories.AuthorRepository;

@Service
public class AuthorService {
	@Autowired
	private AuthorRepository authorRepo;
	
	public Author addAuthor(Author a) {
		// Do some validation to make sure author isn't in DB or whatever
		// "business logic" is required.
		return authorRepo.add(a);
	}
	
	public List<Author> getAll() {
		return authorRepo.getAll();
	}
}
