package com.ex.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ex.pojos.Reimbursement;
import com.ex.util.ConnectionFactory;

import oracle.jdbc.internal.OracleTypes;

public class ReimbDao implements Dao<Reimbursement, Integer> {

	@Override
	public List<Reimbursement> findAll() {
//		List<Reimbursement> reimbs = new ArrayList<Reimbursement>();
//		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
//			String sql = "{call get_all_reimbursements(?)}";	// must call inside curly braces
//			
//			CallableStatement cs = conn.prepareCall(sql);
//			cs.registerOutParameter(1, OracleTypes.CURSOR);
//			cs.execute();
//			
//			ResultSet rs = (ResultSet) cs.getObject(1);
//			int i=0;
//			
//			while(rs.next()) {
//				Reimbursement temp = new Reimbursement();
//				temp.setReimbId(rs.getInt("REIMB_ID"));
//				temp.setAmount(rs.getDouble("REIMB_AMOUNT"));
//				temp.setSubmitted(rs.getTimestamp("REIMB_SUBMITTED"));
//				temp.setResolved(rs.getTimestamp("REIMB_RESOLVED"));
//				temp.setDescription(rs.getString("REIMB_DESCRIPTION"));
//				temp.setReceipt(rs.getBlob("REIMB_RECEIPT"));
//				temp.setAuthor(rs.getInt("REIMB_AUTHOR"));
//				temp.setResolver(rs.getInt("REIMB_RESOLVER"));
//				temp.setStatusId(rs.getInt("REIMB_STATUS_ID"));
//				temp.setTypeId(rs.getInt("REIMB_TYPE_ID"));
//				reimbs.add(temp);
//				i++;
//			}
//			System.out.println("number of reimbursements = " + i);
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return reimbs;
		List<Reimbursement> reimbs = new ArrayList<Reimbursement>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String query = "select * from ERS_REIMBURSEMENT";

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {// book_id, isbn, title, price, genre
				Reimbursement temp = new Reimbursement();
				temp.setReimbId(rs.getInt("REIMB_ID"));
				temp.setAmount(rs.getDouble("REIMB_AMOUNT"));
				temp.setSubmitted(rs.getTimestamp("REIMB_SUBMITTED"));
				temp.setResolved(rs.getTimestamp("REIMB_RESOLVED"));
				temp.setDescription(rs.getString("REIMB_DESCRIPTION"));
				temp.setReceipt(rs.getBlob("REIMB_RECEIPT"));
				temp.setAuthor(rs.getInt("REIMB_AUTHOR"));
				temp.setResolver(rs.getInt("REIMB_RESOLVER"));
				temp.setStatusId(rs.getInt("REIMB_STATUS_ID"));
				temp.setTypeId(rs.getInt("REIMB_TYPE_ID"));
				reimbs.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbs;
	}

	@Override
	public Reimbursement findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement save(Reimbursement obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String query = "INSERT INTO ers_reimbursement(REIMB_AMOUNT, REIMB_SUBMITTED, "
					+ "REIMB_DESCRIPTION, REIMB_RECEIPT, REIMB_AUTHOR, "
					+ "REIMB_STATUS_ID, REIMB_TYPE_ID) VALUES(?,?,?,?,?,?,?)";
			
			String[] keys = new String[1];
			keys[0] = "REIMB_ID";
			
			PreparedStatement ps = conn.prepareStatement(query, keys);
			
			ps.setDouble(1, obj.getAmount());
			ps.setTimestamp(2, obj.getSubmitted());
			ps.setString(3, obj.getDescription());
			ps.setBlob(4, obj.getReceipt());
			ps.setInt(5, obj.getAuthor());
			ps.setInt(6, obj.getStatusId());
			ps.setInt(7, obj.getTypeId());
			
			int rows = ps.executeUpdate();
			
			if(rows != 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					obj.setReimbId(pk.getInt(1));
				}
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public Reimbursement update(Reimbursement obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUnique(Reimbursement obj) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
