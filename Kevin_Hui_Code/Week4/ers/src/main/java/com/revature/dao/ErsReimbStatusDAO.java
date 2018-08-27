package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.util.ConnectionFactory;
import com.revature.pojo.ErsReimbStatus;

public class ErsReimbStatusDAO implements DAO<ErsReimbStatus, Integer> {

	@Override
	public List<ErsReimbStatus> findAll() {
		List<ErsReimbStatus> statuses = new ArrayList<ErsReimbStatus>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String query = "SELECT * FROM ERS_REIMBURSEMENT_STATUS ORDER BY REIMB_STATUS_ID";

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				statuses.add(new ErsReimbStatus(rs.getInt(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			System.out.println("SQL Error " + e.getErrorCode() + ": " + e.getSQLState());
		}
		return statuses;
	}

	@Override
	public ErsReimbStatus findOne(Integer id) {
		ErsReimbStatus status = null;

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String query = "SELECT * FROM ERS_REIMBURSEMENT_STATUS WHERE REIMB_STATUS_ID = ?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			status = new ErsReimbStatus(rs.getInt(1), rs.getString(2));
			
		} catch (SQLException e) {
			System.out.println("SQL Error " + e.getErrorCode() + ": " + e.getSQLState());
		}
		return status;
	}

	@Override
	public ErsReimbStatus insert(ErsReimbStatus obj) {
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String query = "INSERT INTO ERS_REIMBURSEMENT_STATUS (REIMB_STATUS) VALUES(?)";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, obj.getStatus());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQL Error " + e.getErrorCode() + ": " + e.getSQLState());
		}
		return obj;
	}

	@Override
	public ErsReimbStatus update(ErsReimbStatus obj) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String query = "UPDATE ERS_REIMBURSEMENT_STATUS SET REIMB_STATUS = ? WHERE REIMB_STATUS_ID = ?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, obj.getStatus());
			ps.setInt(2, obj.getStatusId());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQL Error " + e.getErrorCode() + ": " + e.getSQLState());
		}
		return obj;
	}

	@Override
	public void delete(ErsReimbStatus obj) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String query = "DELETE FROM ERS_REIMBURSEMENT_STATUS WHERE REIMB_STATUS = ?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, obj.getStatus());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQL Error " + e.getErrorCode() + ": " + e.getSQLState());
		}
	}

}
