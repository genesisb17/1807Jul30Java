package com.iantimothyjohnson.notes.week5.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.iantimothyjohnson.notes.week5.models.Account;
import com.iantimothyjohnson.notes.week5.util.SessionUtil;

public class AccountRepository {
	public Account findById(int id) {
		try (Session s = SessionUtil.getSession()) {
			return s.get(Account.class, id);
		}
	}

	public List<Account> findAll() {
		try (Session s = SessionUtil.getSession()) {
			Query<Account> q = s.createQuery("from Account", Account.class);
			return q.getResultList();
		}
	}

	public void save(Account a) {
		try (Session s = SessionUtil.getSession()) {
			Transaction tx = s.beginTransaction();
			s.save(a);
			tx.commit();
		}
	}

	public void update(Account a) {
		try (Session s = SessionUtil.getSession()) {
			Transaction tx = s.beginTransaction();
			s.update(a);
			tx.commit();
		}
	}
}
