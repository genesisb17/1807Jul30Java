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
import pojo.Client;

public class ClientDAO implements DAO<Client, Integer> {

	public List<Client> getAll() {
		List<Client> Clients = new ArrayList<Client>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{call get_all_Account_type(?)}";
			CallableStatement cs = conn.prepareCall(sql);
	
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			ResultSet rs = (ResultSet) cs.getObject(1);
			
			while(rs.next()) {
				Client temp = new Client(rs.getInt(1), 
						rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getString(5));
				System.out.println(temp);
				Clients.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Clients;
	}
	
	public Client findOne(Integer id) {
		Client a = new Client();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from client where Account_type_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			info.next();
			a.setId(info.getInt(1));
			a.setFirstName(info.getString(2));
			a.setLastName(info.getString(3));
			a.setUsername(info.getString(4));
			a.setPassword(info.getString(5));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	

	public Client save(Client a) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			conn.setAutoCommit(false);
			String sql = "insert into client(client_id,first_name,last_name,username,password) values(?,?,?,?,?)";
			
			String[] keys = {"Client_ID"};
			
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setInt(1, a.getId());
			ps.setString(2,  a.getFirstName());
			ps.setString(3, a.getLastName());
			ps.setString(4, a.getUsername());
			ps.setString(5, a.getPassword());
			
			
			int rowsUpdated = ps.executeUpdate();
			if(rowsUpdated > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					System.out.println(pk.getInt(1));
					a.setId(pk.getInt(1));
				}
			}
			
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return a;
	}
	@Override
	public Client update(Client obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Client obj) {
		// TODO Auto-generated method stub
		
	}

}
