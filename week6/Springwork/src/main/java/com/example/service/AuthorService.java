package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.beans.Author;
import com.example.repository.AuthorRepository;

public class AuthorService {
	@Autowired
	private AuthorRepository ar;
	public List<Author> getAuthors() {
		return ar.getAll();
	}
}
