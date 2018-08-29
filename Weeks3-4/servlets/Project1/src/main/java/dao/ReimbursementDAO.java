package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.internal.OracleTypes;
import pojos.Employee;
import pojos.Reimbursement;
import pojos.Status;
import util.ConnectionFactory;

public class ReimbursementDAO implements DAO<Reimbursement, Integer>{
	public static void main(String[] args) {
//		ReimbursementDAO e = new ReimbursementDAO();
//		EmployeeDAO ed = new EmployeeDAO();
//		Reimbursement ee = new Reimbursement();
//		Employee emp = new Employee();
//		emp.setEmployee_id(1);
//		emp = ed.getAll().get(0);	
//		System.out.println(e.findOne(e.getAll().get(0)));
		
//		ee.setAmount(500);
//		ee.setDescription("vien");
//		ee.setAuthor(9);
//		ee.setType_id(4);
//
//		System.out.println(e.save(ee).toString());
		
//		ee.setAmount(2);
		
//		System.out.println(e.update(ee));
//		System.out.println(e.getAll());
//		System.out.println(e.resolveReimbursement(ee, emp, 3));
//		
//		System.out.println(e.getAll());	
		}
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
				temp.setSubmitted(rs.getTimestamp("submitted"));
				temp.setResolved(rs.getTimestamp("resolved"));
				temp.setDescription(rs.getString("description"));
//				temp.setReceipt(rs.getBlob("receipt")); //int blob???
				temp.setAuthor(rs.getInt("author"));
				temp.setResolver(rs.getInt("resolver_id"));
				temp.setStatus_id(rs.getInt("status_id"));
				temp.setType_id(rs.getInt("type_id"));

