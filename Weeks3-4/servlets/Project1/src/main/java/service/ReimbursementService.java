package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dao.DAO;
import dao.ReimbursementDAO;
import pojos.Employee;
import pojos.Reimbursement;
import util.ConnectionFactory;

public class ReimbursementService {

static DAO<Reimbursement, Integer> eDAO = new ReimbursementDAO();
	
	public List<Reimbursement> getAll() {
		return eDAO.getAll();
	}

	public Reimbursement findOne(Reimbursement obj) {
		return eDAO.findOne(obj);
	}
	
	public Reimbursement findOne(int obj) {
		return eDAO.findOne(obj);
	}

	public Reimbursement save(Reimbursement obj) {
		return eDAO.save(obj);
	}

	public Reimbursement update(Reimbursement obj) {
		return eDAO.update(obj);
	}
	
	public Reimbursement resolveReimbursement(int r, int e, int s) {
		return eDAO.resolveReimbursement(r, e,s);
	}
	

	public void delete(Reimbursement obj) {
		// TODO Auto-generated method stub
		System.out.println("You need to write this method");
	}
}
