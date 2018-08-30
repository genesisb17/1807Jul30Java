package com.ex.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ex.models.User;
import com.ex.util.ConnectionUtil;

public class UserRepository 
{
	public User findById(int id)
	{
		Session session = ConnectionUtil.getSession();
		User i = session.get(User.class, id);
		session.close();
		return i;
	}
	
	public List<User> findAll()
	{
		return null;
		
	}
	
	public User save(User u)
	{
		Session session = ConnectionUtil.getSession();
		
		try
		{
			Transaction tx = session.beginTransaction();
			int id = (int) session.save(u);
			u.setId(id);
			
			tx.commit();
		}
		finally
		{
			
		}
		return u;		
	}
	
	public User update(User u)
	{
		return u;
		
	}
	
	public User delete(User u)
	{
		return u;
		
	}
}
