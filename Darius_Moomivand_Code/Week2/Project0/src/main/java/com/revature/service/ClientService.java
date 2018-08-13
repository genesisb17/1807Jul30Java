package com.revature.service;

import java.util.List;

import com.revature.dao.ClientDAO;
import com.revature.dao.Dao;
import com.revature.pojo.Client;

public class ClientService {
	
	static Dao<Client, Integer> cDao = new ClientDAO();
	
	public int enterClient(Client newClient) {
		Client client = cDao.save(newClient);
		int newId = client.getClientId();
		return newId;
	}
	
	public void getClientId(int id) {
		
	}

	
	public List<Client> getAll(){
		return cDao.findAll();
	}
}
