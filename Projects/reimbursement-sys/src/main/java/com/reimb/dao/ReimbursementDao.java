package com.reimb.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.reimb.pojos.Reimbursement;
import com.reimb.pojos.Users;
import com.reimb.util.ConnectionFactory;

public class ReimbursementDao implements Dao<Reimbursement, Integer>{
	
	@Override
	public List<Reimbursement> getPast(Reimbursement obj) {
		List<Reimbursement> reimb = new ArrayList<Reimbursement>();

		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			//i need to get the pending 
			System.out.println("sql statement--> ");
			String sql = "select reimbursement_system.reimb_id, reimbursement_type.reimb_type, reimbursement_status.status, reimbursement_system.reimb_amount,\r\n" + 
					"    reimbursement_system.reimb_resolved, reimbursement_system.reimb_descrip, reimbursement_system.reimb_resolver\r\n" + 
					"FROM (((reimbursement_system\r\n" + 
					"INNER JOIN reimbursement_type ON reimbursement_system.reimb_type_id = reimbursement_type.reimb_type_id)\r\n" + 
					"INNER JOIN reimbursement_status ON reimbursement_system.status_type_id = reimbursement_status.status_type_id)\r\n" + 
					"INNER JOIN ers_users ON reimbursement_system.reimb_author = ers_users.users_id)\r\n" + 
					"WHERE (reimb_author = ? AND (reimbursement_system.status_type_id = 2 OR reimbursement_system.status_type_id = 1))";
			System.out.println("sql-->: ");
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, obj.getUsersid());
			ResultSet info = ps.executeQuery();
			while(info.next()){
				System.out.println("while loop-->: ");
				Reimbursement temp = new Reimbursement();
				temp.setReimbid(info.getInt(1));
				temp.setReimbtype(info.getString(3));
				temp.setStatus(info.getString(2));				
				temp.setAmt(info.getInt(4));
				temp.setResolved(info.getString(6));
				temp.setDescrip(info.getString(5));
				temp.setResolver(info.getInt(7));
			
				reimb.add(temp);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimb;
	}
	
