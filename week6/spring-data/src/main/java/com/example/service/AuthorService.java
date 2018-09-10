package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.beans.Author;
import com.example.repository.AuthorRepository;

@Service("authorService")
@Transactional
public class AuthorService {
	@Autowired
	private AuthorRepository authorRepo;
	
	public List<Author> getAll() {
		return authorRepo.findAll();
	}

}
