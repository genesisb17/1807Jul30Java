package com.revature.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.List;

import com.revature.helpers.HelperFunctions;
import com.revature.pojos.Tickets;
import com.revature.pojos.User;
import com.revature.util.ConnectionFactory;

public class TicketDao extends HelperFunctions implements Dao<Tickets, Integer> {

	@Override
	public List<Tickets> getAllOfUser(Integer userId) {
		
		List<Tickets> ticketsList = new ArrayList<Tickets>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
//			String select_query = "select * from ers_reimbursement";
			
			String select_query = "SELECT ers_users.user_first_name, ers_users.user_last_name , ers_reimbursement.reimb_amount, ers_reimbursement.reimb_submitted, " + 
					"ers_reimbursement.reimb_resolved, ers_reimbursement.reimb_description, ers_reimbursement_status.reimb_status " + 
					"FROM ((ers_users " + 
					"INNER JOIN ers_reimbursement ON ers_users.ers_users_id = ers_reimbursement.reimb_author) " + 
					"INNER JOIN ers_reimbursement_status ON ers_reimbursement.reimb_status_id = ers_reimbursement_status.reimb_status_id) " + 
					"WHERE ers_users.ers_users_id = " + userId.toString() + " " +
					"order by reimb_id desc";
			
			ResultSet selectRS = conn.createStatement().executeQuery(select_query);
			
			while(selectRS.next()) {
				Tickets tickets = new Tickets(selectRS.getString(1),
											  selectRS.getString(2),
											  selectRS.getDouble(3),
											  selectRS.getString(4),
											  selectRS.getString(5),
											  selectRS.getString(6),
											  selectRS.getString(7)
											  );
				ticketsList.add(tickets);
				System.out.println(tickets);
						
			}							  
		} catch(SQLException e) {
				e.printStackTrace();
		}
			
		return ticketsList;
		
	}
	
	@Override
	public List<Tickets> getAll() {
		
		List<Tickets> ticketsList = new ArrayList<Tickets>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
//			String select_query = "select * from ers_reimbursement";
			
			String select_query = "SELECT ers_users.ers_users_id, ers_reimbursement.reimb_id, ers_reimbursement_status.reimb_status_id, ers_users.user_first_name, ers_users.user_last_name , ers_reimbursement.reimb_amount, ers_reimbursement.reimb_submitted, " + 
					"ers_reimbursement.reimb_resolved, ers_reimbursement.reimb_description, ers_reimbursement_status.reimb_status " + 
					"FROM ((ers_users " + 
					"INNER JOIN ers_reimbursement ON ers_users.ers_users_id = ers_reimbursement.reimb_author) " + 
					"INNER JOIN ers_reimbursement_status ON ers_reimbursement.reimb_status_id = ers_reimbursement_status.reimb_status_id) " + 
					//"WHERE ers_users.ers_users_id = 1 " +
					"order by reimb_id desc";
			
			ResultSet selectRS = conn.createStatement().executeQuery(select_query);
			
			while(selectRS.next()) {
				
				Tickets tickets = new Tickets(
												  selectRS.getInt(1), //userid
												  selectRS.getInt(2), //reimb_id
												  selectRS.getInt(3), //reimb_status_id
												  selectRS.getString(4),
												  selectRS.getString(5),
												  selectRS.getDouble(6),
												  selectRS.getString(7),
												  selectRS.getString(8),
												  selectRS.getString(9),
												  selectRS.getString(10)
						  						);
				
//				Tickets tickets = new Tickets(selectRS.getString(1),
//											  selectRS.getString(2),
//											  selectRS.getDouble(3),
//											  selectRS.getString(4),
//											  selectRS.getString(5),
//											  selectRS.getString(6),
//											  selectRS.getString(7)
//											  );
				ticketsList.add(tickets);
				System.out.println(tickets);
						
			}							  
		} catch(SQLException e) {
				e.printStackTrace();
		}
			
		return ticketsList;
	}

	@Override
	public Tickets findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tickets save(Tickets obj) {
		
		System.out.println("im finally in the Ticket Save Dao++++++");
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			conn.setAutoCommit(false);
			/*String query = "insert into ers_reimbursement " +
					"(REIMB_AMOUNT, REIMB_SUBMITTED, REIMB_RESOLVED, REIMB_DESCRIPTION, REIMB_RECEIPT, REIMB_AUTHOR, REIMB_RESOLVER, REIMB_STATUS_ID, REIMB_TYPE_ID)" +
					"values " +
					"( ?, ?, ?, ?, ?, ?, ?, ?, ? )";*/
			
			String query = "insert into ers_reimbursement " +
					"(REIMB_AMOUNT, REIMB_RESOLVED, REIMB_DESCRIPTION, REIMB_RECEIPT, REIMB_AUTHOR, REIMB_RESOLVER, REIMB_STATUS_ID, REIMB_TYPE_ID)" +
					"values " +
					"( ?, ?, ?, ?, ?, ?, ?, ? )";
	
			String[] autogen_keys = {"reimb_id"};
			PreparedStatement ps = conn.prepareStatement(query, autogen_keys);

			
			// REIMB_AMOUNT
			ps.setDouble(1, obj.getCash());
//			ps.setString(2, obj.getSubmit());	// timestamp need to tell db to TimeStamp
			
			// REIMB_RESOLVED
			ps.setTimestamp(2, null);	// timestamp should be null
			
			// REIMB_DESCRIPTION
			ps.setString(3, obj.getDescription());
			
			// REIMB_RECEIPT
			ps.setString(4, null);		// want to set to null
			
			// REIMB_AUTHOR
			ps.setInt(5, obj.getUserId());
			
			// REIMB_RESOLVER
			ps.setString(6, null);			// want to set to null (person who resolves)	
			
			// REIMB_STATUS_ID
			ps.setInt(7, 1);
			
			// REIMB_TYPE_ID
			ps.setInt(8, obj.getType());
			
			int rowsInserted = ps.executeUpdate();

			System.out.println("rowsInserted -> " + rowsInserted);
			System.out.println(obj.toString());
			
			if (rowsInserted > 0) {
				
				System.out.println("Inserted rows: " + rowsInserted);
				
				// Get id genereated from db and add it (set it) to object id.
				ResultSet rsGenKeys = ps.getGeneratedKeys();
				
//				while (rsGenKeys.next()) {
//					
//					print("=====>");
//					print(rsGenKeys.getObject(1));
//					print(rsGenKeys.getInt(1));
//					
//					print(rsGenKeys.toString());
//					obj.setUserId(rsGenKeys.getInt(1));
//					
//				}
				
				conn.commit();
				
			}
			
		} 
