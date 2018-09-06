package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.ErsReimbursement;
import com.revature.util.ConnectionFactory;

public class ErsReimbursementDao implements DAO<ErsReimbursement, Integer> {
	
	private final String baseQuery = "SELECT rb.REIMB_ID, rb.REIMB_AMOUNT, rb.REIMB_SUBMITTED, rb.REIMB_RESOLVED, rb.REIMB_DESCRIPTION, rb.REIMB_RECEIPT, \r\n" + 
			"ua.USER_FIRST_NAME || ' ' || ua.USER_LAST_NAME AS AUTHOR, ur.USER_FIRST_NAME || ' ' || ur.USER_LAST_NAME AS RESOLVER, rt.REIMB_TYPE, st.REIMB_STATUS, ua.ERS_USERNAME   \r\n" + 
			"FROM ERS_REIMBURSEMENT rb\r\n" + 
			"INNER JOIN ERS_REIMBURSEMENT_STATUS st ON st.REIMB_STATUS_ID = rb.REIMB_STATUS_ID\r\n" + 
			"INNER JOIN ERS_REIMBURSEMENT_TYPE rt ON rt.REIMB_TYPE_ID = rb.REIMB_TYPE_ID\r\n" + 
			"INNER JOIN ERS_USERS ua ON ua.ERS_USER_ID = rb.REIMB_AUTHOR\r\n" + 
			"LEFT OUTER JOIN ERS_USERS ur ON ur.ERS_USER_ID = rb.REIMB_RESOLVER";
	
//	private final String baseQuery = "SELECT * FROM ERS_REIMBURSEMENT"
	
	@Override
	public List<ErsReimbursement> findAll() {
		List<ErsReimbursement> reimbList = new ArrayList<ErsReimbursement>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {

			String query = baseQuery + " ORDER BY rb.REIMB_SUBMITTED DESC";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				reimbList.add(new ErsReimbursement(rs.getInt(1), rs.getDouble(2), rs.getTimestamp(3),
						rs.getTimestamp(4), rs.getString(5), rs.getBlob(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10)));

			}
		} catch (SQLException e) {
			System.out.println("SQL Error " + e.getErrorCode() + ": " + e.getSQLState());
		}
		return reimbList;
	}

	@Override
	public ErsReimbursement findOne(Integer id) {
		ErsReimbursement reimb = null;

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String query = baseQuery + " WHERE REIMB_ID = ?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				reimb = new ErsReimbursement(rs.getInt(1), rs.getDouble(2), rs.getTimestamp(3),
						rs.getTimestamp(4), rs.getString(5), rs.getBlob(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10));
			}

		} catch (SQLException e) {
			System.out.println("SQL Error " + e.getErrorCode() + ": " + e.getSQLState());
		}
		return reimb;
	}
	
	public List<ErsReimbursement> findByUsername(String username) {
		List<ErsReimbursement> reimbList = new ArrayList<ErsReimbursement>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String query = "SELECT * FROM (" + baseQuery + ") WHERE ERS_USERNAME = ?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				reimbList.add(new ErsReimbursement(rs.getInt(1), rs.getDouble(2), rs.getTimestamp(3),
						rs.getTimestamp(4), rs.getString(5), rs.getBlob(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10)));
			}

		} catch (SQLException e) {
			System.out.println("SQL Error " + e.getErrorCode() + ": " + e.getSQLState());
		}
		return reimbList;
	}
	
	public List<ErsReimbursement> findByUserId(int userId) {
		List<ErsReimbursement> reimbList = new ArrayList<ErsReimbursement>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String query = baseQuery + " WHERE ua.ERS_USER_ID = ? ORDER BY rb.REIMB_SUBMITTED DESC";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				reimbList.add(new ErsReimbursement(rs.getInt(1), rs.getDouble(2), rs.getTimestamp(3),
						rs.getTimestamp(4), rs.getString(5), rs.getBlob(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10)));
			}

		} catch (SQLException e) {
			System.out.println("SQL Error " + e.getErrorCode() + ": " + e.getSQLState());
		}
		return reimbList;
	}

	@Override
	public ErsReimbursement insert(ErsReimbursement obj) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			// CREATE OR REPLACE PROCEDURE addreimbursement (amount IN NUMBER, text IN VARCHAR2, typeId IN NUMBER, authorId IN NUMBER)
			String query = "{call addreimbursement(?, ?, ?, ?)}";

			CallableStatement cs = conn.prepareCall(query);
			cs.setDouble(1, obj.getAmount());
			cs.setString(2, obj.getDescription());
			cs.setInt(3, obj.getTypeId());
			cs.setInt(4, obj.getAuthorId());
			cs.execute();

		} catch (SQLException e) {
			System.out.println("SQL Error " + e.getErrorCode() + ": " + e.getSQLState());
			return null;
		}
		return obj;
	}
	
	public void approveReimbursement(ErsReimbursement obj) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			// CREATE OR REPLACE PROCEDURE approvereimbursement (rId IN NUMBER)
			String query = "{call approvereimbursement(?, ?)}";

			CallableStatement cs = conn.prepareCall(query);
			cs.setInt(1, obj.getReimbId());
			cs.setInt(2, obj.getResolverId());
			cs.execute();

		} catch (SQLException e) {
			System.out.println("SQL Error " + e.getErrorCode() + ": " + e.getSQLState());
		}
	}
	
	public void denyReimbursement(ErsReimbursement obj) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			//CREATE OR REPLACE PROCEDURE denyreimbursement (rId IN NUMBER)
			String query = "{call denyreimbursement(?, ?)}";

			CallableStatement cs = conn.prepareCall(query);
			cs.setInt(1, obj.getReimbId());
			cs.setInt(2, obj.getResolverId());
			cs.execute();

		} catch (SQLException e) {
			System.out.println("SQL Error " + e.getErrorCode() + ": " + e.getSQLState());
		}
	}
	
	
	@Override
	public ErsReimbursement update(ErsReimbursement obj) {
		// This should never occur
		return null;
	}

	@Override
	public void delete(ErsReimbursement obj) {
		// This should never occur
	}

}
