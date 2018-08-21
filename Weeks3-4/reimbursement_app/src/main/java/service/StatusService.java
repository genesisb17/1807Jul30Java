package service;

import java.util.List;

import dao.DAO;
import dao.StatusDAO;
import pojos.Status;

public class StatusService {

static DAO<Status, Integer> eDAO = new StatusDAO();
	
	public List<Status> getAll() {
		return eDAO.getAll();
	}

	public Status findOne(Status obj) {
		return eDAO.findOne(obj);
	}

	public Status save(Status obj) {
		return eDAO.save(obj);
	}

	public Status update(Status obj) {
		return eDAO.update(obj);
	}

	public void delete(Status obj) {
		// TODO Auto-generated method stub
		System.out.println("You need to write this method");
	}
}
