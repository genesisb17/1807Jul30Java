package servletExample.dao;





import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import servletExample.pojo.NewReim;
import servletExample.pojo.Reimbursement;
import servletExample.pojo.User;
import servletExample.pojo.UserInfo;
import servletExample.util.ConnectionUtil;

public class ReimbursementDao {
	
	private static ReimbursementDao instance;
	
	private ReimbursementDao() {	
	}
	
	public static ReimbursementDao getInstance() {
		if (instance == null) 
			instance = new ReimbursementDao();
			return instance;
	}
	
	//lets user add reimbursement
	public void addReimbursement(Reimbursement r) {
		int index = 0;
		try(Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO REIMBURSEMENT(R_AMOUNT, R_SUBMIT_TIME, R_DESC, USERNAME, RS_ID, RT_ID)\r\n" + 
					"VALUES (?, SYSDATE , ?, ?,1,?)");
			System.out.println(r.getAmount());
			System.out.println(typeOfReim(r.getType()));
			System.out.println(r.getUsername());
			ps.setDouble(++index, r.getAmount());
			ps.setString(++index, r.getInfo());
//			ps.setBytes(++index, r.getRecpt());
			ps.setString(++index, r.getUsername());
			ps.setInt(++index, typeOfReim(r.getType()));
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println(e.getErrorCode() + e.getSQLState());
		}
	}
	
	//admin can choose an action and particular request to affect
	public void evalReimbursement(NewReim nr) {
		int index = 0;
		try(Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("UPDATE REIMBURSEMENT\r\n" + 
					"SET R_RESOLVED_TIME = SYSDATE, R_RESOLVER = 'admin', rs_id = ?\r\n" + 
					"WHERE R_ID = ?");
			ps.setInt(++index, statusOfReim(nr.getStatus()));
			ps.setInt(++index, nr.getRid());
			System.out.println(nr.getRid());
			System.out.println(nr.getStatus());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println(e.getErrorCode() + e.getSQLState());
		}
	}
	
	//gets all the users reimbursments
	public List<Reimbursement> getUserReimbursements(UserInfo u) {
		Reimbursement r = null;
		List<Reimbursement> reimbur = new ArrayList<Reimbursement>();
		int index = 0;
		try(Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT R.R_ID, R.R_AMOUNT, R.R_SUBMIT_TIME, R.R_RESOLVED_TIME, R.R_DESC, R.R_RECIEPT, R.USERNAME, R.R_RESOLVER, RS.R_STATUS, RT.R_TYPE FROM REIMBURSEMENT R INNER JOIN R_STATUS RS ON R.RS_ID=RS.RS_ID INNER JOIN R_TYPE RT ON R.RT_ID=RT.RT_ID WHERE USERNAME = ? ORDER BY R_SUBMIT_TIME desc");
			ps.setString(++index, u.getUsername());
			ResultSet info = ps.executeQuery();
			while (info.next()) {
				Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("America/Costa_Rica"));
				r = new Reimbursement();
				r.setRid(info.getInt(1));
				r.setAmount(info.getDouble(2));
				r.setSdate(info.getTimestamp(3, cal));
				r.setRdate(info.getTimestamp(4, cal));
				r.setInfo(info.getString(5));
				r.setRecpt(info.getBytes(6));
				r.setUsername(info.getString(7));
				r.setResolver(info.getString(8));
				r.setStatus(info.getString(9));
				r.setType(info.getString(10));
				reimbur.add(r);
				System.out.println(reimbur.size());
			}
		} catch (SQLException e) {
			System.err.println(e.getErrorCode() + e.getSQLState());
		}
		return reimbur;
	}
	
	// gets all the reimbursments for the admin view
	public List<Reimbursement> getAllReimbursements() {
		Reimbursement r = null;
		List<Reimbursement> reimbur = new ArrayList<Reimbursement>();
		try(Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT R.R_ID, R.R_AMOUNT, R.R_SUBMIT_TIME, R.R_RESOLVED_TIME, R.R_DESC, R.R_RECIEPT, R.USERNAME, R.R_RESOLVER, RS.R_STATUS, RT.R_TYPE FROM REIMBURSEMENT R INNER JOIN R_STATUS RS ON R.RS_ID=RS.RS_ID INNER JOIN R_TYPE RT ON R.RT_ID=RT.RT_ID ORDER BY rs.R_status desc, r.r_submit_time desc");
			ResultSet info = ps.executeQuery();
			while(info.next()) {
				Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("America/Costa_Rica"));
				r = new Reimbursement();
				r.setRid(info.getInt(1));
				r.setAmount(info.getDouble(2));
				r.setSdate(info.getTimestamp(3, cal));
				r.setRdate(info.getTimestamp(4, cal));
				r.setInfo(info.getString(5));
				r.setRecpt(info.getBytes(6));
				r.setUsername(info.getString(7));
				r.setResolver(info.getString(8));
				r.setStatus(info.getString(9));
				r.setType(info.getString(10));
				reimbur.add(r);
			}
		} catch (SQLException e) {
			System.err.println(e.getErrorCode() + e.getSQLState());
		}
		return reimbur;
	}
	
	//takes type of reim and returns the type id.
	public static int typeOfReim(String s) {
		
		switch(s) {
		case "LODGING":
			return 1;
		case "TRAVEL":
			return 2;
		case "FOOD":
			return 3;
		case "OTHER":
			return 4;
		default:
			return 1;
		}
	}
	
	//takes status of reim and returns status id.
	public static int statusOfReim(String s) {
		switch(s) {
		case "OPEN":
			return 1;
		case "APPROVED":
			return 2;
		case "DENIED":
			return 3;
		case "CLOSED":
			return 4;
		default:
			return 1;
		}	
	}
	
}
