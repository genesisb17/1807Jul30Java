package com.rev.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rev.models.User;
import com.rev.util.ConnectionUtil;

public class UserRepository {

	public User findById(int id) {	// TODO
		User user = null;
		try (Session session = ConnectionUtil.getSession()){
			user = session.get(User.class, id);
		}
		return user;
	}
	
	public List<User> findAll() { 	//TODO
		List<User> users = null;
		try (Session session = ConnectionUtil.getSession()) {
			Transaction tx = session.beginTransaction();
			users = new ArrayList<User>();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<User> criteria = builder.createQuery(User.class);
//			Root<User> root = criteria.from(User.class);
			users = session.createQuery(criteria).getResultList();
			tx.commit();
		}
		return users;
	}
	
	public User save(User u) {
		try(Session session = ConnectionUtil.getSession()) {
			Transaction tx = session.beginTransaction();
			int id = (int) session.save(u);
			u.setId(id);
			tx.commit();
			System.out.println("Closing Session");
			session.close();
			return u;
		}
//		return null;
	}
	
	public User update(User u) {
		try (Session session = ConnectionUtil.getSession()) {
			Transaction tx = session.beginTransaction();
			session.update(u);
			tx.commit();
			return u;
		}
	}
	
	public User findByUsername(String username) {
		User user = null;
		try (Session session = ConnectionUtil.getSession()){
			Query query = session.createQuery("from User where lower(username) = :uname");
			query.setParameter("uname", username);
			user = (User) query.getSingleResult();
		}
		return user;
	}
	
	/*
	 * Back in simpler times aka hibernate 4
	 * 
	 * Criteria c = sessio.createCriteria(User.class)
	 * c.addRestriction
	 * c.list
	 */
	public User findByUsernameCriteria(String username) {
		User user = null;
		try (Session session = ConnectionUtil.getSession()) {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<User> query = builder.createQuery(User.class);
			Root<User> root = query.from(User.class);
			query.select(root).where(builder.equal(root.get("username"), username));
			user = session.createQuery(query).getSingleResult();
		}
		return user;
	}
	
}
