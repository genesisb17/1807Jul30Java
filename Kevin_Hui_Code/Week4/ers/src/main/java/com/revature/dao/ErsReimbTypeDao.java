package com.revature.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.ErsReimbType;
import com.revature.util.ConnectionFactory;

public class ErsReimbTypeDao implements DAO<ErsReimbType, Integer> {

	@Override
	public List<ErsReimbType> findAll() {
		List<ErsReimbType> typeList = new ArrayList<ErsReimbType>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			String query = "SELECT * FROM ERS_REIMBURSEMENT_TYPE";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				typeList.add(new ErsReimbType(rs.getInt(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			System.out.println("SQL Error " + e.getErrorCode() + ": " + e.getSQLState());
		}
		return typeList;
	}

	@Override
	public ErsReimbType findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ErsReimbType insert(ErsReimbType obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ErsReimbType update(ErsReimbType obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(ErsReimbType obj) {
		// TODO Auto-generated method stub
		
	}

}
