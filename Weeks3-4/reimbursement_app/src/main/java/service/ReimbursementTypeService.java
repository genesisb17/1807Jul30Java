package service;

import java.util.List;

import dao.DAO;
import dao.ReimbursementTypeDAO;
import pojos.ReimbursementType;

public class ReimbursementTypeService {

	static DAO<ReimbursementType, Integer> eDAO = new ReimbursementTypeDAO();
	
	public List<ReimbursementType> getAll() {
		return eDAO.getAll();
	}

	public ReimbursementType findOne(ReimbursementType obj) {
		return eDAO.findOne(obj);
	}

	public ReimbursementType save(ReimbursementType obj) {
		return eDAO.save(obj);
	}

	public ReimbursementType update(ReimbursementType obj) {
		return eDAO.update(obj);
	}

	public void delete(ReimbursementType obj) {
		// TODO Auto-generated method stub
		System.out.println("You need to write this method");
	}
}
