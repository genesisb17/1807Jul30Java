package com.ex.data;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ex.models.User;
import com.ex.util.ConnectionUtil;

public class UserRepository {

	static ConnectionUtil util = ConnectionUtil.getInstance();

	/*public User findById(int id) {
		User u = null;
		try (Session session = util.getSession()) {
			u = session.get(User.class, id);
		}
		return u;
	}

	public List<User> findAll() {
		List<User> users = null;
		try (Session session = util.getSession()) {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<User> criteria = builder.createQuery(User.class);
			users = session.createQuery(criteria).getResultList();
		}
		return users;
	}

	public User save(User u) {
		try (Session s = util.getSession()) {
			Transaction tx = s.beginTransaction();
			int id = (int) s.save(u);
			u.setId(id);
			tx.commit();
		}
		return u;

	}

	public void update(User u) {
		try (Session s = util.getSession()) {
			Transaction tx = s.beginTransaction();
			s.update(u);
			tx.commit();
		}
	}

	
	
	 * Back in simpler times aka hibernate 4
	 * 
	 * Criteria c = session.createCriteria(User.class) c.addRetriction c.list
	 
	public User findByUsernameCriteria(String name) {
		User u = null;
		Session s = util.getSession();
			Transaction tx = s.beginTransaction();
			CriteriaBuilder builder = s.getCriteriaBuilder();
			CriteriaQuery<User> query = builder.createQuery(User.class);
			Root<User> root = query.from(User.class);
			query.select(root).where(builder.equal(root.get("username"), name));
			u = s.createQuery(query).getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
		}
		return u;
	}
*/
	
	public User findByUsername(String name) {
		User u = null;
		Session session = util.getSession();
		org.hibernate.Query query = session.createQuery("from User where lower(username) = :uname");
		query.setParameter("uname", name.toLowerCase());
		u = (User) query.uniqueResult();

		return u;
	}

}
