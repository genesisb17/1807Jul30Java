package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.internal.OracleTypes;
import pojos.Employee;import pojos.Reimbursement;
import util.ConnectionFactory;

public class ReimbursementDAO implements DAO<Reimbursement, Integer>{

	public List<Reimbursement> getAll() {
		List<Reimbursement> Reimbursements = new ArrayList<Reimbursement>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{call get_all_Reimbursements(?)}";
			CallableStatement cs = conn.prepareCall(sql);
	
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			ResultSet rs = (ResultSet) cs.getObject(1);
			
			while(rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setReimb_id(rs.getInt("Reimb_id"));
				temp.setAmount(rs.getInt("amount"));
				temp.setSubmitted(rs.getTimestamp("submitted")); //int date???
				temp.setResolved(rs.getTimestamp("resolved"));
				temp.setDescription(rs.getString("description"));
				temp.setReceipt(rs.getBlob("receipt")); //int blob???
				temp.setAuthor(rs.getInt("author"));
				temp.setResolver(rs.getInt("resolver"));
				temp.setStatus_id(rs.getInt("status_id"));
				temp.setType_id(rs.getInt("type_id"));

				//System.out.println(temp);
				Reimbursements.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Reimbursements;
	}

	public Reimbursement findOne(Reimbursement obj) {
		Reimbursement temp = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from Reimbursement where Reimb_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, obj.getReimb_id()); //was a string passed "id"
			ResultSet info = ps.executeQuery();
			
			while(info.next()) {
				temp = new Reimbursement();
				temp.setReimb_id(info.getInt(1));
				temp.setAmount(info.getDouble(2));
				temp.setSubmitted(info.getTimestamp("submitted")); //int date???
				temp.setResolved(info.getTimestamp("resolved"));
				temp.setDescription(info.getString("description"));
				temp.setReceipt(info.getBlob("receipt")); //int blob???
				temp.setAuthor(info.getInt("author"));
				temp.setResolver(info.getInt("resolver"));
				temp.setStatus_id(info.getInt("status_id"));
				temp.setType_id(info.getInt("type_id"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}

	public Reimbursement save(Reimbursement obj) {
		Reimbursement aa = new Reimbursement();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			conn.setAutoCommit(false);
			String sql = "insert into Reimbursement(Reimb_id, amount,submitted,"
					+ "resolved,description,receipt,author,resolver,status_id,"
					+ "type_id) values(?,?,?,?,?,?,?,?,?,?)";
			
			String[] keys = {"Reimb_id"};
			
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setInt(1, obj.getReimb_id());
			ps.setDouble(2,  obj.getAmount());
			ps.setTimestamp(3, obj.getSubmitted());
			ps.setTimestamp(4, obj.getResolved());
			ps.setString(5,  obj.getDescription());
			ps.setBlob(6, obj.getReceipt());
			ps.setInt(7, obj.getAuthor());
			ps.setInt(8, obj.getResolver());
			ps.setInt(9, obj.getStatus_id());
			ps.setInt(10, obj.getType_id());
			
			int rowsUpdated = ps.executeUpdate();
			if(rowsUpdated != 0) {
				ResultSet pk = ps.getGeneratedKeys();//---------------------fix me
				while(pk.next()) {
					//System.out.println(pk.getInt(1) + " the key");
					obj.setReimb_id(pk.getInt(1));
					obj.setAmount(pk.getInt(2));
					obj.setSubmitted(pk.getTimestamp(3));
					obj.setResolved(pk.getTimestamp(4));
					obj.setDescription(pk.getString(5));
					obj.setReceipt(pk.getBlob(6));
					obj.setAuthor(pk.getInt(7));
					obj.setResolver(pk.getInt(8));
					obj.setStatus_id(pk.getInt(9));
					obj.setType_id(pk.getInt(10));
				}
				conn.commit();
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return obj;
	}
	
	public List<Reimbursement> getReimbursements(Employee c) {//MAKE A FUNCTION IN SQL
		List<Reimbursement> Reimbursements = new ArrayList<Reimbursement>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{call get_all_employee_Reimbursements(?)}";
			CallableStatement cs = conn.prepareCall(sql);
	
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			ResultSet rs = (ResultSet) cs.getObject(1);
			
			while(rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setReimb_id(rs.getInt("reimb_id"));
				temp.setAmount(rs.getDouble("amount"));
				temp.setSubmitted(rs.getTimestamp("submitted"));
				temp.setResolved(rs.getTimestamp("resolved"));
				temp.setDescription(rs.getString("description"));
				temp.setReceipt(rs.getBlob("receipt"));
				temp.setAuthor(rs.getInt("author"));
				temp.setResolver(rs.getInt("resolver"));
				temp.setStatus_id(rs.getInt("status_id"));
				temp.setType_id(rs.getInt("type_id"));
				Reimbursements.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Reimbursements;
	}
	
	public Reimbursement update(Reimbursement obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			conn.setAutoCommit(false);
			String sql = "update Reimbursements set amount = ? where author = ? and reimb_id = ?";// changed from Reimbursement_idi
			
			String[] keys = {"Reimb_ID"};
			
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setDouble(1, obj.getAmount());
			ps.setInt(2, obj.getAuthor());//			change from getId
			ps.setInt(3, obj.getReimb_id());
			
			ps.executeQuery();
			conn.commit();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}

	public void delete(Reimbursement obj) {
		// TODO Auto-generated method stub
		
	}

}
