package com.ex.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ex.pojos.Reimbursement;
import com.ex.util.ConnectionFactory;

public class ReimbursementDao {

	public static List<Reimbursement> getAllReimbursements(int userid) {
		List<Reimbursement> viewAll = new ArrayList<Reimbursement>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "SELECT REIMB_AMOUNT, REIMB_SUBMITTED, REIMB_RESOLVED, REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_RESOLVER, REIMB_STATUS_ID, REIMB_TYPE_ID FROM ERS_REIMBURSEMENT"
					+ " WHERE REIMB_AUTHOR = " + userid;
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setAmount(rs.getDouble(1));
				temp.setSubmitted(rs.getString(2));
				temp.setResolved(rs.getString(3));
				temp.setDescription(rs.getString(4));
				temp.setAuthor(rs.getInt(5));
				temp.setResolver(rs.getInt(6));
				temp.setStatusid(rs.getInt(7));
				temp.setTypeid(rs.getInt(8));
				viewAll.add(temp);
			}


		} catch (SQLException e) {
		//	e.printStackTrace();
		}
		
		return viewAll;
	}
}
