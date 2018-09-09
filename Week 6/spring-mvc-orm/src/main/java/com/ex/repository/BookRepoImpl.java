package com.ex.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ex.beans.Book;

@Transactional
@Repository
public class BookRepoImpl {
	@Autowired
	SessionFactory sf;

	public List<Book> getAll() {
		return sf.getCurrentSession().createCriteria(Book.class).list();
	}

	public Book getById(int id) {
		return (Book) sf.getCurrentSession().get(Book.class, id);
	}

	public Book add(Book a) {
		int id = (Integer) sf.getCurrentSession().save(a);
		a.setId(id);
		return a;
	}

	public void update(Book a) {
		// TODO Auto-generated method stub
		
	}
}
