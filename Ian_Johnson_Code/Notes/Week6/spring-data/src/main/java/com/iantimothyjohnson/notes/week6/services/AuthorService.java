package com.iantimothyjohnson.notes.week6.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iantimothyjohnson.notes.week6.beans.Author;
import com.iantimothyjohnson.notes.week6.repositories.AuthorRepository;

@Service
@Transactional
public class AuthorService {
	@Autowired
	private AuthorRepository authorRepo;
	
	public List<Author> getAll() {
		return authorRepo.findAll();
	}
}
