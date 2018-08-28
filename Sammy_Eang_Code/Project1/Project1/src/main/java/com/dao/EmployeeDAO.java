package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connectionfactory.ConnectionFactory;
import com.pojo.EmployeePOJO;
import com.pojo.EmployeeRolesPOJO;
import com.pojo.ReimbursementTypePOJO;

public class EmployeeDAO {

	//Finds all employees and stores in list. Passes back
	public List<EmployeePOJO> findAll() {
			
			List<EmployeePOJO> employees = new ArrayList<EmployeePOJO>();
			
			try(Connection conn = ConnectionFactory.getInstance().getConnection()){
				
				String query = "select * from employees order by emp_id";
				Statement statement = conn.createStatement();
				ResultSet rs = statement.executeQuery(query);
				
				while(rs.next()) {
					EmployeePOJO temp = new EmployeePOJO();
					temp.setEmp_id(rs.getInt(1));
					temp.setUsername(rs.getString(2));
					temp.setPw(rs.getString(3));
					temp.setFirst_name(rs.getString(4));
					temp.setLast_name(rs.getString(5));
					temp.setEmail(rs.getString(6));
					temp.setUser_role_id(rs.getInt(7));
					employees.add(temp);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return employees;
		}
	
	//Finds employees by username and returns them
	public EmployeePOJO findOne(String username){
		EmployeePOJO temp = null;
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
	
			String sql = "select * from employees where username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery( );
			
		while(rs.next()) {
				temp = new EmployeePOJO();
				temp.setEmp_id(rs.getInt(1));
				temp.setUsername(rs.getString(2));
				temp.setPw(rs.getString(3));
				temp.setFirst_name(rs.getString(4));
				temp.setLast_name(rs.getString(5));
				temp.setEmail(rs.getString(6));
				temp.setUser_role_id(rs.getInt(7));
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}

	//Shouldn't need save since you don't need to add employees
	//Shouldn't need update since you can't demote managers or promote employees
	
	//Here are all the less useful Daos
	public List<EmployeeRolesPOJO> findAllRoles() {
		
		List<EmployeeRolesPOJO> roles = new ArrayList<EmployeeRolesPOJO>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			String query = "select * from user_roles";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				EmployeeRolesPOJO temp = new EmployeeRolesPOJO();
				temp.setEmp_role_id(rs.getInt(1));
				temp.setEmp_role(rs.getString(2));
				roles.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roles;
	}
	
}
