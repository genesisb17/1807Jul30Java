package com.bank.dao;

import java.awt.Window.Type;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.bank.pojo.Account;
import com.bank.util.ConnectionFactory;

import oracle.jdbc.internal.OracleTypes;

public class AccountDao {
	Account a = null;
	/*Display users accounts on login based on the provided credentials. this handles my login logic and if 
	 * either the uname or password is messed up there will be no results 
	 * retrieved and will re prompt the user
	 */
	public List<Account> findAccounts(String uname) {
		Account a = null;
		List<Account> accnts = new ArrayList<Account>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT USER_ACCOUNTS.UA_ID, ACCOUNT_TYPE.TYPE, USER_ACCOUNTS.AMOUNT FROM USERS INNER JOIN USER_ACCOUNTS ON USERS.U_ID=USER_ACCOUNTS.U_ID INNER JOIN USER_ACCOUNT_TYPE ON USER_ACCOUNTS.UA_ID=USER_ACCOUNT_TYPE.UA_ID INNER JOIN ACCOUNT_TYPE ON USER_ACCOUNT_TYPE.A_ID=ACCOUNT_TYPE.A_ID WHERE UPPER(USERS.UNAME) = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uname.toUpperCase());
			ResultSet re = ps.executeQuery();
			while (re.next()) {
				a = new Account();
				a.setAid(re.getInt(1));
				a.setaType(re.getString(2));
				a.setBalance(re.getDouble(3));
				accnts.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accnts;
	}
	//add account to the user accounts table
	public Account addOne(int uid, double intldepo) {
		String sql = "INSERT INTO USER_ACCOUNTS (U_ID, AMOUNT) VALUES (?,?)";

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			// retrieve the auto-generated account_id key.
			String[] key = { "UA_ID" };
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setInt(1, uid);
			ps.setDouble(2, intldepo);
			int rowsUpdated = ps.executeUpdate();
			if (rowsUpdated > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				a = new Account();
				while (pk.next()) {
					a.setAid(pk.getInt(1));

				}
				conn.commit();
			}
			conn.commit();

		} catch (SQLException se) {
			System.err.println("Got SQLException:");
			se.printStackTrace();
		}
		return a;
	}

	// adds the users account id to the junctions table indicating type and set up
	// for scalability
	public void addJnct(int uaid, int atid) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "INSERT INTO USER_ACCOUNT_TYPE (UA_ID, A_ID) VALUES (?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, uaid);
			ps.setDouble(2, atid);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// withdraw method
	public void withdraw(int uaid, int withdrwamt) throws SQLException {
		Connection conn = ConnectionFactory.getInstance().getConnection(); 
			String sql = "UPDATE USER_ACCOUNTS SET AMOUNT = AMOUNT - ? WHERE UA_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, withdrwamt);
			ps.setDouble(2, uaid);
			ps.executeUpdate();
		
	}

	// deposit method
	public void deposit(int uaid, int deposit) throws SQLException {
			Connection conn = ConnectionFactory.getInstance().getConnection(); 
			String sql = "UPDATE USER_ACCOUNTS SET AMOUNT = AMOUNT + ? WHERE UA_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, deposit);
			ps.setDouble(2, uaid);
			ps.executeUpdate();
		
			
		
	}
	
	
	
	
	
	public List<Account> getTime() {
		List<Account> accnts = new ArrayList<Account>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "CALL GET_TIME()";
			CallableStatement cs = conn.prepareCall(sql);
//			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.registerOutParameter(1, OracleTypes.DATE);
			cs.execute();
			
			ResultSet rs = (ResultSet) cs.getObject(1);
			while(rs.next()) {
				Account a = new Account();
				System.out.println(rs.getDate(1));
				a.setTime(rs.getString(1));
				accnts.add(a);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return accnts;
	}
	
	

}
