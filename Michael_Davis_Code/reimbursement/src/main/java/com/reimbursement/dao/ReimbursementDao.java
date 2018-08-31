package com.reimbursement.dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.reimbursement.pojos.Reimbursement;
import com.reimbursement.pojos.User;
import com.reimbursement.pojos.Reimbursement;

import util.connectionFactory;
public class ReimbursementDao implements Dao<Reimbursement, Integer> {

	public List<Reimbursement> getUserReimbs(int id) {
		List<Reimbursement> Reimbursements = new ArrayList<Reimbursement>();
		try(Connection conn = connectionFactory.getInstance().getConnection();){
			//String query = "select * from ERS_Reimbursement";
			
			String query = "select * from ERS_Reimbursement where Author = ?";
			//PreparedStatement ps = conn.prepareStatement(query);
		
			PreparedStatement prep=conn.prepareStatement(query);
			prep.setInt(1, id);
			ResultSet rs=prep.executeQuery();
			while(rs.next()) {		
				Reimbursement temp = new Reimbursement();
				temp.setId(rs.getInt(1));
				temp.setAmount(rs.getInt(2));
				temp.setSubmittedTime(rs.getTimestamp(3));
				temp.setResolvedTime(rs.getTimestamp(4));
				temp.setDescription(rs.getString(5));
				temp.setReceipt(rs.getBlob(6));
				temp.setAuthor(rs.getInt(7));
				temp.setResolver(rs.getInt(8));
				temp.setStatusid(rs.getInt(9));
				temp.setTypeid(rs.getInt(10));
				Reimbursements.add(temp);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Reimbursements;
	}
	
	@Override
	public List<Reimbursement> getAll() {
		List<Reimbursement> Reimbursements = new ArrayList<Reimbursement>();
		try(Connection conn = connectionFactory.getInstance().getConnection();){
			String query = "select * from ERS_Reimbursement";
			PreparedStatement prep=conn.prepareStatement(query);
			ResultSet rs=prep.executeQuery();
			while(rs.next()) {		
				Reimbursement temp = new Reimbursement();
				temp.setId(rs.getInt(1));
				temp.setAmount(rs.getInt(2));
				temp.setSubmittedTime(rs.getTimestamp(3));
				temp.setResolvedTime(rs.getTimestamp(4));
				temp.setDescription(rs.getString(5));
				temp.setReceipt(rs.getBlob(6));
				temp.setAuthor(rs.getInt(7));
				temp.setResolver(rs.getInt(8));
				temp.setStatusid(rs.getInt(9));
				temp.setTypeid(rs.getInt(10));
				Reimbursements.add(temp);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Reimbursements;
	}

	@Override
	public Reimbursement findOne(Integer id) {
		Reimbursement Reimbursement = new Reimbursement();

		try(Connection conn = connectionFactory.getInstance().getConnection()){

			String sql = "select * from ERS_Reimbursement where ReimbID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info= ps.executeQuery();

			while(info.next()){
				
				Reimbursement.setId(info.getInt(1));
				Reimbursement.setAmount(info.getInt(2));
				Reimbursement.setSubmittedTime(info.getTimestamp(3));
				Reimbursement.setResolvedTime(info.getTimestamp(4));
				Reimbursement.setDescription(info.getString(5));
				Reimbursement.setReceipt(info.getBlob(6));
				Reimbursement.setAuthor(info.getInt(7));
				Reimbursement.setResolver(info.getInt(8));
				Reimbursement.setStatusid(info.getInt(9));
				Reimbursement.setTypeid(info.getInt(10));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Reimbursement;
	}
	
	public Reimbursement addReceipt(Reimbursement a,Blob b) {
		try(Connection conn = connectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String query = "update ERS_Reimbursement set Receipt = ? WHERE ReimbId = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setBlob(1, b);
			ps.setInt(2, a.getId());
			
			 ps.executeUpdate();
			 conn.commit();
			 
		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public void setResolver(int a,User b) {
		try(Connection conn = connectionFactory.getInstance().getConnection();){
			//conn.setAutoCommit(false);
			String query = "update ERS_Reimbursement set Resolver = ? WHERE ReimbId = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, b.getUserid());
			ps.setInt(2,a);
			
			 ps.executeUpdate();
		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void setStatus(int status,int reimbursementid) {
		try(Connection conn = connectionFactory.getInstance().getConnection();){
			//conn.setAutoCommit(false);
			String query = "update ERS_Reimbursement set statusId = ? WHERE ReimbId = ?";
			
			String query2 = "update ERS_Reimbursement set resolved = ? WHERE ReimbId = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			PreparedStatement ps2 = conn.prepareStatement(query2);
			ps.setInt(1, status);
			ps.setInt(2, reimbursementid);
			
			Timestamp ttt=new Timestamp(System.currentTimeMillis());
			Date date=new Date();
			
			ps2.setTimestamp(1,new Timestamp(date.getTime()));
			ps2.setInt(2, reimbursementid);

			 ps.executeUpdate();
			 ps2.executeUpdate();
		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		//return a;
	}
	

	

	@Override
	public Reimbursement save(Reimbursement obj) {
Reimbursement reimbursement = new Reimbursement();
		
		try(Connection conn = connectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String query = "insert into ERS_Reimbursement(amount,submitted,resolved,description,receipt,author,resolver,statusid,typeid)"
					+ "values(?,?,?,?,?,?,?,?,?)";
			
			 
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		
		 
		 Date date = new Date();
		 
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setDouble(1, obj.getAmount());
			ps.setTimestamp(2, new Timestamp(date.getTime()));
			ps.setTimestamp(3, null);
			ps.setString(4, obj.getDescription());
			ps.setBlob(5, obj.getReceipt());
			ps.setInt(6, obj.getAuthor());
			ps.setInt(7, obj.getResolver());
			ps.setInt(8, obj.getStatusid());
			ps.setInt(9, obj.getTypeid());
			
			int rows = ps.executeUpdate();
			
			if(rows != 0) {
				//ResultSet pk = ps.getGeneratedKeys();
				//while(pk.next()) {
				//	reimbursement.setId(pk.getInt(1));
			//	}
				
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursement;
	}

	@Override
	public Reimbursement update(Reimbursement obj) {
		try(Connection conn = connectionFactory.getInstance().getConnection();){
			//conn.setAutoCommit(false);
			
			String query = "update ERS_Reimbursement set amount = ?,submitted = ?, resolved=?, description = ?,receipt=?,author=?,resolver=?,statusid=?,typeid=?"
					+ " WHERE ReimbId = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setDouble(1, obj.getAmount());
			ps.setTimestamp(2, obj.getSubmittedTime());
			ps.setTimestamp(3, obj.getResolvedTime());
			ps.setString(4, obj.getDescription());
			ps.setBlob(5, obj.getReceipt());
			ps.setInt(6, obj.getAuthor());
			ps.setInt(7, obj.getResolver());
			ps.setInt(8, obj.getStatusid());
			ps.setInt(9, obj.getTypeid());
			ps.setInt(10, obj.getId());
			
			
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public boolean isUnique(Reimbursement obj) {
		int id = obj.getId();
		boolean exists = true;
		try(Connection conn = connectionFactory.getInstance().getConnection();){
			String query = "select * from ERS_Reimbursement where ReimbId = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, id);
			
			ResultSet info = ps.executeQuery();
			System.out.println("in is unique");
			exists = info.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return !exists;
	}
	public String getResolverName(int a) {
		String name="Default Test";
		
		try(Connection conn = connectionFactory.getInstance().getConnection();){
			String query="select * from ERS_USERS where Userid=? ";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, a);
			
			ResultSet info = ps.executeQuery();
			info.next();
			name=info.getString(2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return name;
	}
	
	public String getAuthorName(int a) {
		
		String name="";
		try(Connection conn = connectionFactory.getInstance().getConnection();){
			String query="select * from ERS_USERS where Userid=? ";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, a);
			
			ResultSet info = ps.executeQuery();	
			while(info.next()) {
			
			name=info.getString(2);
		}
			System.out.println("name is :"+name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Name right before return: "+name);
		
		return name;
	}
	
	public String getStatusName(Reimbursement obj) {
		String name="Default Test";
		
		try(Connection conn = connectionFactory.getInstance().getConnection();){
			String query="select * from ERS_Reimbursement_Status where Reimb_Status_ID=? ";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, obj.getStatusid());
			
			ResultSet info = ps.executeQuery();
			
			name=info.getString(2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return name;
	}
	public String getTypeName(Reimbursement obj) {
		String name="Default Test";
		
		try(Connection conn = connectionFactory.getInstance().getConnection();){
			String query="select * from ERS_Reimbursement_Type where Reimb_Type_ID=? ";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, obj.getTypeid());
			
			ResultSet info = ps.executeQuery();
			
			name=info.getString(2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return name;
	}

}
