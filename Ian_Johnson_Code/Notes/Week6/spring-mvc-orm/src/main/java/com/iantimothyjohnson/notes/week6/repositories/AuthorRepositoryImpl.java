package com.iantimothyjohnson.notes.week6.repositories;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iantimothyjohnson.notes.week6.beans.Author;

@Transactional
@Repository
public class AuthorRepositoryImpl implements AuthorRepository {
	// We are going to autowire our SessionFactory bean that we defined in
	// beans.xml.
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Author> getAll() {
		return sessionFactory.getCurrentSession().createCriteria(Author.class).list();
	}

	@Override
	public Author getById(int id) {
		return (Author) sessionFactory.getCurrentSession().get(Author.class, id);
	}

	@Override
	public Author add(Author a) {
		int id = (Integer) sessionFactory.getCurrentSession().save(a);
		a.setId(id);
		return a;
	}

	@Override
	public void update(Author a) {
		// TODO Auto-generated method stub

	}
}
