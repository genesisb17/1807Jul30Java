package com.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ex.beans.Author;
import com.ex.repository.AuthorRepository;

@Service("authorService")
@Transactional
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepo;
	
	public List<Author> getAll() {
		return authorRepo.findAll();
	}
	
}
