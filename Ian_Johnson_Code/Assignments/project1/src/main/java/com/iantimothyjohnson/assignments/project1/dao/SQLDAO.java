package com.iantimothyjohnson.assignments.project1.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * An abstract class representing a DAO that uses SQL to access a database.
 * 
 * Currently, this class is mostly used to reduce needless repetition in the
 * implementation of DAOs that use SQL. It is an abstract class rather than an
 * interface because it provides protected methods that are only intended to be
 * used by subclasses.
 * 
 * @author Ian Johnson
 * @param <T> the underlying type of the DAO
 */
public abstract class SQLDAO<T> implements DAO<T> {
    /**
     * Parses an object of this class's underlying type from a single row of the
     * given ResultSet. Implementations of this method must not change the
     * ResultSet cursor position, for example by calling the next method.
     * 
     * @param rs the ResultSet from which to parse the row. It must be pointing
     *           at a row which represents an object of the underlying type
     *           (with all the necessary information to construct such an
     *           object).
     * @return the object parsed from the ResultSet row
     * @throws SQLException if reading from the ResultSet results in an
     *                      SQLException
     */
    protected abstract T parseResultSetRow(ResultSet rs) throws SQLException;

    /**
     * Collects a list of objects from the results of a query. The query that
     * produced the ResultSet must return rows that can be parsed by the
     * parseResultSetRow method.
     * 
     * @param rs the ResultSet from which to collect. It must be in its initial
     *           state; that is, the ResultSet cursor must be before the first
     *           row of data to be collected.
     * @return a list of the objects found in the ResultSet
     * @throws SQLException if a SQLException is thrown by the ResultSet when
     *                      trying to get the next row of data
     */
    protected List<T> collectFromResultSet(ResultSet rs) throws SQLException {
        List<T> list = new ArrayList<>();
        while (rs.next()) {
            list.add(parseResultSetRow(rs));
        }
        return list;
    }
}
