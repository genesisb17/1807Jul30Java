package com.iantimothyjohnson.assignments.project1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.iantimothyjohnson.assignments.project1.pojos.User;
import com.iantimothyjohnson.assignments.project1.pojos.UserRole;
import com.iantimothyjohnson.assignments.project1.util.ConnectionFactory;

/**
 * A singleton User DAO that connects to a database using JDBC.
 * 
 * @author Ian Johnson
 */
public final class SQLUserDAO extends SQLDAO<User> implements UserDAO {
    private static final Logger logger = LogManager.getLogger();
    private static SQLUserDAO instance;

    private SQLUserDAO() {
    }
    
    public static SQLUserDAO getInstance() {
        if (instance == null) {
            instance = new SQLUserDAO();
        }
        return instance;
    }

    @Override
    public boolean insert(User obj) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<User> selectAll() {
        final String sql = "SELECT * FROM ers_user";
        try (
            Connection conn = ConnectionFactory.getInstance().getConnection()) {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);
            return collectFromResultSet(rs);
        } catch (SQLException e) {
            logger.error("Could not query database for all users.", e);
        }
        return null;
    }

    @Override
    public User selectById(int id) {
        final String sql = "SELECT * FROM ers_user WHERE id = ?";
        try (
            Connection conn = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.first()) {
                return parseResultSetRow(rs);
            }
        } catch (SQLException e) {
            logger.error("Could not query database for all users.", e);
        }
        return null;
    }

    @Override
    public boolean update(User obj) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public User selectByUsername(String username) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected User parseResultSetRow(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setRole(UserRole.fromId(rs.getInt("role")));
        user.setUsername(rs.getString("username"));
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        user.setEmail(rs.getString("email"));
        user.setPasswordSalt(rs.getBytes("password_salt"));
        user.setPasswordHash(rs.getBytes("password_hash"));
        return user;
    }
}
