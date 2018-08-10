package service;

import java.util.List;

import dao.ClientDAO;
import dao.DAO;
import pojo.Client;

public class ClientService {

	static DAO<Client, Integer> bDAO = new ClientDAO();
	
	public List<Client> getAll() {
		return bDAO.getAll();
	}
	
	public Client save(Client b) {
		return bDAO.save(b);
	}
//	-	-	-	-	-	-	-	-	-	-	-	-	-	- todo
	public Client findOne(String username) {
		// TODO Auto-generated method stub
		return null;
	}
}
