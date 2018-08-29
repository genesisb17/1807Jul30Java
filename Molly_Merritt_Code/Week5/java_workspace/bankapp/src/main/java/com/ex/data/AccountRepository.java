package com.ex.data;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ex.models.Account;
import com.ex.util.ConnectionUtil;

public class AccountRepository {
	
	public Account findById(int id) {
		Account a = null;
		try(Session session = ConnectionUtil.getSession()) {
			a = session.get(Account.class, id);
		} return a;
	}
	
	public List<Account> findAll() {
		List<Account> accounts = null;
		try(Session session = ConnectionUtil.getSession()) {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Account> criteria = builder.createQuery(Account.class);
			accounts = session.createQuery(criteria).getResultList();
		} return accounts;
	}
	
	public Account save(Account a) {
		try(Session session = ConnectionUtil.getSession()) {
			Transaction tx = session.beginTransaction();
			int id = (int) session.save(a);	// insert
			a.setId(id);
			tx.commit();
		}
		return a;
	}
	
	public Account update(Account a) {
		try(Session session = ConnectionUtil.getSession()) {
			Transaction tx = session.beginTransaction();
			session.update(a);
			tx.commit();
		} return a;
	}

}
