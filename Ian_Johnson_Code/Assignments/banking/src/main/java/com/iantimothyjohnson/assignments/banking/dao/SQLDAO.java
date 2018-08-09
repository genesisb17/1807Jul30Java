package com.iantimothyjohnson.assignments.banking.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class SQLDAO<T> implements DAO<T> {
	protected abstract List<T> collectFromResultSet(ResultSet rs) throws SQLException;
}
