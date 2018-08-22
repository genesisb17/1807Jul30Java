package com.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ex.pojos.Genre;
import com.ex.util.ConnectionFactory;

public class GenreDao implements Dao<Genre, Integer>{

	public List<Genre> getAll() {
		List<Genre> genres = new ArrayList<Genre>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from genre";

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) {
				Genre temp = new Genre();
				temp.setId(rs.getInt(1)); //can access by name or index(starts with 1)
				temp.setName(rs.getString(2));
				genres.add(temp);
			}


		} catch (SQLException e) {
		//	e.printStackTrace();
		}

		return genres;
	}

	public Genre findOne(Integer id) {
		Genre g = new Genre();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select * from genre where genre_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			
			info.next();
			g.setId(info.getInt(1));
			g.setName(info.getString(2));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return g;
	}

	public Genre save(Genre obj) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String query = "insert into genre (NAME) values (?)";
			
			String[] keys = new String[1];
			keys[0] = "genre_id";
			
			PreparedStatement ps = conn.prepareStatement(query, keys);
			ps.setString(1, obj.getName());
			
			int rows = ps.executeUpdate();
			
			if(rows != 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					obj.setId(pk.getInt(1));
				}
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public Genre update(Genre obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUnique(Genre obj) {
		// TODO Auto-generated method stub
		return false;
	}
}