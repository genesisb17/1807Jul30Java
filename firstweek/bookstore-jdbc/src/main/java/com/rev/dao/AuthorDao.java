package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.rev.pojo.Author;
import com.rev.util.ConnectionFactory;

public class AuthorDao{

	

	public Author save(Author obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "insert into author(firstname, lastname, bio) values (?, ?,?)";
			String[] keys = {"author_id"};
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1, obj.getFirstName());
			ps.setString(2, obj.getLastName());
			ps.setString(3, obj.getBio());
			ps.executeUpdate();
			ResultSet pk = ps.getGeneratedKeys();
			while(pk.next()) {
				obj.setId(pk.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}

	

}
