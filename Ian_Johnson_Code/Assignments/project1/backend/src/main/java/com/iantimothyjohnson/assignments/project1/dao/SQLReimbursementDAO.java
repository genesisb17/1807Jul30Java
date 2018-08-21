package com.iantimothyjohnson.assignments.project1.dao;

import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.time.OffsetDateTime;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.iantimothyjohnson.assignments.project1.pojos.Reimbursement;
import com.iantimothyjohnson.assignments.project1.pojos.ReimbursementStatus;
import com.iantimothyjohnson.assignments.project1.pojos.ReimbursementType;
import com.iantimothyjohnson.assignments.project1.util.ConnectionFactory;

/**
 * A Reimbursement DAO that connects to a database using JDBC.
 * 
 * @author Ian Johnson
 */
public final class SQLReimbursementDAO extends SQLDAO<Reimbursement>
    implements ReimbursementDAO {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public boolean insert(Reimbursement obj) {
        final String sql = "{CALL proc_submit_reimbursement(?, ?, ?, ?, ?, ?, ?, ?)}";
        try (
            Connection conn = ConnectionFactory.getInstance().getConnection()) {
            CallableStatement cs = conn.prepareCall(sql);
            cs.setInt(1, obj.getType().getId());
            cs.setBigDecimal(2, obj.getAmount());
            cs.setString(3, obj.getDescription());
            cs.setBlob(4, (Blob) null);
            cs.setInt(5, obj.getAuthorId());
            cs.registerOutParameter(6, Types.TIMESTAMP_WITH_TIMEZONE);
            cs.registerOutParameter(7, Types.NUMERIC);
            cs.registerOutParameter(8, Types.NUMERIC);
            cs.execute();
            int affected = cs.getInt(8);
            if (affected == 1) {
                // Overwrite the relevant properties of obj.
                obj.setStatus(ReimbursementStatus.PENDING);
                obj.setSubmitted(cs.getObject(6, OffsetDateTime.class));
                obj.setId(cs.getInt(7));
                return true;
            }
        } catch (SQLException e) {
            logger.error("Could not insert new reimbursement into database.",
                e);
        }
        return false;
    }

    @Override
    public List<Reimbursement> selectAll() {
        final String sql = "SELECT * FROM reimbursement";
        try (
            Connection conn = ConnectionFactory.getInstance().getConnection()) {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);
            return collectFromResultSet(rs);
        } catch (SQLException e) {
            logger.error("Could not query database for all reimbursements.", e);
        }
        return null;
    }

    @Override
    public Reimbursement selectById(int id) {
        final String sql = "SELECT * FROM reimbursement WHERE id = ?";
        try (
            Connection conn = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return parseResultSetRow(rs);
            }
        } catch (SQLException e) {
            logger.error("Could not query database for a reimbursement by ID.",
                e);
        }
        return null;
    }

    @Override
    public boolean update(Reimbursement obj) {
        final String sql = "UPDATE reimbursement SET "
            + "type = ?, status = ?, amount = ?, description = ?, author = ?, resolver = ? "
            + "WHERE id = ?";
        try (
            Connection conn = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, obj.getType().getId());
            ps.setInt(2, obj.getStatus().getId());
            ps.setBigDecimal(3, obj.getAmount());
            ps.setString(4, obj.getDescription());
            ps.setInt(5, obj.getAuthorId());
            ps.setInt(6, obj.getResolverId());
            ps.setInt(7, obj.getId());
            int affected = ps.executeUpdate();
            return affected == 1;
        } catch (SQLException e) {
            logger.error("Could not update reimbursement in database.", e);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        final String sql = "DELETE FROM reimbursement WHERE id = ?";
        try (
            Connection conn = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int affected = ps.executeUpdate();
            return affected == 1;
        } catch (SQLException e) {
            logger.error("Could not delete reimbursement from database.", e);
        }
        return false;
    }

    @Override
    public List<Reimbursement> selectAllByAuthor(int userId) {
        final String sql = "SELECT * FROM reimbursement WHERE author = ?";
        try (
            Connection conn = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            return collectFromResultSet(rs);
        } catch (SQLException e) {
            logger.error(
                "Could not query database for reimbursements by author.", e);
        }
        return null;
    }

    @Override
    public boolean resolve(Reimbursement r, boolean approved, int resolverId) {
        final String sql = "{CALL proc_resolve_reimbursement(?, ?, ?, ?, ?)}";
        try (
            Connection conn = ConnectionFactory.getInstance().getConnection()) {
            ReimbursementStatus newStatus = approved
                ? ReimbursementStatus.APPROVED
                : ReimbursementStatus.DENIED;
            CallableStatement cs = conn.prepareCall(sql);
            cs.setInt(1, r.getId());
            cs.setInt(2, newStatus.getId());
            cs.setInt(3, resolverId);
            cs.registerOutParameter(4, Types.TIMESTAMP_WITH_TIMEZONE);
            cs.registerOutParameter(5, Types.NUMERIC);
            cs.execute();
            int affected = cs.getInt(5);
            if (affected == 1) {
                r.setStatus(newStatus);
                r.setResolverId(resolverId);
                r.setResolved(cs.getObject(4, OffsetDateTime.class));
                return true;
            }
        } catch (SQLException e) {
            logger.error("Could not resolve a reimbursement in the database.",
                e);
        }
        return false;
    }

    @Override
    protected Reimbursement parseResultSetRow(ResultSet rs)
        throws SQLException {
        Reimbursement r = new Reimbursement();
        r.setId(rs.getInt("id"));
        r.setType(ReimbursementType.fromId(rs.getInt("type")));
        r.setStatus(ReimbursementStatus.fromId(rs.getInt("status")));
        r.setAmount(rs.getBigDecimal("amount"));
        r.setDescription(rs.getString("description"));
        // Set the receipt here.
        r.setAuthorId(rs.getInt("author"));
        r.setResolverId(rs.getInt("resolver"));
        r.setSubmitted(rs.getObject("submitted", OffsetDateTime.class));
        r.setResolved(rs.getObject("resolved", OffsetDateTime.class));
        return r;
    }
}
