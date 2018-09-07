package com.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.beans.Author;
import com.ex.repository.AuthorRepository;

@Service("authorService")
public class AuthorService {
	
	@Autowired
	private AuthorRepository authorRepo;

	public Author addAuthor(Author a) {
		//do some validation to make sure author isnt in db
		//or whatver "business logic" youd require
		return authorRepo.add(a);
	}
	
	public List<Author> getAll(){
		return authorRepo.getAll();
	}
}
