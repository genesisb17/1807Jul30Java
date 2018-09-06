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
		List<Reimbursement> reimbs = new ArrayList<Reimbursement>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
//			String query = "select * from ERS_REIMBURSEMENT";
			String query =
					"select " + 
					"  reimb_id, reimb_amount, reimb_submitted, reimb_resolved, reimb_description, " + 
					"  (select ers_username from ers_users u where u.ers_users_id = r.reimb_author) as author, " + 
					"  (select ers_username from ers_users u where u.ers_users_id = r.reimb_resolver) as resolver, " + 
					"  (select reimb_status from ers_reimbursement_status s where s.reimb_status_id = r.reimb_status_id) as status_id, " + 
					"  (select reimb_type from ers_reimbursement_type ty where ty.reimb_type_id = r.reimb_type_id) as type_id " + 
					"from ERS_REIMBURSEMENT r";

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {// book_id, isbn, title, price, genre
				Reimbursement temp = new Reimbursement();
				temp.setReimbId(rs.getInt("REIMB_ID"));
				temp.setAmount(rs.getDouble("REIMB_AMOUNT"));
				temp.setSubmitted(rs.getTimestamp("REIMB_SUBMITTED"));
				temp.setResolved(rs.getTimestamp("REIMB_RESOLVED"));
				temp.setDescription(rs.getString("REIMB_DESCRIPTION"));
//				temp.setReceipt(rs.getBlob("REIMB_RECEIPT"));
//				temp.setAuthor(rs.getInt("REIMB_AUTHOR"));
//				temp.setResolver(rs.getInt("REIMB_RESOLVER"));
//				temp.setStatusId(rs.getInt("REIMB_STATUS_ID"));
//				temp.setTypeId(rs.getInt("REIMB_TYPE_ID"));
				temp.setAuthor(rs.getString("AUTHOR"));
				temp.setResolver(rs.getString("RESOLVER"));
				temp.setStatus(rs.getString("STATUS_ID"));
				temp.setType(rs.getString("TYPE_ID"));
				reimbs.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbs;
	}
	
//	public List<Reimbursement> findAll(){
//        List<Reimbursement> full = new ArrayList<Reimbursement>();
//        try (Connection conn = ConnectionFactory.getInstance().getConnection()){
//            String sql = "select ers_reimbursement.reimb_id, ers_reimbursement.reimb_amount, " +
//                    "ers_reimbursement.reimb_submitted, ers_reimbursement.reimb_resolved, " +
//                    "ers_reimbursement.reimb_description, b.USER_FIRST_NAME, a.USER_FIRST_NAME, ers_reimbursement_status.reimb_status, " +
//                    "ers_reimbursement_type.reimb_type " +
//                    "FROM ((((ers_reimbursement " +
//                    "full outer JOIN ers_users a ON ers_reimbursement.reimb_resolver = a.ers_users_id) " +
//                    "full outer JOIN ers_reimbursement_type ON ers_reimbursement.reimb_type_id = ers_reimbursement_type.reimb_type_id) " +
//                    "full outer JOIN ers_reimbursement_status ON ers_reimbursement.reimb_status_id = ers_reimbursement_status.reimb_status_id) " +
//                    "INNER JOIN ers_users b ON ers_reimbursement.reimb_author = b.ers_users_id) order by ers_reimbursement_status.REIMB_STATUS_ID asc";
//        } catch (SQLException e) {
//        	e.printStackTrace();
//        }
//	}


	public List<Reimbursement> findAll(int id) {
		List<Reimbursement> reimbs = new ArrayList<Reimbursement>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
//			String query = "select * from ERS_REIMBURSEMENT where REIMB_AUTHOR = ?";
			String query =
					"select " + 
					"  reimb_id, reimb_amount, reimb_submitted, reimb_resolved, reimb_description, " + 
					"  (select ers_username from ers_users u where u.ers_users_id = r.reimb_author) as author, " + 
					"  (select ers_username from ers_users u where u.ers_users_id = r.reimb_resolver) as resolver, " + 
					"  (select reimb_status from ers_reimbursement_status s where s.reimb_status_id = r.reimb_status_id) as status_id, " + 
					"  (select reimb_type from ers_reimbursement_type ty where ty.reimb_type_id = r.reimb_type_id) as type_id " + 
					"from ERS_REIMBURSEMENT r where r.reimb_author = ?";

			String[] keys = new String[1];
			keys[0] = "REIMB_ID";
			
			PreparedStatement ps = conn.prepareStatement(query, keys);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {// book_id, isbn, title, price, genre
				Reimbursement temp = new Reimbursement();
				temp.setReimbId(rs.getInt("REIMB_ID"));
				temp.setAmount(rs.getDouble("REIMB_AMOUNT"));
				temp.setSubmitted(rs.getTimestamp("REIMB_SUBMITTED"));
				temp.setResolved(rs.getTimestamp("REIMB_RESOLVED"));
				temp.setDescription(rs.getString("REIMB_DESCRIPTION"));
//				temp.setReceipt(rs.getBlob("REIMB_RECEIPT"));
//				temp.setAuthor(rs.getInt("REIMB_AUTHOR"));
//				temp.setResolver(rs.getInt("REIMB_RESOLVER"));
//				temp.setStatusId(rs.getInt("REIMB_STATUS_ID"));
//				temp.setTypeId(rs.getInt("REIMB_TYPE_ID"));
				temp.setAuthor(rs.getString("AUTHOR"));
				temp.setResolver(rs.getString("RESOLVER"));
				temp.setStatus(rs.getString("STATUS_ID"));
				temp.setType(rs.getString("TYPE_ID"));
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
			ps.setInt(5, obj.getAuthorId());
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
