package com.iantimothyjohnson.notes.week5.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.iantimothyjohnson.notes.week5.models.Account;
import com.iantimothyjohnson.notes.week5.util.SessionUtil;

public class AccountRepository {
	public Account findById(int id) {
		Session s = SessionUtil.getSession();
		try {
			return s.get(Account.class, id);
		} finally {
			s.close();
		}
	}

	public List<Account> findAll() {
		Session s = SessionUtil.getSession();
		try {
			Query<Account> q = s.createQuery("from Account", Account.class);
			return q.getResultList();
		} finally {
			s.close();
		}
	}

	public void save(Account a) {
		Session s = SessionUtil.getSession();
		try {
			Transaction tx = s.beginTransaction();
			s.save(a);
			tx.commit();
		} finally {
			s.close();
		}
	}

	public void update(Account a) {
		Session s = SessionUtil.getSession();
		try {
			Transaction tx = s.beginTransaction();
			s.update(a);
			tx.commit();
		} finally {
			s.close();
		}
	}
}
