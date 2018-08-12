package service;

import java.util.List;

import dao.ClientDAO;
import dao.DAO;
import pojo.Client;

public class ClientService {

	static DAO<Client, Integer> bDAO = new ClientDAO();
	static ClientDAO c = new ClientDAO();
	
	public List<Client> getAll() {
		return bDAO.getAll();
	}
	
	public Client save(Client b) {
		return bDAO.save(b);
	}
//	-	-	-	-	-	-	-	-	-	-	-	-	-	-TODO
	public Client findOne(String username) {
		return c.findOne(username);
	}
	
	public boolean isUsernameUnique(String usr) {
		List<Client> demo = getAll();
		
		for(Client c : demo) {
			if(c.getUsername().equals(usr)) {
				return false;
			}
		}
		return true;	
	}
}
