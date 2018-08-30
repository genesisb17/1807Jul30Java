package com.iantimothyjohnson.notes.week5.data;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.iantimothyjohnson.notes.week5.models.User;
import com.iantimothyjohnson.notes.week5.util.SessionUtil;

public class UserRepository {
	public User findById(int id) {
		try (Session s = SessionUtil.getSession()) {
			return s.get(User.class, id);
		}
	}

	public User findByUsername(String username) {
		try (Session s = SessionUtil.getSession()) {
			Query<User> q = s.createQuery("from User where lower(username) = :username", User.class);
			q.setParameter("username", username.toLowerCase());
			return q.uniqueResult();
		}
	}
	
	public User findByUsernameCriteria(String username) {
		try (Session s = SessionUtil.getSession()) {
			CriteriaBuilder builder = s.getCriteriaBuilder();
			CriteriaQuery<User> query = builder.createQuery(User.class);
			Root<User> root = query.from(User.class);
			query.select(root).where(builder.equal(root.get("username"), username));
			return s.createQuery(query).uniqueResult();
		}
	}

	public List<User> findAll() {
		try (Session s = SessionUtil.getSession()) {
			Query<User> q = s.createQuery("from User", User.class);
			return q.getResultList();
		}
	}

	public void save(User u) {
		try (Session s = SessionUtil.getSession()) {
			Transaction tx = s.beginTransaction();
			s.save(u);
			tx.commit();
		}
	}

	public void update(User u) {
		try (Session s = SessionUtil.getSession()) {
			Transaction tx = s.beginTransaction();
			s.update(u);
			tx.commit();
		}
	}
}
