package com.iantimothyjohnson.notes.week6.repositories;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iantimothyjohnson.notes.week6.beans.Genre;

@Repository
@Transactional
public class GenreRepositoryImpl implements GenreRepository {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Genre> getAll() {
		return sessionFactory.getCurrentSession().createCriteria(Genre.class).list();
	}

	@Override
	public Genre getById(int id) {
		return (Genre) sessionFactory.getCurrentSession().get(Genre.class, id);
	}

	@Override
	public Genre add(Genre g) {
		int id = (Integer) sessionFactory.getCurrentSession().save(g);
		g.setId(id);
		return g;
	}
}
