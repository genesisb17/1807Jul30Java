package com.ex.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ex.pojos.Bear;
import com.ex.util.ConnectionUtil;

public class BearDao {
	/*
	 * CRUD DAO using hibernate methods
	 */

	/*
	 * SAVE
	 * - adds instance to db
	 * - persists transient instance, returns whatever Serializable
	 *   identifier is used for the instance 
	 * - saving a persisted instance does nothing 
	 * - saving a detached instance creates a new persistant instance
	 *   and assigns it a new identifier, which results in a duplicate
	 *   record. do not do!
	 */
	public Bear addBear(Bear b) {
		Session session = ConnectionUtil.getSession();
		try {
			Transaction tx = session.beginTransaction();	// start of tx with db
			
			int id = (int) session.save(b);	// insert
			b.setBearId(id);
			
			tx.commit();	// assuming we have successfully added bear, commit
		} finally {
			session.close();
		}
		return b;
	}
	
	/*
	 * PERSIST
	 * - intended to add a new entity to the persistence context, ie
	 *   transitioning an instance from the transient to persistent state
	 * - usually called to add a record to the db(persist an instance)
	 * - after persist(obj) is called, obj is in the persistence context
	 *   but not added to the db until the tx is commited, flushed, or the 
	 *   session is closed. 
	 * - has void return type. the object passed is what gets changed.
	 * - the ID is not guaranteed to be not null after this method 
	 * - if an instance is detached, calling this method will throw an 
	 *   exception
	 * - persist may be called on an already persistent instance, nothing
	 *   will happen 
	 */
	public Bear persistBear(Bear b) {
		return b;
	}
	
	/*
	 * GET
	 * - will always hit the database and return the real object
	 * - if no row found, will return null
	 */
	public Bear getById(int id) {
		Session session = ConnectionUtil.getSession();
		Bear b = session.get(Bear.class, id);
		session.close();
		return b;
	}
	
	/*
	 * LOAD
	 * - will always return a proxy without hitting the database
	 * - if no row found, it throws an ObjectNotFoundException
	 */
	public Bear loadById(int id) {
		/*
		 * - we must actually access the data in our entity or we are just loading a proxy
		 * - LazyInitializationException will be thrown if we try to access our proxy with the session closed
		 */
		Session session = ConnectionUtil.getSession();
		Bear b = session.load(Bear.class, id);
		System.out.println("Just loaded Bear");
		System.out.println(b);
		session.close();
		return b;
	}
	
	
	/*
	 * UPDATE
	 * - transitions the passed object from detached to persistent state
	 */
	
	/*
	 * MERGE
	 * - intention is to update a persistent entity instance with new field values from a detached entity instance
	 * - finds an entity instance by id taken from the passed object (either an existing entity instance from the
	 *   persistence context is retrieved, or a new instance is loaded from the database)
	 * - copies fields from the passed object to this instance
	 * - returns the newly updated instance
	 */
	
	
	/*
	 * Criteria
	 * API for querying data programatically (meaning, with methods)
	 * We don't need to speak any language except Java
	 */
	public List<Bear> findAllCriteria() {
		List<Bear> bears = null;	// in case something goes wrong
		try(Session session = ConnectionUtil.getSession()) {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Bear> criteria = builder.createQuery(Bear.class);	// still using Criteria, not Query
			Root<Bear> root = criteria.from(Bear.class);
			bears = session.createQuery(criteria).getResultList();
		} return bears;
	}
	
	/*
	 * Query
	 */
	public List<Bear> findByColor(String color) {
		List<Bear> bears = null;
		try(Session session = ConnectionUtil.getSession()) {
			Query<Bear> q = session.createQuery("from Bear where furColor like :param", Bear.class);
			q.setParameter("param", color.toLowerCase());
		} return bears;
	}

}
