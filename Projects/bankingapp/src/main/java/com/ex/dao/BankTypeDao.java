package com.ex.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ex.main.App;
import com.ex.pojos.BankType;
import com.ex.util.ConnectionFactory;

public class BankTypeDao implements DAO<BankType, Integer> {
	
	public BankType update(BankType d) {
		
		PreparedStatement stmt = null;
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			  conn.setAutoCommit(false);
			  
			  //This deposits money into their checking account
			  if((d.getBank_type() == 1) && (d.getAction() == 2)){
				  
			      stmt = conn.prepareStatement("SELECT checkid FROM banksystem"
			      		+ " WHERE firstname = ?");
			      
			      stmt.setString(1,  d.getFirstname());
	
			      ResultSet rs = stmt.executeQuery();
			      
			      rs.next();
			      
			      int check_id = rs.getInt(1);
			      
			      /*stmt = conn.prepareStatement("UPDATE checking SET balance = ?"
			      		+ " WHERE checkid = ?");*/
			      
			      stmt = conn.prepareStatement("SELECT balance FROM checking"
			      		+ " WHERE checkid = ?");
			      
			      stmt.setInt(1, check_id);
			      
			      rs = stmt.executeQuery();
			      
			      rs.next();
			      
			      BigDecimal current_amount = rs.getBigDecimal(1);
			      
			      current_amount = current_amount.add(d.getAmount());
			      
			      stmt = conn.prepareStatement("UPDATE checking SET balance = ?"
			      		+ " WHERE checkid = ?");
			      
			      stmt.setBigDecimal(1, current_amount);
			      stmt.setInt(2, check_id);
			      rs = stmt.executeQuery();
			      
			      stmt = conn.prepareStatement("SELECT balance, lastupdated "
			      		+ "FROM checking WHERE "
			      		+ "checkid = ?");
			      
			      stmt.setInt(1, check_id);
			      rs = stmt.executeQuery();
			      rs.next();
			      
			      System.out.println("Your current checking balance is: $"
			      		+ rs.getBigDecimal(1) + " \nLast-Updated: " + rs.getDate(2));
			      
			      rs.close();
			      stmt.close();
			      
			  //This deposits money into their savings account
			  } else if((d.getBank_type() == 2) && (d.getAction() == 2)) {
				  stmt = conn.prepareStatement("SELECT saveid FROM banksystem"
				      		+ " WHERE firstname = ?");
				      
				      stmt.setString(1,  d.getFirstname());
		
				      ResultSet rs = stmt.executeQuery();
				      
				      rs.next();
				      
				      int save_id = rs.getInt(1);
				      
				      stmt = conn.prepareStatement("SELECT balance FROM saving"
				      		+ " WHERE saveid = ?");
				      
				      stmt.setInt(1, save_id);
				      
				      rs = stmt.executeQuery();
				      
				      rs.next();
				      
				      BigDecimal current_amount = rs.getBigDecimal(1);
				      
				      current_amount = current_amount.add(d.getAmount());
				      
				      stmt = conn.prepareStatement("UPDATE saving SET balance = ?"
				      		+ " WHERE saveid = ?");
				      
				      stmt.setBigDecimal(1, current_amount);
				      stmt.setInt(2, save_id);
				      rs = stmt.executeQuery();
				      
				      stmt = conn.prepareStatement("SELECT balance, lastupdated "
				      		+ "FROM saving WHERE "
				      		+ "saveid = ?");
				      
				      stmt.setInt(1, save_id);
				      rs = stmt.executeQuery();
				      rs.next();
				      
				      System.out.println("Your current saving balance is: $"
				      		+ rs.getBigDecimal(1) + " \nLast-Updated: " + rs.getDate(2));
				      
				      rs.close();
				      stmt.close();
				      
			  } else if((d.getBank_type() == 1) && (d.getAction() == 1)) {
				  //WITHDRAWS FROM CHECKING
				  stmt = conn.prepareStatement("SELECT checkid FROM banksystem"
				      		+ " WHERE firstname = ?");
				      
				      stmt.setString(1,  d.getFirstname());
		
				      ResultSet rs = stmt.executeQuery();
				      
				      rs.next();
				      
				      int check_id = rs.getInt(1);
				      
				      stmt = conn.prepareStatement("SELECT balance FROM checking"
				      		+ " WHERE checkid = ?");
				      
				      stmt.setInt(1, check_id);
				      
				      rs = stmt.executeQuery();
				      
				      rs.next();
				      
				      BigDecimal current_amount = rs.getBigDecimal(1);
				      
				      while(current_amount.compareTo(d.getAmount()) == -1) {
				    	  System.out.println("\n"
				    	  		+ "The amount you're trying to withdraw\n"
				    	  		+ "is more than your current balance.");
				    	  System.out.println("Enter new amount: ");
				    	  d.setAmount((App.scanner.nextBigDecimal()));
				      }
				      
				      current_amount = current_amount.subtract(d.getAmount());
				      
				      stmt = conn.prepareStatement("UPDATE checking SET balance = ?"
				      		+ " WHERE checkid = ?");
				      
				      stmt.setBigDecimal(1, current_amount);
				      stmt.setInt(2, check_id);
				      rs = stmt.executeQuery();
				      
				      stmt = conn.prepareStatement("SELECT balance, lastupdated "
				      		+ "FROM checking WHERE "
				      		+ "checkid = ?");
				      
				      stmt.setInt(1, check_id);
				      rs = stmt.executeQuery();
				      rs.next();
				      
				      System.out.println("Your current checking balance is: $"
				      		+ rs.getBigDecimal(1) + " \nLast-Updated: " + rs.getDate(2));
				      
				      rs.close();
				      stmt.close();
				      
			  }else if((d.getBank_type() == 2) && (d.getAction() == 1)) {
				  stmt = conn.prepareStatement("SELECT saveid FROM banksystem"
				      		+ " WHERE firstname = ?");
				      
				      stmt.setString(1,  d.getFirstname());
		
				      ResultSet rs = stmt.executeQuery();
				      
				      rs.next();
				      
				      int save_id = rs.getInt(1);
				      
				      stmt = conn.prepareStatement("SELECT balance FROM saving"
				      		+ " WHERE saveid = ?");
				      
				      stmt.setInt(1, save_id);
				      
				      rs = stmt.executeQuery();
				      
				      rs.next();
				      
				      BigDecimal current_amount = rs.getBigDecimal(1);
				      
				      while(current_amount.compareTo(d.getAmount()) == -1){
				    	  System.out.println("\n"
				    	  		+ "The amount you're trying to withdraw\n"
				    	  		+ "is more than your current balance.");
				    	  System.out.println("Enter new amount: ");
				    	  d.setAmount(App.scanner.nextBigDecimal());
				      }
				      
				      current_amount = current_amount.subtract(d.getAmount());
				      
				      stmt = conn.prepareStatement("UPDATE saving SET balance = ?"
				      		+ " WHERE saveid = ?");
				      
				      stmt.setBigDecimal(1, current_amount);
				      stmt.setInt(2, save_id);
				      rs = stmt.executeQuery();
				      
				      stmt = conn.prepareStatement("SELECT balance, lastupdated "
				      		+ "FROM saving WHERE "
				      		+ "saveid = ?");
				      
				      stmt.setInt(1, save_id);
				      rs = stmt.executeQuery();
				      rs.next();
				      
				      System.out.println("Your current savings balance is: $"
				      		+ rs.getBigDecimal(1) + " \nLast-Updated: " + rs.getDate(2));
				      
				      rs.close();
				      stmt.close();
				     
			  }
		      
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }
		
