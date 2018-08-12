package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rev.pojos.Author;
import com.rev.pojos.Genre;
import com.rev.util.ConnectionFactory;

public class AuthorDao implements Dao<Author, Integer>{

	@Override
	public List<Author> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Author findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Author save(Author obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "insert into author(firstname, lastname, bio) values (?, ?,?)";
			String[] keys = {"author_id"};
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1, obj.getFirst_Name());
			ps.setString(2, obj.getLast_Name());
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

	@Override
	public Author update(Author obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Author obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Author> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

