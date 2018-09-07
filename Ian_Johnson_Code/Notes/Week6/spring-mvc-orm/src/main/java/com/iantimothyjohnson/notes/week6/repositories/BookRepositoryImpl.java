package com.iantimothyjohnson.notes.week6.repositories;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iantimothyjohnson.notes.week6.beans.Book;

@Transactional
@Repository
public class BookRepositoryImpl implements BookRepository {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getAll() {
		return sessionFactory.getCurrentSession().createCriteria(Book.class).list();
	}

	@Override
	public Book getById(int id) {
		return (Book) sessionFactory.getCurrentSession().get(Book.class, id);
	}

	@Override
	public Book add(Book b) {
		int id = (Integer) sessionFactory.getCurrentSession().save(b);
		b.setId(id);
		return b;
	}

	@Override
	public void update(Book b) {
		sessionFactory.getCurrentSession().update(b);
	}
}
