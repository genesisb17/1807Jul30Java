package com.p1.service;

import java.util.List;

import com.p1.DAO.DAO;
import com.p1.DAO.accountDAO;
import com.p1.pojo.account;
import com.p1.pojo.customer;

public class accountService 
{
	static DAO<account, Integer> aDao = new accountDAO();
	
	public List<account> getAll()
	{
		return aDao.getAll();
	}
	
	public account save(account obj)
	{
		return aDao.save(obj);
	}
	
	public account update(account obj)
	{
		return aDao.update(obj);
	}
	
	public void delete(account obj)
	{
		aDao.delete(obj);
	}
}
