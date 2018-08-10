package com.p1.service;

import java.util.List;

import com.p1.DAO.DAO;
import com.p1.DAO.accountDAO;
import com.p1.pojo.account;

public class accountService 
{
	static DAO<account, Integer> aDao = new accountDAO();
	
	public List<account> getAll()
	{
		return aDao.getAll();
	}
}
