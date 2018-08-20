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
        final String sql = "INSERT INTO ers_user "
            + "(role, username, first_name, last_name, email, password_salt, password_hash) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (
            Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String[] keys = { "id" };
            PreparedStatement ps = conn.prepareStatement(sql, keys);
            ps.setInt(1, obj.getRole().getId());
            ps.setString(2, obj.getUsername());
            ps.setString(3, obj.getFirstName());
            ps.setString(4, obj.getLastName());
            ps.setString(5, obj.getEmail());
            ps.setBytes(6, obj.getPasswordSalt());
            ps.setBytes(7, obj.getPasswordHash());
            int affected = ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (affected == 1 && generatedKeys.next()) {
                obj.setId(generatedKeys.getInt(1));
                return true;
            }
        } catch (SQLException e) {
            logger.error("Could not insert new user into database.", e);
        }
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
            if (rs.next()) {
                return parseResultSetRow(rs);
            }
        } catch (SQLException e) {
            logger.error("Could not query database for a user by ID.", e);
        }
        return null;
    }

    @Override
    public boolean update(User obj) {
        final String sql = "UPDATE ers_user SET "
            + "role = ?, username = ?, first_name = ?, last_name = ?, email = ?, password_salt = ?, password_hash = ? "
            + "WHERE id = ?";
        try (
            Connection conn = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, obj.getRole().getId());
            ps.setString(2, obj.getUsername());
            ps.setString(3, obj.getFirstName());
            ps.setString(4, obj.getLastName());
            ps.setString(5, obj.getEmail());
            ps.setBytes(6, obj.getPasswordSalt());
            ps.setBytes(7, obj.getPasswordHash());
            ps.setInt(8, obj.getId());
            int affected = ps.executeUpdate();
            return affected == 1;
        } catch (SQLException e) {
            logger.error("Could not update user in database.", e);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        final String sql = "DELETE FROM ers_user WHERE id = ?";
        try (
            Connection conn = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int affected = ps.executeUpdate();
            return affected == 1;
        } catch (SQLException e) {
            logger.error("Could not delete user from database.", e);
        }
        return false;
    }

    @Override
    public User selectByUsername(String username) {
        final String sql = "SELECT * FROM ers_user WHERE username = ?";
        try (
            Connection conn = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return parseResultSetRow(rs);
            }
        } catch (SQLException e) {
            logger.error("Could not query database for a user by username.", e);
        }
        return null;
    }

    @Override
    protected User parseResultSetRow(ResultSet rs) throws SQLException {
        User u = new User();
        u.setId(rs.getInt("id"));
        u.setRole(UserRole.fromId(rs.getInt("role")));
        u.setUsername(rs.getString("username"));
        u.setFirstName(rs.getString("first_name"));
        u.setLastName(rs.getString("last_name"));
        u.setEmail(rs.getString("email"));
        u.setPasswordSalt(rs.getBytes("password_salt"));
        u.setPasswordHash(rs.getBytes("password_hash"));
        return u;
    }
}
