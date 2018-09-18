package com.ex.data;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ex.models.User;
import com.ex.util.ConnectionUtil;

public class UserRepository {

	static ConnectionUtil util = ConnectionUtil.getInstance();

	public User findById(int id) {
		User u = null;
		Session session = util.getSession();
		try{
			u = (User) session.get(User.class, id);
		}
		finally {
			session.close();
		}
		return u;
	}

	public List<User> findAll() {
		List<User> users = null;
		Session session = util.getSession();
		try {
			Criteria criteria = session.createCriteria(User.class);
			users = criteria.list();
		}
		finally {
			session.close();
		}
		return users;
	}

	public User save(User u) {
		Session session = util.getSession();
		try{
			Transaction tx = session.beginTransaction();
			int id = (int) session.save(u);
			u.setId(id);
			tx.commit();
		}
		finally {
			session.close();
		}
		return u;

	}

	public void update(User u) {
		Session session = util.getSession();
		try {
			Transaction tx = session.beginTransaction();
			session.update(u);
			tx.commit();
		}
		finally {
			session.close();
		}
	}

	public User findByUsername(String name) {
		User u = null;
		Session session = util.getSession();
		org.hibernate.Query query = session.createQuery("from User where lower(username) = :uname");
		query.setParameter("uname", name.toLowerCase());
		u = (User) query.uniqueResult();

		return u;
	}

}
