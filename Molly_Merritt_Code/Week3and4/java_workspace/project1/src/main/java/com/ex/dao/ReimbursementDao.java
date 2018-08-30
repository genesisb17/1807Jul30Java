package com.ex.dao;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ex.pojos.Reimbursement;
import com.ex.pojos.User;
import com.ex.pojos.UserInformation;
import com.ex.util.ConnectionFactory;

import oracle.jdbc.internal.OracleTypes;

public class ReimbursementDao implements Dao<Reimbursement, Integer> {

	public List findAll() {
		List<Reimbursement> reimbs = new ArrayList<Reimbursement>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{call get_all_reimbursements(?)}";	// must call inside curly braces
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			
			ResultSet rs = (ResultSet) cs.getObject(1);
			while(rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setAmount(rs.getInt("REIMB_AMOUNT"));
				temp.setSubmitted(rs.getTimestamp("REIMB_SUBMITTED"));
				temp.setResolved(rs.getTimestamp("REIMB_RESOLVED"));
				temp.setDescription(rs.getString("REIMB_RECEIPT"));
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

	public Reimbursement findOne(Integer id) {
		return null;
	}

	public Reimbursement save(Reimbursement obj) {
		return null;
	}

	public Reimbursement update(Reimbursement obj) {
		return null;
	}

	public boolean isUnique(Reimbursement obj) {
		return false;
	}

}