				Reimbursements.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		
		return Reimbursements;
	}

	
	public Reimbursement findOne(Reimbursement obj) {
		Reimbursement temp = new Reimbursement();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from Reimbursement where Reimb_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, obj.getReimb_id()); //was a string passed "id"
			ResultSet info = ps.executeQuery();
			
			while(info.next()) {
				temp.setReimb_id(info.getInt(1));
				temp.setAmount(info.getDouble(2));
				temp.setSubmitted(info.getTimestamp("submitted")); //int date???
				temp.setResolved(info.getTimestamp("resolved"));
				temp.setDescription(info.getString("description"));
//				temp.setReceipt(inf	o.getBlob("receipt")); //int blob???
				temp.setAuthor(info.getInt("author"));
				temp.setResolver(info.getInt("resolver_id"));
				temp.setStatus_id(info.getInt("status_id"));
				temp.setType_id(info.getInt("type_id"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return temp;
	}

	public Reimbursement save(Reimbursement obj) {
		System.out.println(obj.toString() + " top of save");
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			conn.setAutoCommit(false);
			String sql = "insert into Reimbursement("
					+ "amount,"
					+ "description,"
					+ "author,"
					+ "type_id) "
					+ "values("
					+ "?,"
					+ "?,"
					+ "?,"
					+ "?)";
			
			String[] keys = {"Reimb_id"};
			
			PreparedStatement ps = conn.prepareStatement(sql, keys);

			ps.setDouble(1,  obj.getAmount());
			ps.setString(2,  obj.getDescription());

			ps.setInt(3, obj.getAuthor());
			ps.setInt(4, obj.getType_id());
			
			int rowsUpdated = ps.executeUpdate();
			if(rowsUpdated != 0) {
				ResultSet pk = ps.getGeneratedKeys();//---------------------fix me
				while(pk.next()) {
					obj.setReimb_id(pk.getInt(1));
				}
				conn.commit();
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		
		return obj;
	}
	//--------------------------------------------------------------------DOES NOT WORK
	public List<Reimbursement> getAllEmployeeReimbursements(Employee c) {//MAKE A FUNCTION IN SQL
		List<Reimbursement> Reimbursements = new ArrayList<Reimbursement>();
		Reimbursement temp = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * " + 
					"FROM EMPLOYEE " + 
					"RIGHT OUTER JOIN REIMBURSEMENT " + 
					"ON REIMBURSEMENT.AUTHOR = EMPLOYEE.?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, c.getEmployee_id()); //was a string passed "id"
			ResultSet info = ps.executeQuery();
			
			while(info.next()) {
				temp = new Reimbursement();
				temp.setReimb_id(info.getInt(1));
				temp.setAmount(info.getDouble(2));
				temp.setSubmitted(info.getTimestamp("submitted")); //int date???
				temp.setResolved(info.getTimestamp("resolved"));
				temp.setDescription(info.getString("description"));
//				temp.setReceipt(info.getBlob("receipt")); //int blob???
				temp.setAuthor(info.getInt("author"));
				temp.setResolver(info.getInt("resolver_id"));
				temp.setStatus_id(info.getInt("status_id"));
				temp.setType_id(info.getInt("type_id"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		
		return Reimbursements;
	}
	
	public Reimbursement update(Reimbursement obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			conn.setAutoCommit(false);
			String sql = "update Reimbursement set amount = ? "
					+ "where author = ? and reimb_id = ?";// changed from Reimbursement_idi
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setDouble(1, obj.getAmount());
			ps.setInt(2, obj.getAuthor());//			change from getId
			ps.setInt(3, obj.getReimb_id());
//			ps.setInt(4, obj.getStatus_id());
			
			ps.executeUpdate();
			conn.commit();			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}		
		return obj;
	}
//-------------------------------------------------------------------------------BROKEN
	public Reimbursement resolveReimbursement(Reimbursement r, Employee e, int s) {
//		Reimbursement temp = new Reimbursement();
		System.out.println(r.getReimb_id());
		System.out.println(e.getEmployee_id());
		System.out.println(r.getStatus_id());
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{call resolve_reimbursement(?,?,?)}";
			CallableStatement cs = conn.prepareCall(sql);
	
			cs.setInt(1, r.getReimb_id());
			cs.setInt(2, e.getEmp_role_id());
			cs.setInt(3, s);
			
//			cs.registerOutParameter(1, OracleTypes.NUMBER);
			
//			cs.registerOutParameter(2, OracleTypes.NUMBER);
			
			cs.execute();
			r.setResolver(e.getEmployee_id());
			r.setStatus_id(s);
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.err.println("SQL State: " + ex.getSQLState());
			System.err.println("Error Code: " + ex.getErrorCode());
		}
		
		return r;
	}
	
	Reimbursement getPendingReimbursements() {
		return null;
		
	}
	
	public void delete(Reimbursement obj) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Reimbursement findOne(int id) {
		Reimbursement temp = new Reimbursement();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from Reimbursement where Reimb_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id); //was a string passed "id"
			ResultSet info = ps.executeQuery();
			
			while(info.next()) {
				temp.setReimb_id(info.getInt(1));
				temp.setAmount(info.getDouble(2));
				temp.setSubmitted(info.getTimestamp("submitted")); //int date???
				temp.setResolved(info.getTimestamp("resolved"));
				temp.setDescription(info.getString("description"));
//				temp.setReceipt(inf	o.getBlob("receipt")); //int blob???
				temp.setAuthor(info.getInt("author"));
				temp.setResolver(info.getInt("resolver_id"));
				temp.setStatus_id(info.getInt("status_id"));
				temp.setType_id(info.getInt("type_id"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return temp;
	}

}

//public Reimbursement save(Reimbursement obj) {
//	
//	try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
//		
//		conn.setAutoCommit(false);
//		String sql = "insert into Reimbursement("
//				+ "amount,"
////				+ "submitted,"
////				+ "resolved,"
//				+ "description,"
////				+ "receipt,"
//				+ "author,"
////				+ "resolver_id,"
////				+ "status_id,"
//				+ "type_id) "
//				+ "values("
//				+ "?,"
////				+ "?,"
////				+ "?,"
//				+ "?,"
////				+ "?,"
//				+ "?,"
////				+ "?,"
////				+ "?,"
//				+ "?)";
//		
//		String[] keys = {"Reimb_id"};
//		
//		PreparedStatement ps = conn.prepareStatement(sql, keys);
//		ps.setInt(1, obj.getReimb_id());
//		ps.setDouble(1,  obj.getAmount());
////		ps.setTimestamp(3, obj.getSubmitted());
////		ps.setTimestamp(4, obj.getResolved());
//		ps.setString(2,  obj.getDescription());
////		ps.setBlob(6, obj.getReceipt());
//		ps.setInt(3, obj.getAuthor());
////		ps.setInt(8, obj.getResolver());
////		ps.setInt(9, obj.getStatus_id());
//		ps.setInt(4, obj.getType_id());
//		
//		int rowsUpdated = ps.executeUpdate();
//		if(rowsUpdated != 0) {
//			ResultSet pk = ps.getGeneratedKeys();//---------------------fix me
//			while(pk.next()) {
//				obj.setReimb_id(pk.getInt(1));
//			}
//			conn.commit();
//		}
//		conn.commit();
//	} catch (SQLException e) {
//		e.printStackTrace();
//		System.err.println("SQL State: " + e.getSQLState());
//		System.err.println("Error Code: " + e.getErrorCode());
//	}
//	
//	return obj;
//}