	@Override
	public List<Reimbursement> findAll() {
		List<Reimbursement> reimb = new ArrayList<Reimbursement>();

		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			//i need to get the pending 
			String sql = "select reimbursement_system.reimb_id, reimbursement_type.reimb_type, reimbursement_status.status, reimbursement_system.reimb_amount,\r\n" + 
					"    reimbursement_system.reimb_submitted, reimbursement_system.reimb_descrip, ers_users.firstname, ers_users.lastname\r\n" + 
					"FROM (((reimbursement_system\r\n" + 
					"INNER JOIN reimbursement_type ON reimbursement_system.reimb_type_id = reimbursement_type.reimb_type_id)\r\n" + 
					"INNER JOIN reimbursement_status ON reimbursement_system.status_type_id = reimbursement_status.status_type_id)\r\n" + 
					"INNER JOIN ers_users ON reimbursement_system.reimb_author = ers_users.users_id)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet info = ps.executeQuery();
			
			while(info.next()){
				Reimbursement temp = new Reimbursement();
				temp.setReimbid(info.getInt(1));
				temp.setReimbtype(info.getString(2));
				temp.setStatus(info.getString(3));				
				temp.setAmt(info.getInt(4));
				temp.setSubmitted(info.getString(5));
				temp.setDescrip(info.getString(6));
				temp.setFname(info.getString(7));
				temp.setLname(info.getString(8));
				
				
				reimb.add(temp);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimb;
	}
	
	@Override
	public List<Reimbursement> getFnPend(Reimbursement obj) {
		
		System.out.println("dao--> " + obj.toString());
		
		List<Reimbursement> reimb = new ArrayList<Reimbursement>();

		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			//i need to get the pending 
			String sql = "select reimbursement_system.reimb_id, reimbursement_type.reimb_type, reimbursement_status.status, reimbursement_system.reimb_amount,\r\n" + 
					"    reimbursement_system.reimb_submitted, reimbursement_system.reimb_descrip, ers_users.firstname, ers_users.lastname\r\n" + 
					"FROM (((reimbursement_system\r\n" + 
					"INNER JOIN reimbursement_type ON reimbursement_system.reimb_type_id = reimbursement_type.reimb_type_id)\r\n" + 
					"INNER JOIN reimbursement_status ON reimbursement_system.status_type_id = reimbursement_status.status_type_id)\r\n" + 
					"INNER JOIN ers_users ON reimbursement_system.reimb_author = ers_users.users_id)\r\n" + 
					"WHERE (reimb_resolver = ? AND reimbursement_system.status_type_id = 3)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, obj.getUsersid());
			ResultSet info = ps.executeQuery();
			System.out.println("...");
			while(info.next()){
				System.out.println("while");
				Reimbursement temp = new Reimbursement();
				temp.setReimbid(info.getInt(1));
				temp.setReimbtype(info.getString(2));
				temp.setStatus(info.getString(3));				
				temp.setAmt(info.getInt(4));
				temp.setSubmitted(info.getString(5));
				temp.setDescrip(info.getString(6));
				temp.setFname(info.getString(7));
				temp.setLname(info.getString(8));
				reimb.add(temp);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimb;
	}
	
	@Override
	public List<Reimbursement> getPend(Reimbursement obj) {
		List<Reimbursement> reimb = new ArrayList<Reimbursement>();

		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			//i need to get the pending 
			String sql = "select reimbursement_type.reimb_type, reimbursement_system.reimb_amount, reimbursement_system.reimb_descrip, reimbursement_system.reimb_resolver,\r\n" + 
            		"    reimbursement_system.reimb_submitted, reimbursement_status.status\r\n" + 
            		"FROM ((reimbursement_system\r\n" + 
            		"INNER JOIN reimbursement_type ON reimbursement_system.reimb_type_id = reimbursement_type.reimb_type_id)\r\n" + 
            		"INNER JOIN reimbursement_status ON reimbursement_system.status_type_id = reimbursement_status.status_type_id)\r\n" + 
            		"WHERE (reimb_author = ? AND reimbursement_system.status_type_id = 3)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, obj.getUsersid());
			ResultSet info = ps.executeQuery();
			
			while(info.next()){
				Reimbursement temp = new Reimbursement();
				temp.setReimbtype(info.getString(1));
				temp.setAmt(info.getInt(2));
				temp.setDescrip(info.getString(3));				
				temp.setResolver(info.getInt(4));
				temp.setSubmitted(info.getString(5));
				temp.setStatus(info.getString(6));
				reimb.add(temp);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimb;
	}
	
	@Override
	public List<Reimbursement> findAll(Reimbursement obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Reimbursement saveAnother(Reimbursement obj) {
		  try(Connection conn = ConnectionFactory.getInstance().getConnection();){
	            conn.setAutoCommit(false);
	            
	            String query = "select reimbursement_type.reimb_type, reimbursement_system.reimb_amount, reimbursement_system.reimb_descrip, reimbursement_system.reimb_resolver,\r\n" + 
	            		"    reimbursement_system.reimb_submitted, reimbursement_status.status\r\n" + 
	            		"FROM ((reimbursement_system\r\n" + 
	            		"INNER JOIN reimbursement_type ON reimbursement_system.reimb_type_id = reimbursement_type.reimb_type_id)\r\n" + 
	            		"INNER JOIN reimbursement_status ON reimbursement_system.status_type_id = reimbursement_status.status_type_id)\r\n" + 
	            		"WHERE (reimb_author = ? AND reimbursement_system.status_type_id = 3);";

	            PreparedStatement ps = conn.prepareStatement(query);
	            ps.setInt(1, obj.getUsersid());

	            ps.executeQuery();
	            
	            conn.commit();


	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return obj;
	}
	@Override
	public Reimbursement save(Reimbursement obj) {
		 try(Connection conn = ConnectionFactory.getInstance().getConnection();){
	            conn.setAutoCommit(false);

	            CallableStatement cs = conn.prepareCall("{call reimbursement_sys_setup}");
	            
	            cs.executeQuery();
	            //should insert into the system the reimb_id and current_timestamp
	            //everything else will be null
	            
	            String query = "select users_id from ers_users where user_role_id = 3";
	            
	            PreparedStatement ps = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, 
                        ResultSet.CONCUR_UPDATABLE);
	            ResultSet users = ps.executeQuery();
	           
	            int count = 0;
	            while(users.next()) {
	            	++count;
	            }
	            
	            users.beforeFirst();
	            
	            Random rand = new Random();
	            
	            int n = rand.nextInt(count)+1;
	            
	            System.out.println(n);
	            
	            for(int i = 1; i <= n; i++) {
	            	
	            	users.next();
	            	obj.setResolver(users.getInt(1));
	            }
	            
	            obj.setReimbtypeid(obj.getType());
	            obj.setAuthor(obj.getUsersid());
	            System.out.println("Resolver: " + obj.getResolver());
	            System.out.println("author: " + obj.getAuthor());
	            System.out.println("Reimb type id: " + obj.getReimbtypeid());
	            System.out.println("Description: " + obj.getDescrip());
	            
	            cs = conn.prepareCall("{call reimbursement_sys_setup2 (?, ?, ?, ?, ?, ?)}");

	            cs.setInt(1, obj.getReimbtypeid());
	            cs.setInt(2, 3);
	            cs.setInt(3, obj.getAmt());
	            cs.setString(4, obj.getDescrip());
	            cs.setInt(5, obj.getAuthor());
	            cs.setInt(6, obj.getResolver());
	            
	            cs.executeUpdate(); 	
	            
	            conn.commit();
	            


	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return obj;
	}


	@Override
	public Reimbursement findOne(Reimbursement obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
            conn.setAutoCommit(false);
            String query = "update reimbursement_system"
            		+ " SET status_type_id = ?, reimb_resolved = CURRENT_TIMESTAMP"
            		+ " WHERE reimb_id = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, obj.getStatustypeid());
            ps.setInt(2, obj.getReimbid());
            ps.executeQuery();
            
            conn.commit();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
	}
	
	@Override
	public Reimbursement findPw(Reimbursement obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement insert(Reimbursement obj) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Reimbursement update(Reimbursement obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Reimbursement obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Reimbursement> getAll(Reimbursement obj) {
		// TODO Auto-generated method stub
		return null;
	}



}
