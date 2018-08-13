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
import pojo.Account;
import pojo.Client;

public class ClientDAO implements DAO<Client, Integer> {

	public List<Client> getAll() {
		List<Client> Clients = new ArrayList<Client>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{call get_all_clients(?)}";
			
			CallableStatement cs = conn.prepareCall(sql);
	
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			
			ResultSet rs = (ResultSet) cs.getObject(1);
			
			while(rs.next()) {
				Client temp = new Client();
				temp.setId(rs.getInt("client_id"));
				temp.setFirstName(rs.getString("first_name"));
				temp.setLastName(rs.getString("last_name"));
				temp.setUsername(rs.getString("username"));
				temp.setPassword(rs.getString("user_password"));

				//System.out.println(temp);
				Clients.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Clients;
	}
	
	public Client findOne(String name) {
		
		Client a = null;
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "select * from clients where username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			
			ResultSet info = ps.executeQuery();
			
			
			if(info.next()) {
				a = new Client();
				a.setId(info.getInt(1));
				a.setFirstName(info.getString(2));
				a.setLastName(info.getString(3));
				a.setUsername(info.getString(4));
				a.setPassword(info.getString(5));
			} 
			else {
				System.out.println("Whoops!\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	@Override
	public Client save(Client a) {
		//Client c = new Client();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			conn.setAutoCommit(false);
			String sql = "insert into clients(client_id,first_name,last_name,username,user_password) values(?,?,?,?,?)";
			
			String[] keys = {"Client_ID"};
			
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setInt(1, a.getId());
			ps.setString(2,  a.getFirstName());
			ps.setString(3, a.getLastName());
			ps.setString(4, a.getUsername());
			ps.setString(5, a.getPassword());
			
			
			int rowsUpdated = ps.executeUpdate();
			if(rowsUpdated != 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					System.out.println(pk.getInt(1)+ " client id");
					a.setId(pk.getInt(1));
				}
				//conn.commit();
			}			
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return a;
	}

	@Override
	public Client update(Client obj) {
		Client c = new Client();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			conn.setAutoCommit(false);
			String sql = "update accounts set(client_id,first_name,last_name,username,user_password) values(?,?,?,?,?)";
			
			String[] keys = {"Client_ID"};
			
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setInt(1, obj.getId());
			ps.setString(2,  obj.getFirstName());
			ps.setString(3, obj.getLastName());
			ps.setString(4, obj.getUsername());
			ps.setString(5, obj.getPassword());
			
			
			int rowsUpdated = ps.executeUpdate();
			if(rowsUpdated != 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					//System.out.println(pk.getInt(1));
					c.setId(pk.getInt(1));
				}
				conn.commit();
			}			
			conn.commit(); //					change I just made 1:49
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return c;
	}

	@Override
	public void delete(Client obj) {
		// TODO Auto-generated method stub
		
	}
	

	
	public boolean doUserPasswordMatch(String usr, String pwd) {
		List<Client> demo = getAll();
		
		for(Client c : demo) {
			if(c.getFirstName().equals(usr) && c.getPassword().equals(pwd)) {
				return true;
			}
		}
		return false;
	}

	public Client findOne(Client id) {
		// TODO Auto-generated method stub
		return null;
	}
}
