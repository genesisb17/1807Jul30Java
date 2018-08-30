package com.rev.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rev.pojos.Bear;
import com.rev.util.ConnectionUtil;

public class BearDao {
	/*
	 * CRUD DAO using hibernate methods.
	 */

	public Bear addBear(Bear b) {
		Session session = ConnectionUtil.getSession();
		try {

			Transaction tx = session.beginTransaction(); // Start of tx with DB

			int id = (int) session.save(b);
			b.setBearID(id);

			tx.commit(); // Assuming we have successfully added bear, commit tx
		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			session.close();
		}

		return b;
	}

	public Bear getById(int id) {
		Session session = ConnectionUtil.getSession();
		Bear b = null;
		try {
			b = session.get(Bear.class, id);
		} finally {
			session.close();
		}
		return b;
	}

	public Bear loadById(int id) {
		/*
		 * We must actually access the data in our entity or we are just loading a
		 * proxy. LazyInitializationException will be thrown if we try to access our
		 * proxy with the session closed
		 */
		Session session = ConnectionUtil.getSession();
		Bear b = null;
		try {
			b = session.load(Bear.class, id);
		} finally {
			session.close();
		}
		return b;
	}

	public Bear mergeBear(Bear b) {
		Session session = ConnectionUtil.getSession();
		try {
		} finally {
			session.close();
		}
		return null;
	}

	/*
	 * Criteria API for querying data programatically We don't need to speak any
	 * language but java
	 */

	public List<Bear> findAllCriteria() {
		Session session = null;
		List<Bear> bears = new ArrayList<Bear>();
		try {
			session = ConnectionUtil.getSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Bear> criteria = builder.createQuery(Bear.class);
			Root<Bear> root = criteria.from(Bear.class);
			bears = session.createQuery(criteria).getResultList();
		} finally {
			session.close();
		}
		return bears;
	}

	/*
	 * Query
	 * Query database using HQL
	 */
	public List<Bear> findAllQuery(String color){
		List<Bear> bears = null;
		try(Session session = ConnectionUtil.getSession()){
			Query<Bear> q = session.createQuery("from Bear where lower(furColor) like :param", Bear.class);	//Like operator allows for matching using regex
			q.setParameter("param", color.toLowerCase());
			bears=  q.getResultList();
		}
		return bears;
	}
	
}
