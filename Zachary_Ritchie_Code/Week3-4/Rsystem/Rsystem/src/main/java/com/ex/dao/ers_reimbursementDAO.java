package com.ex.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ex.pojos.ers_reimbursement;
import com.ex.util.ConnectionFactory;

import oracle.jdbc.OracleTypes;

public class ers_reimbursementDAO implements DAO<ers_reimbursement , Integer>
{

	@Override
	public List<ers_reimbursement> getAll() 
	{
		List<ers_reimbursement > ers = new ArrayList<ers_reimbursement>();
		
		String sql = "{call get_all_ers_reimbursement(?)}";
		
		try(Connection c = ConnectionFactory.getInstance().getConnection())
		{
			
			//String query = "select * fron accounts";
			//Statement statement = c.createStatement();
			//ResultSet rs = statement.executeQuery(query);
			CallableStatement cs = c.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();			
			ResultSet rs = (ResultSet)cs.getObject(1);
			
			
			while(rs.next())
			{
				ers_reimbursement  temp = new ers_reimbursement();
				temp.setReimb_id(rs.getInt("reimb_id"));
				temp.setReimb_amount(rs.getDouble("reimb_amount"));
				temp.setReimb_submitted(rs.getString("reimb_submitted"));
				temp.setReimb_resolved(rs.getString("reimb_resolved"));
				temp.setReimb_description(rs.getString("reimb_description"));
				temp.setReimb_receipt(rs.getBlob("reimb_receipt"));
				temp.setReimb_author(rs.getInt("reimb_author"));
				temp.setReimb_resolver(rs.getInt("reimb_resolver"));
				temp.setReimb_status_id(rs.getInt("reimb_status_id"));
				temp.setReimb_type_id(rs.getInt("reimb_type_id"));
				ers.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return ers;	
	}

	@Override
	public ers_reimbursement findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ers_reimbursement save(ers_reimbursement obj) 
	{
		
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			conn.setAutoCommit(false);
			
			String sql = "insert into ers_reimbursement(reimb_amount, reimb_description, reimb_receipt, reimb_author, reimb_status_id, reimb_type_id) values(?, ?, ?, ?, ?, ?)";
			
			String[] keys = {"reimb_id"};
			
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setDouble(1, obj.getReimb_amount());
			ps.setString(2, obj.getReimb_description());
			ps.setBlob(3, obj.getReimb_receipt());
			ps.setInt(4, obj.getReimb_author());
			ps.setInt(5, obj.getReimb_status_id());
			ps.setInt(6, obj.getReimb_type_id());
			
			ps.executeUpdate();
			
			/*int numsRowsAffected = ps.executeUpdate();
			
			if(numsRowsAffected > 0)
			{
				ResultSet pk = ps.getGeneratedKeys();
				
				while(pk.next()) 
				{
					obj.setReimb_id(pk.getInt(1));
				}
			}*/
			
			conn.commit();			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return obj;
	}

	@Override
	public ers_reimbursement update(ers_reimbursement obj)
	{
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			conn.setAutoCommit(false);
			String sql = "update ers_reimbursement set reimb_resolver = ?, reimb_status_id = ? where reimb_id = ?";
			
			String[] keys = {"reimb_id"};
			
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setInt(1, obj.getReimb_resolver());
			ps.setInt(2, obj.getReimb_status_id());
			ps.setInt(3, obj.getReimb_id());
			ps.executeQuery();
			conn.commit();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean isUnique(ers_reimbursement obj) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
