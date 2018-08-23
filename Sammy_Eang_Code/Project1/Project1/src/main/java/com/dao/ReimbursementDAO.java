package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.connectionfactory.ConnectionFactory;
import com.pojo.ReimbursementPOJO;

public class ReimbursementDAO {
	
	//Finds all reimbursements and stores in list. Passes back. Regular Statement.
	public List<ReimbursementPOJO> findAll() {
			
			List<ReimbursementPOJO> reimbursements = new ArrayList<ReimbursementPOJO>();
			
			try(Connection conn = ConnectionFactory.getInstance().getConnection()){
				
				String query = "select * from reimbursements order by reimb_id";
				Statement statement = conn.createStatement();
				ResultSet rs = statement.executeQuery(query);
				
				while(rs.next()) {
					ReimbursementPOJO temp = new ReimbursementPOJO();
					temp.setReimb_id(rs.getInt(1));
					temp.setReimb_amount(rs.getDouble(2));
					temp.setDate_submitted(rs.getTimestamp(3));
					temp.setDate_resolved(rs.getTimestamp(4));
					temp.setReimb_description(rs.getString(5));
					temp.setAuthor_id(rs.getInt(7));
					temp.setResolver_id(rs.getInt(8));
					temp.setReimb_status_id(rs.getInt(9));
					temp.setReimb_type_id(rs.getInt(10));
					reimbursements.add(temp);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return reimbursements;
		}
	
	//Finds reimbursement by reimbursement id and returns it. Prepared Statement.
	public ReimbursementPOJO findOnebyID(Integer id){
		ReimbursementPOJO temp = null;
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
	
			String sql = "select * from reimbursements where reimb_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery( );
			
		while(rs.next()) {
				temp = new ReimbursementPOJO();
				temp.setReimb_id(rs.getInt(1));
				temp.setReimb_amount(rs.getDouble(2));
				temp.setDate_submitted(rs.getTimestamp(3));
				temp.setDate_resolved(rs.getTimestamp(4));
				temp.setReimb_description(rs.getString(5));
				temp.setAuthor_id(rs.getInt(7));
				temp.setResolver_id(rs.getInt(8));
				temp.setReimb_status_id(rs.getInt(9));
				temp.setReimb_type_id(rs.getInt(10));
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}
	
   /*  Finds all reimbursements by some parameter and returns a list of whatever comes back
	*  For logic, pass in by emp_id (for whoever is calling so they can see their own reimbursements) 
	*  or pass by pending for managers so they can see what to approve/deny. Prepared Statement.
	*/
	public List<ReimbursementPOJO> findBySomeParam(String search, Integer param) {
		
		List<ReimbursementPOJO> reimbursements = new ArrayList<ReimbursementPOJO>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			String sql = "select * from reimbursements where ? = ? order reimb_submitted desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, search);
			ps.setInt(2, param);
			ResultSet rs = ps.executeQuery( );
			
			while(rs.next()) {
				ReimbursementPOJO temp = new ReimbursementPOJO();
				temp.setReimb_id(rs.getInt(1));
				temp.setReimb_amount(rs.getDouble(2));
				temp.setDate_submitted(rs.getTimestamp(3));
				temp.setDate_resolved(rs.getTimestamp(4));
				temp.setReimb_description(rs.getString(5));
				temp.setAuthor_id(rs.getInt(7));
				temp.setResolver_id(rs.getInt(8));
				temp.setReimb_status_id(rs.getInt(9));
				temp.setReimb_type_id(rs.getInt(10));
				reimbursements.add(temp);
			}
			
		} catch (SQLException e) {
}
		return reimbursements;
	}
	
	//Reimbursement is submitted by employee. Automatically saves date, takes in 5 other params to pass into object. Prepared statement.
	public ReimbursementPOJO submitNew(ReimbursementPOJO obj) {
	
	ReimbursementPOJO reimbursement = new ReimbursementPOJO();
	
	try(Connection conn = ConnectionFactory.getInstance().getConnection()){
		
		conn.setAutoCommit(false);
		String query = "insert into reimbursements(reimb_amount, reimb_submitted, reimb_description, reimb_author, reimb_status_id, reimb_type_id) values(?, sysdate, ?, ?, ?, ?)";
		
		String[] keys = new String[1];
		keys[0] = "reimb_id";
		
		PreparedStatement ps = conn.prepareStatement(query, keys);
		ps.setDouble(1, obj.getReimb_amount());
		ps.setString(3, obj.getReimb_description());
		ps.setInt(4, obj.getAuthor_id());
		ps.setInt(5, obj.getReimb_status_id());
		ps.setInt(6, obj.getReimb_type_id());

		
		int rows = ps.executeUpdate();
		
		if(rows != 0) {
			ResultSet pk = ps.getGeneratedKeys();
			while(pk.next()) {
				reimbursement.setReimb_id(pk.getInt(1));
			}
			
			conn.commit();
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return reimbursement;
}
	
	//Updates reimbursement that is handled by manager. Handles columns 4, 8, 9. Callable statement.
	//Create statement in sql that updates (reimb_resolved, reimb_resolver, reimb_status_id)
//	public void updateReimb(Integer eid, Integer rsid) {
//		
//		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
//			
//			   conn.setAutoCommit(false);
//				String query = "{call updateReimb(?, ?)}";
//				
//				CallableStatement cs = conn.prepareCall(query);
//				cs.setInt(1, eid);
//				cs.setInt(2, rsid);
//				
//				int rows = cs.executeUpdate();
//				
//				if(rows != 0) {			
//					conn.commit();
//				}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//	}

}
