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
	
	public Reimbursement resolveReimbursement(Reimbursement r, Employee e, int s) {
		Reimbursement temp = new Reimbursement();
//		System.out.println(r.getReimb_id());
//		System.out.println(e.getEmployee_id());
//		System.out.println(r.getStatus_id());
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "exec resolve_reimbursement(?,?,?)";
			PreparedStatement cs = conn.prepareStatement(sql);
	
			cs.setInt(1, r.getReimb_id());
			cs.setInt(2, e.getEmp_role_id());
			cs.setInt(3, s);
			
			ResultSet rs = cs.executeQuery();
			
			while(rs.next()) {				
				temp.setReimb_id(rs.getInt("Reimb_id"));
				temp.setAmount(rs.getInt("amount"));
				temp.setSubmitted(rs.getTimestamp("submitted"));
				temp.setResolved(rs.getTimestamp("resolved"));
				temp.setDescription(rs.getString("description"));
//				temp.setReceipt(rs.getBlob("receipt")); 
				temp.setAuthor(rs.getInt("author"));
				temp.setResolver(rs.getInt("resolver_id"));
				temp.setStatus_id(rs.getInt("status_id"));
				temp.setType_id(rs.getInt("type_id"));

				//System.out.println(temp);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.err.println("SQL State: " + ex.getSQLState());
			System.err.println("Error Code: " + ex.getErrorCode());
		}
		
		return temp;
	}
	

	public void delete(Reimbursement obj) {
		// TODO Auto-generated method stub
		System.out.println("You need to write this method");
	}
}
