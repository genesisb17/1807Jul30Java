package com.iantimothyjohnson.assignments.project1.service;

import java.util.List;

import com.iantimothyjohnson.assignments.project1.dao.ReimbursementDAO;
import com.iantimothyjohnson.assignments.project1.pojos.Reimbursement;
import com.iantimothyjohnson.assignments.project1.pojos.User;

/**
 * A service class for working with reimbursements. This class abstracts over
 * the DAO, allowing different DAO backends to be used interchangeably (such as
 * a mock DAO for testing) with a higher level of abstraction.
 * 
 * @author Ian Johnson
 */
public class ReimbursementService {
    private ReimbursementDAO reimbursementDao;

    /**
     * Constructs a new ReimbursementService with the given DAO backend.
     * 
     * @param reimbusementDao the DAO backend to use. This DAO will be used for
     *                        all interactions between the ReimbursementService
     *                        and the database.
     */
    public ReimbursementService(ReimbursementDAO reimbursementDao) {
        this.reimbursementDao = reimbursementDao;
    }

    /**
     * Gets a list of all reimbursement requests made by the given user.
     * 
     * @param user the user whose reimbursement requests to find
     * @return a list of the user's reimbursement requests
     */
    public List<Reimbursement> getAllForUser(User user) {
        return reimbursementDao.selectAllByAuthor(user.getId());
    }
}
