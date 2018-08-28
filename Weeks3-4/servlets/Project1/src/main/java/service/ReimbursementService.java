package service;

import java.util.List;

import dao.DAO;
import dao.ReimbursementDAO;
import pojos.Reimbursement;

public class ReimbursementService {

static DAO<Reimbursement, Integer> eDAO = new ReimbursementDAO();
	
	public List<Reimbursement> getAll() {
		return eDAO.getAll();
	}

	public Reimbursement findOne(Reimbursement obj) {
		return eDAO.findOne(obj);
	}

	public Reimbursement save(Reimbursement obj) {
		return eDAO.save(obj);
	}

	public Reimbursement update(Reimbursement obj) {
		return eDAO.update(obj);
	}

	public void delete(Reimbursement obj) {
		// TODO Auto-generated method stub
		System.out.println("You need to write this method");
	}
}
