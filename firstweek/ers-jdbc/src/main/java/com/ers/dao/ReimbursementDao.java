package com.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import com.ers.pojo.Reimbursement;
import com.ers.pojo.User;
import com.ers.util.ConnectionFactory;

public class ReimbursementDao {
	
//	public Reimbursement addOne(Reimbursement reimbur) throws SQLException {
//		Connection conn = ConnectionFactory.getInstance().getConnection();
//			conn.setAutoCommit(false);
//			String sql = "INSERT INTO REIMBURSEMENT(R_AMOUNT, R_SUBMIT_TIME, R_RESOLVED_TIME, R_DESC, R_RECIEPT, U_ID, R_RESOLVER, RS_ID, RT_ID)\r\n" + 
//					"VALUES (?, TO_DATE('?', 'YYYY-MM-DD HH24:MI'), TO_DATE('?', 'YYYY-MM-DD HH24:MI'), '?', UTL_RAW.CAST_TO_RAW('C:\\Users\\Dylan\\Desktop\\enthuware proof.PNG'),?,?,?,?)";
//			String[] keys = {"R_ID"};
//			PreparedStatement ps = conn.prepareStatement(sql, keys);
//			ps.setInt(1, reimbur.getAmount());
//			ps.setTimestamp(2, reimbur.getSdate());
//			ps.setString(1, user.getFirstname());
//			ps.setString(1, user.getLastname());
//			ps.setString(1, user.getEmail());
//			int rowsUpdated = ps.executeUpdate();
//			if(rowsUpdated >0) {
//				ResultSet pk = ps.getGeneratedKeys();
	
//				
//				while(pk.next()) {
//					user.setUid(pk.getInt(1));
//				}
//				conn.commit();
//			}
//			conn.commit();
//		 
//		return user;
//	}
	
	public List<Reimbursement> findRequests(User u) throws SQLException {
		Reimbursement r = null;
		List<Reimbursement> reimbur = new ArrayList<Reimbursement>();
		Connection conn = ConnectionFactory.getInstance().getConnection();
			String sql  = "SELECT R.R_ID, R.R_AMOUNT, R.R_SUBMIT_TIME, R.R_RESOLVED_TIME, R.R_DESC, R.R_RECIEPT, M.LASTNAME, RS.R_STATUS, RT.R_TYPE\r\n" + 
					"FROM REIMBURSEMENT R INNER JOIN USERS U ON R.U_ID=U.U_ID INNER JOIN\r\n" + 
					"USERS M ON R.R_RESOLVER = M.U_ID INNER JOIN\r\n" + 
					"R_STATUS RS ON R.RS_ID=RS.RS_ID INNER JOIN\r\n" + 
					"R_TYPE RT ON R.RT_ID=RT.RT_ID\r\n" + 
					"WHERE U.U_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setInt(1, u.getUid());
			ResultSet info = ps.executeQuery();
			while(info.next()) {
				Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("America/Costa_Rica"));
				r = new Reimbursement();
				r.setRid(info.getInt(1));
				r.setAmount(info.getInt(2));
				r.setSdate(info.getTimestamp(3, cal));
				r.setRdate(info.getTimestamp(4, cal));
				r.setInfo(info.getString(5));
				r.setRecpt(info.getBlob(6));
				r.setResolver(info.getString(7));
				reimbur.add(r);
			}
		
		
		return reimbur;			
	}
}
