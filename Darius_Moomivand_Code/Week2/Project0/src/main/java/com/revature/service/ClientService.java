package com.revature.service;

import java.util.List;

import com.revature.dao.ClientDAO;
import com.revature.dao.Dao;
import com.revature.pojo.Client;

public class ClientService {
	
	static Dao<Client, Integer> cDao = new ClientDAO();
	
	public void enterClient(Client newClient) {
		cDao.save(newClient);
		
	}

	
	public List<Client> getAll(){
		return cDao.findAll();
	}
}
