package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import oracle.jdbc.OracleTypes;
import pojos.Employee;
import util.ConnectionFactory;
import util.ConnectionUtil;

public class EmployeeDAO implements DAO<Employee, Integer> {
	
	private static EmployeeDAO instance;
//	

	public static void main(String[] args) {
//		EmployeeDAO e = new EmployeeDAO();
//		Employee ee = new Employee();
		
//		System.out.println(e.getAll());		
//		System.out.println(e.findOne(e.getAll().get(0)));
		
//		ee.setEmp_username("demo");
//		ee.setEmp_password("demo");
//		ee.setFirst_name("demo");
//		ee.setLast_name("demo");
//		ee.setEmail("demo@demo");
//		ee.setEmp_role_id(1);

//		System.out.println(EmployeeDAO.getInstance().findOne("test"));
//		System.out.println(e.isUnique(ee));
//		System.out.println(e.save(ee));
		
//		ee.setEmp_role_id(2);
//		e.update(ee);
		
//		System.out.println(ee + "    new one");
		
//		System.out.println(e.update(ee));
	}
	private static EmployeeDAO getInstance() {
			if (instance == null) 
				instance = new EmployeeDAO();
			return instance;
	}

	public List<Employee> getAll() {
		List<Employee> employees = new ArrayList<Employee>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{call get_all_employees(?)}";
			
			CallableStatement cs = conn.prepareCall(sql);
	
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			
			ResultSet rs = (ResultSet) cs.getObject(1);
			
			while(rs.next()) {
				Employee temp = new Employee();
				temp.setEmployee_id(rs.getInt("employee_id"));
				temp.setEmp_username(rs.getString("emp_username"));
				temp.setEmp_password(rs.getString("emp_password"));
				temp.setFirst_name(rs.getString("first_name"));
				temp.setLast_name(rs.getString("last_name"));
				temp.setEmail(rs.getString("email"));
				temp.setEmp_role_id(rs.getInt("emp_role_id"));
				//System.out.println(temp);
				employees.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		
		return employees;
	}

	public Employee findOne(Employee obj) { //----------------THIS TOOK IN A STRING
		Employee temp = new Employee();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "select * from employee where emp_username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			
			ps.setString(1, obj.getEmp_username());//maybe needs to be changed to something else
			
			ResultSet info = ps.executeQuery();
						
			while(info.next()) {
				temp.setEmployee_id(info.getInt(1));
				temp.setEmp_username(info.getString(2));
				temp.setEmp_password(info.getString(3));
				temp.setFirst_name(info.getString(4));
				temp.setLast_name(info.getString(5));
				temp.setEmail(info.getString(6));
				temp.setEmp_role_id(info.getInt(7));
//				temp.setEmployee_id(info.getInt("employee_id"));
//				temp.setEmp_username(info.getString("emp_username"));
//				temp.setEmp_password(info.getString("emp_password"));
//				temp.setFirst_name(info.getString("first_name"));
//				temp.setLast_name(info.getString("last_name"));
//				temp.setEmail(info.getString("email"));
//				temp.setEmp_role_id(info.getInt("emp_role_id"));
			} 
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return temp;
	}
	
	public Employee findOne(int id) { //----------------THIS TOOK IN A STRING
		Employee temp = new Employee();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "select * from employee where employee_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			
			ps.setInt(1, id);//maybe needs to be changed to something else
			
			ResultSet info = ps.executeQuery();
						
			while(info.next()) {
				temp.setEmployee_id(info.getInt(1));
				temp.setEmp_username(info.getString(2));
				temp.setEmp_password(info.getString(3));
				temp.setFirst_name(info.getString(4));
				temp.setLast_name(info.getString(5));
				temp.setEmail(info.getString(6));
				temp.setEmp_role_id(info.getInt(7));
			} 
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return temp;
	}

	public Employee save(Employee a) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			conn.setAutoCommit(false);
			String sql = "insert into employee("
					+ "employee_id,emp_username,"
					+ "emp_password,"
					+ "first_name,"
					+ "last_name,"
					+ "email,"
					+ "emp_role_id"
					+ ") values("
					+ "?,?,?,?,?,?,?)";
			
			String[] keys = {"employee_ID"};
			
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setInt(1, a.getEmployee_id());
			ps.setString(2,  a.getEmp_username());
			ps.setString(3, a.getEmp_password());
			ps.setString(4, a.getFirst_name());
			ps.setString(5, a.getLast_name());
			ps.setString(6, a.getEmail());
			ps.setInt(7, a.getEmp_role_id());
			
			
			int rowsUpdated = ps.executeUpdate();
			if(rowsUpdated != 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					a.setEmployee_id(pk.getInt(1));
				}
				conn.commit(); //--------------commit is here for gen's code
			}			
//			conn.commit();		// --------------------was her for og project
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return a;
	}

	public Employee update(Employee obj) { //--------------------different than gen's

		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			conn.setAutoCommit(false);
			String sql = "update employee set "
//					+ "employee_id = ?,"
					+ "emp_username = ?,"
					+ "emp_password = ?,"
					+ "first_name = ?,"
					+ "last_name = ?,"
					+ "email = ?,"
					+ "emp_role_id = ?";
						
			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setInt(1, obj.getEmployee_id());
			ps.setString(1,  obj.getEmp_username());
			ps.setString(2, obj.getEmp_password());
			ps.setString(3, obj.getFirst_name());
			ps.setString(4, obj.getLast_name());
			ps.setString(5,  obj.getEmail());
			ps.setInt(6,  obj.getEmp_role_id());
			
			
			ps.executeUpdate();		
			conn.commit(); //				Gen's does not have this if/while
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return obj;
	}

	public void delete(Employee obj) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean isUnique(Employee obj) {
		String username = obj.getEmp_username();
		boolean exists = true;
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String query = "select * from employee where emp_username = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, username);
			
			ResultSet info = ps.executeQuery();
			System.out.println("in is unique");
			exists = info.next();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return !exists;
	}
	
	public static String getPasswordHash(Employee user) {
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement cs = conn.prepareStatement("SELECT get_user_hash(?,?) AS HASH from dual");
			cs.setString(++index, user.getEmp_username());
			cs.setString(++index, user.getEmp_password());
			ResultSet rs = cs.executeQuery();
			if (rs.next())
				return rs.getString("HASH");
		} catch (SQLException sql) {
			System.err.println("SQL State: " + sql.getSQLState());
			System.err.println("Error Code: " + sql.getErrorCode());
		}
		return null;
	}
	@Override
	public Employee findOne(String username) {
Employee temp = new Employee();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "select * from employee where emp_username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			
			ps.setString(1, username);//maybe needs to be changed to something else
			
			ResultSet info = ps.executeQuery();
						
			while(info.next()) {
				temp.setEmployee_id(info.getInt(1));
				temp.setEmp_username(info.getString(2));
				temp.setEmp_password(info.getString(3));
				temp.setFirst_name(info.getString(4));
				temp.setLast_name(info.getString(5));
				temp.setEmail(info.getString(6));
				temp.setEmp_role_id(info.getInt(7));
			} 
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return temp;
	}
	@Override
	public Employee resolveReimbursement(int r, int e, int s) {
		// TODO Auto-generated method stub
		return null;
	}

}
