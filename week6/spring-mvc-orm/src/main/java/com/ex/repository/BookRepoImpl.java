package com.ex.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ex.beans.Book;

@Repository
@Transactional
public class BookRepoImpl implements BookRepository {
	@Autowired
	SessionFactory sf;
	public List<Book> getAll() {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().createCriteria(Book.class).list();
	}

	
	public Book getById(int id) {
		
		return null;
	}

	
	public Book getAuthor(Book b) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Book add(Book b) {
		// TODO Auto-generated method stub
		return null;
	}

}
