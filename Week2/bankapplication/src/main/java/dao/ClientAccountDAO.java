package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rev.util.ConnectionFactory;

import oracle.jdbc.internal.OracleTypes;
import pojo.ClientAccount;
import pojo.ClientAccount;

public class ClientAccountDAO implements DAO<ClientAccount, Integer> {

	public List<ClientAccount> getAll() {
		List<ClientAccount> Accounts = new ArrayList<ClientAccount>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{call get_all_Client_Account_type(?)}";
			CallableStatement cs = conn.prepareCall(sql);
	
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			ResultSet rs = (ResultSet) cs.getObject(1);
			
			while(rs.next()) {
				ClientAccount temp = new ClientAccount(rs.getInt(1), 
						rs.getInt(2));
				System.out.println(temp);
				Accounts.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Accounts;
	}
	
	public ClientAccount findOne(Integer id) {
		ClientAccount a = new ClientAccount();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from Client_Account_type where Client_Account_type_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			info.next();
			a.setClientId(info.getInt(1));
			a.setAccountId(info.getInt(2));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	

	public ClientAccount save(ClientAccount a) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			conn.setAutoCommit(false);
			String sql = "insert into Client_Account(Client__id, Account_id) values(?,?)";
			
			String[] keys = {"Client_Account_ID"};
			
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setInt(1, a.getClientId());
			ps.setInt(2,  a.getAccountId());
			
			int rowsUpdated = ps.executeUpdate();
			if(rowsUpdated > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					System.out.println(pk.getInt(1));
					a.setClientId(pk.getInt(1));
					a.setAccountId(pk.getInt(2));
				}
			}
			
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return a;
	}

	@Override
	public ClientAccount update(ClientAccount obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(ClientAccount obj) {
		// TODO Auto-generated method stub
		
	}

}
