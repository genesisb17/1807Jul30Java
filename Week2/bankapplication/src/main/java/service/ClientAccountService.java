package service;

import java.util.List;

import dao.ClientAccountDAO;
import dao.DAO;
import pojo.ClientAccount;

public class ClientAccountService {

	static DAO<ClientAccount, Integer> bDAO = new ClientAccountDAO();
	
	public List<ClientAccount> getAll() {
		return bDAO.getAll();
	}
	
	public ClientAccount save(ClientAccount b) {
		return bDAO.save(b);
	}
}
