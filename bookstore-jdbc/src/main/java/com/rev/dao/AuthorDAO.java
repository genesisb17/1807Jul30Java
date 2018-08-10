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

public class AuthorDAO {

	public static Author findOne(int id){
		Author a = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from author where author_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			while(info.next()) {
			a = new Author();
			a.setId(info.getInt(1));
			a.setFirst_Name(info.getString(2));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
}
