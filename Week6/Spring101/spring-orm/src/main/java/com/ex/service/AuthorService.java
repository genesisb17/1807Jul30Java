package com.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.beans.Author;
import com.ex.dao.AuthorRepository;

@Service("authorService")
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepo;
	
	public Author addAuthor(Author a) {
		//do some validation to make sure author isn't in db
		//or whatever
		return authorRepo.add(a);
	}
	
	public List<Author> getAll() {
		return authorRepo.getAll();
	}
}