//		catch (SQLSyntaxErrorException ssee) {
////			ssee.printStackTrace();
//			print("\n--- Something occured -> ");
//			
//			if (ssee.getMessage().contains("Could not commit with auto-commit set on")) {
//				print("\t" + ssee.getMessage() + "    Data was added, but there was a problem, though...");
//			} else {
//				print("\t" + ssee.getMessage() + "    DATA WAS NOT ADDED\n");
//			}
//		}
//			catch (SQLException se) {
////			e.printStackTrace();ssee.printStackTrace();
//			print("\n--- Something occured -> ");
//			print("\t" + se.getMessage() + "    DATA WAS NOT ADDED\n");
//		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("here ");
		
		return obj;
			
	}

	@Override
	public Tickets update(Tickets obj) {
	
		System.out.println("We are in the update dao");
		System.out.println(obj.toString());
		
		////////////////////////////////////////////////

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			PreparedStatement preparedStatement = null;

			String updateSql = "update ers_reimbursement " + 
							   "set reimb_resolved = CURRENT_TIMESTAMP, " + 
							   "    reimb_resolver = ?, " + 
							   "    reimb_status_id = ? " + 
							   "where reimb_id = ?";

			preparedStatement = conn.prepareStatement(updateSql);

			preparedStatement.setInt(1, obj.getUserId());
			preparedStatement.setInt(2, obj.getStatusId());
			preparedStatement.setInt(3, obj.getTicketId());

			// execute update SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("Record is updated to ers_reimbursement table!");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		////////////////////////////////////////////////
		
		
		return obj;
	}

	@Override
	public boolean isUnique(Tickets obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Tickets findPw(Tickets obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tickets findOne(Tickets obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tickets insert(Tickets obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Tickets obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findOne(String s) {
		// TODO Auto-generated method stub
		return null;
	}


}
