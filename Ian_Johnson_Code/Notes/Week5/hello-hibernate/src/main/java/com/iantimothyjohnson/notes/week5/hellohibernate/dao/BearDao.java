package com.iantimothyjohnson.notes.week5.hellohibernate.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.iantimothyjohnson.notes.week5.hellohibernate.pojos.Bear;
import com.iantimothyjohnson.notes.week5.hellohibernate.util.ConnectionUtil;

public class BearDao {
	// This is a CRUD DAO using Hibernate methods.

	public Bear addBear(Bear b) {
		Session s = ConnectionUtil.getSession();

		try {
			Transaction tx = s.beginTransaction(); // Start of TX with DB.
			int id = (int) s.save(b);
			System.out.println(b.getBearId());
			// We don't actually need to set this; it will be set after we commit.
			b.setBearId(id);
			tx.commit(); // Assuming we have successfully added bear, commit TX.
		} finally {
			s.close();
		}
		return b;
	}

	// get
	public Bear getById(int id) {
		Session s = ConnectionUtil.getSession();
		try {
			Bear b = s.get(Bear.class, id);
			return b;
		} finally {
			s.close();
		}
	}

	// load
	public Bear loadById(int id) {
		Session s = ConnectionUtil.getSession();
		try {
			Bear b = s.load(Bear.class, id);
			System.out.println("Just loaded bear.");
			System.out.println(b);
			return b;
		} finally {
			s.close();
		}
	}

	// update
	// merge

	public List<Bear> findAllCriteria() {
		try (Session s = ConnectionUtil.getSession()) {
			CriteriaBuilder builder = s.getCriteriaBuilder();
			CriteriaQuery<Bear> criteria = builder.createQuery(Bear.class);
			// TODO: what does this root do?
			criteria.from(Bear.class);
			return s.createQuery(criteria).getResultList();
		}
	}
	
	public List<Bear> findAllQuery() {
		try (Session s = ConnectionUtil.getSession()) {
			// Let's use some HQL:
			Query<Bear> q = s.createQuery("from Bear", Bear.class);
			return q.getResultList();
		}
	}
	
	public List<Bear> findByColor(String color) {
		try (Session s = ConnectionUtil.getSession()) {
			Query<Bear> q = s.createQuery("from Bear where lower(furColor) = :param", Bear.class);
			q.setParameter("param", color.toLowerCase());
			return q.getResultList();
		}
	}
}
