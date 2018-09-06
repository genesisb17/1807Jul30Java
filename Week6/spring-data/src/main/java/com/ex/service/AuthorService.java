package com.ex.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.beans.Author;
import com.ex.repositories.AuthorRepository;

@Service("authorService")
@Transactional
public class AuthorService {
	
	@Autowired
	private AuthorRepository authorRepo;
	
	public List<Author> getAll(){
		return authorRepo.findAll();
	}
}
