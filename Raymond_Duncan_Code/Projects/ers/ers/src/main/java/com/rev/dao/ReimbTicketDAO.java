package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.rev.pojos.ReimbTicket;
import com.rev.pojos.User;
import com.rev.utils.ConnectionFactory;

public class ReimbTicketDAO implements DAO<ReimbTicket, Long> {

	@Override
	public List<ReimbTicket> getAll() {
		List<ReimbTicket> reimbTickets = new ArrayList<ReimbTicket>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "SELECT * FROM ers_reimbursement";
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(query);
			while(rs.next()) {
				ReimbTicket temp = new ReimbTicket();
				temp.setreimbID(rs.getLong("reimb_id"));
				temp.setreimbAmount(rs.getDouble("reimb_amount"));
				temp.setReimbSubmitted(rs.getTimestamp("reimb_submitted"));
				temp.setReimbResolved(rs.getTimestamp("reimb_resolved"));
				temp.setReimbDescription(rs.getString("reimb_description"));
				temp.setReimbAuthor(rs.getLong("reimb_author"));
				temp.setReimbResolver(rs.getLong("reimb_resolver"));
				temp.setReimbStatus(rs.getInt("reimb_status_id"));
				temp.setReimbType(rs.getInt("reimb_type_id"));
				reimbTickets.add(temp);
			}
		} catch(SQLException sql) {
			sql.printStackTrace();
		}
		return reimbTickets;
	}
	
	public List<ReimbTicket> getAll(User u) {
		List<ReimbTicket> reimbTickets = new ArrayList<ReimbTicket>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "SELECT * FROM ers_reimbursement WHERE reimb_author=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, u.getUserID());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ReimbTicket temp = new ReimbTicket();
				temp.setreimbID(rs.getLong("reimb_id"));
				temp.setreimbAmount(rs.getDouble("reimb_amount"));
				temp.setReimbSubmitted(rs.getTimestamp("reimb_submitted"));
				temp.setReimbResolved(rs.getTimestamp("reimb_resolved"));
				temp.setReimbDescription(rs.getString("reimb_description"));
				temp.setReimbAuthor(rs.getLong("reimb_author"));
				temp.setReimbResolver(rs.getLong("reimb_resolver"));
				temp.setReimbStatus(rs.getInt("reimb_status_id"));
				temp.setReimbType(rs.getInt("reimb_type_id"));
				reimbTickets.add(temp);
			}
		} catch(SQLException sql) {
			sql.printStackTrace();
		}
		return reimbTickets;
	}

	@Override
	public ReimbTicket getOne(Long id) {
		ReimbTicket reimbTicket = new ReimbTicket();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "SELECT * FROM ers_reimbursement WHERE reimb_id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				reimbTicket =new ReimbTicket();
				reimbTicket.setreimbID(id);
				reimbTicket.setreimbAmount(rs.getDouble("reimb_amount"));
				reimbTicket.setReimbSubmitted(rs.getTimestamp("reimb_submitted"));
				reimbTicket.setReimbResolved(rs.getTimestamp("reimb_resolved"));
				reimbTicket.setReimbDescription(rs.getString("reimb_description"));
				reimbTicket.setReimbAuthor(rs.getLong("reimb_author"));
				reimbTicket.setReimbResolver(rs.getLong("reimb_resolver"));
				reimbTicket.setReimbStatus(rs.getInt("reimb_status_id"));
				reimbTicket.setReimbType(rs.getInt("reimb_type_id"));
			}
		} catch(SQLException sql) {
			sql.printStackTrace();
		}
		return reimbTicket;
	}
	
	public ReimbTicket getOne(Long authorID, Timestamp submitted) {
		ReimbTicket reimbTicket = new ReimbTicket();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "SELECT * FROM ers_reimbursement WHERE reimb_author = ? AND reimb_submitted = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, authorID);
			ps.setTimestamp(2, submitted);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				reimbTicket =new ReimbTicket();
				reimbTicket.setreimbID(rs.getLong("reimb_id"));
				reimbTicket.setreimbAmount(rs.getDouble("reimb_amount"));
				reimbTicket.setReimbSubmitted(rs.getTimestamp("reimb_submitted"));
				reimbTicket.setReimbResolved(rs.getTimestamp("reimb_resolved"));
				reimbTicket.setReimbDescription(rs.getString("reimb_description"));
				reimbTicket.setReimbAuthor(rs.getLong("reimb_author"));
				reimbTicket.setReimbResolver(rs.getLong("reimb_resolver"));
				reimbTicket.setReimbStatus(rs.getInt("reimb_status_id"));
				reimbTicket.setReimbType(rs.getInt("reimb_type_id"));
			}
		} catch(SQLException sql) {
			sql.printStackTrace();
		}
		return reimbTicket;
	}

	@Override
	public ReimbTicket save(ReimbTicket t) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "UPDATE ers_reimbursement SET reimb_resolved=?,reimb_resolver=?,reimb_status_id=? WHERE reimb_id=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setTimestamp(1, t.getReimbResolved());
			ps.setLong(2, t.getReimbResolver());
			ps.setInt(3, t.getReimbStatus());
			ps.setLong(4, t.getreimbID());
			int numRowsAffected = ps.executeUpdate();
			if(numRowsAffected == 1) {
				return t;
			}
			
		} catch(SQLException sql) {
			sql.printStackTrace();
		}
		return null;
	}

	@Override
	public ReimbTicket saveNew(ReimbTicket t) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
//			String query = "INSERT INTO ers_reimbursement(reimb_amount,reimb_submitted,reimb_description,reimb_author,reimb_status_id,reimb_type_id,reimb_receipt) VALUES(?,?,?,?,?,?,?)";
			String query = "INSERT INTO ers_reimbursement(reimb_amount,reimb_submitted,reimb_description,reimb_author,reimb_status_id,reimb_type_id) VALUES(?,?,?,?,?,?)";
			t.setReimbSubmitted(Timestamp.valueOf(LocalDateTime.now()));
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setDouble(1, t.getreimbAmount());
			ps.setTimestamp(2, t.getReimbSubmitted());
			ps.setString(3, t.getReimbDescription());
			ps.setLong(4, t.getReimbAuthor());
			ps.setInt(5, t.getReimbStatus());
			ps.setInt(6, t.getReimbType());
//			ps.setBlob(7, t.getReceipt());
			int numRowsAffected = ps.executeUpdate();
			if(numRowsAffected == 1) {
				return this.getOne(t.getReimbAuthor(), t.getReimbSubmitted());
			}
			
		} catch(SQLException sql) {
			sql.printStackTrace();
		}
		return null;
	}

}