		return d;
	}
	
	public BankType findOne(BankType sum) {
			
			PreparedStatement stmt = null;
			
			try(Connection conn = ConnectionFactory.getInstance().getConnection()){
				
				  conn.setAutoCommit(false);
				  
				  if(sum.getBank_type() == 1) {

					  stmt = conn.prepareStatement("SELECT accountid FROM login"
						  		+ " WHERE username = ?");
						  
					      stmt.setString(1, sum.getUsername());
					      
						  ResultSet rs = stmt.executeQuery();
						  
					      rs.next();
					      
					      int account_id = rs.getInt(1);
					      
					      stmt = conn.prepareStatement("SELECT checkid FROM banksystem"
					      		+ " WHERE accountid = ?");
					      
					      stmt.setInt(1, account_id);
					      
					      rs = stmt.executeQuery();
					      
					      rs.next();
					      
					      int check_id = rs.getInt(1);
					    
					      stmt = conn.prepareStatement("SELECT * FROM checking"
					      		+  " WHERE checkid = ?");
					      
					      stmt.setInt(1, check_id);
					      
					      rs = stmt.executeQuery();
					      
					      rs.next();
					      
					      System.out.println("CHECKID: " +
					      rs.getInt(1) + "\nBALANCE: $" +
					    		  rs.getDouble(2) + "\nLAST UPDATED: "
					    		  + rs.getDate(3));
					      
					      rs.close();
					      stmt.close();
					      
				  } else if(sum.getBank_type() == 2) {
					  stmt = conn.prepareStatement("SELECT accountid FROM login"
						  		+ " WHERE username = ?");
						  
					      stmt.setString(1, sum.getUsername());
					      
						  ResultSet rs = stmt.executeQuery();
						  
					      rs.next();
					      
					      int account_id = rs.getInt(1);
					      
					      stmt = conn.prepareStatement("SELECT saveid FROM banksystem"
					      		+ " WHERE accountid = ?");
					      
					      stmt.setInt(1, account_id);
					      
					      rs = stmt.executeQuery();
					      
					      rs.next();
					      
					      int save_id = rs.getInt(1);
					    
					      stmt = conn.prepareStatement("SELECT * FROM saving"
					      		+  " WHERE saveid = ?");
					      
					      stmt.setInt(1, save_id);
					      
					      rs = stmt.executeQuery();
					      
					      rs.next();
					      
					      System.out.println("SAVEID: " +
					      rs.getInt(1) + "\nBALANCE: $" +
					    		  rs.getDouble(2) + "\nLAST UPDATED: "
					    		  + rs.getDate(3));
					      
					      rs.close();
					      stmt.close();
				  } else if(sum.getBank_type() == 3) {
					  
					  stmt = conn.prepareStatement("SELECT accountid FROM login"
						  		+ " WHERE username = ?");
						  
					      stmt.setString(1, sum.getUsername());
					      
						  ResultSet rs = stmt.executeQuery();
						  
					      rs.next();
					      
					      int account_id = rs.getInt(1);
					      
					      stmt = conn.prepareStatement("SELECT checkid FROM banksystem"
					      		+ " WHERE accountid = ?");
					      
					      stmt.setInt(1, account_id);
					      
					      rs = stmt.executeQuery();
					      
					      rs.next();
					      
					      int check_id = rs.getInt(1);
					      
					      
					  stmt = conn.prepareStatement("SELECT checking.checkid,"
					  		+ " checking.balance, saving.saveid, saving.balance"
					  		+ " FROM checking INNER JOIN saving ON "
					  		+ "checking.lastupdated = saving.lastupdated"
					  		+ " WHERE checkid = ?");
					  
					  stmt.setInt(1, check_id);
					  
					  rs = stmt.executeQuery();
					  
					  rs.next();
					  
					  System.out.println("CHECKID: " + rs.getInt(1) + "\n"
					  + "CHECKING BALANCE: $" + rs.getDouble(2) + "\n"
					  + "\nSAVEID: " + rs.getInt(3) + "\n" 
					  + "SAVINGS BALANCE: $" + rs.getDouble(4));
					  
				  }
			} catch (SQLException e) {
				System.out.println("invalid.");
			}
			
			return sum;
	}
	
	
	@Override
	public List<BankType> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankType findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankType insert(BankType obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankType save(BankType obj) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void delete(BankType obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BankType insert(String username, String password, String firstname, String lastname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankType findPw(BankType obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
