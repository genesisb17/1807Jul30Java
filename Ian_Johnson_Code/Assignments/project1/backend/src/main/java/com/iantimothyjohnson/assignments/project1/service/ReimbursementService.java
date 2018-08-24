package com.iantimothyjohnson.assignments.project1.service;

import java.util.List;

import com.iantimothyjohnson.assignments.project1.dao.ReimbursementDAO;
import com.iantimothyjohnson.assignments.project1.dao.SQLReimbursementDAO;
import com.iantimothyjohnson.assignments.project1.exceptions.PermissionDeniedException;
import com.iantimothyjohnson.assignments.project1.exceptions.ReimbursementAlreadyResolvedException;
import com.iantimothyjohnson.assignments.project1.exceptions.ReimbursementNotFoundException;
import com.iantimothyjohnson.assignments.project1.pojos.Reimbursement;
import com.iantimothyjohnson.assignments.project1.pojos.User;
import com.iantimothyjohnson.assignments.project1.pojos.UserRole;

/**
 * A service class for working with reimbursements. This class abstracts over
 * the DAO, allowing different DAO backends to be used interchangeably (such as
 * a mock DAO for testing) with a higher level of abstraction.
 * 
 * @author Ian Johnson
 */
public class ReimbursementService {
    /**
     * The user "performing" the calls to these methods (so that permissions can
     * be checked accordingly).
     */
    private User actor;
    private ReimbursementDAO reimbursementDao;

    /**
     * Constructs a new ReimbursementService with the default
     * SQLReimbursementDAO backend.
     * 
     * @param actor a User object corresponding to the user who can be thought
     *              of as "calling" the methods in this instance. This will be
     *              used to evaluate the user's permission to perform certain
     *              operations.
     * @throws IllegalArgumentException if actor is null
     */
    public ReimbursementService(User actor) {
        this(actor, new SQLReimbursementDAO());
    }

    /**
     * Constructs a new ReimbursementService with the given DAO backend.
     * 
     * @param actor           a User object corresponding to the user who can be
     *                        thought of as "calling" the methods in this
     *                        instance. This will be used to evaluate the user's
     *                        permission to perform certain operations.
     * @param reimbusementDao the DAO backend to use. This DAO will be used for
     *                        all interactions between the ReimbursementService
     *                        and the database.
     * @throws IllegalArgumentException if either actor or reimbursementDao is
     *                                  null
     */
    public ReimbursementService(User actor, ReimbursementDAO reimbursementDao) {
        if (actor == null) {
            throw new IllegalArgumentException("actor must not be null.");
        }
        if (reimbursementDao == null) {
            throw new IllegalArgumentException(
                "reimbursementDao must not be null.");
        }
        this.actor = actor;
        this.reimbursementDao = reimbursementDao;
    }

    /**
     * Creates a new reimbursement request.
     * 
     * @param reimbursement the reimbursement to serve as the basis for the new
     *                      reimbursement. Some of the properties of this object
     *                      will be ignored; in particular, the ID, author,
     *                      submitted date, resolver and resolved date will be
     *                      ignored (and overwritten with their proper values).
     *                      The author is always the actor associated with the
     *                      ReimbursementService.
     */
    public void create(Reimbursement reimbursement) {
        reimbursement.setAuthorId(actor.getId());
        reimbursementDao.insert(reimbursement);
    }

    /**
     * Gets a reimbursement by its ID.
     * 
     * @param id the ID of the reimbursement to get
     * @return the reimbursement, or null if no reimbursement exists with the
     *         given ID
     * @throws PermissionDeniedException      if the actor is not a manager and
     *                                        the reimbursement was not made by
     *                                        the actor
     * @throws ReimbursementNotFoundException if there is no reimbursement with
     *                                        the given ID
     */
    public Reimbursement get(int id)
        throws PermissionDeniedException, ReimbursementNotFoundException {
        Reimbursement r = reimbursementDao.selectById(id);
        if (r == null) {
            throw new ReimbursementNotFoundException(id);
        }
        if (actor.getRole() != UserRole.MANAGER
            && actor.getId() != r.getAuthorId()) {
            throw new PermissionDeniedException(
                "Only managers can retrieve other users' reimbursement data.");
        }
        return r;
    }

    /**
     * Gets a list of all reimbursement requests in the system.
     * 
     * @return a list of all reimbursements
     * @throws PermissionDeniedException if the actor is not a manager (who can
     *                                   see other user's reimbursements)
     */
    public List<Reimbursement> getAll() throws PermissionDeniedException {
        if (actor.getRole() != UserRole.MANAGER) {
            throw new PermissionDeniedException(
                "Only managers are allowed to see reimbursement requests from other users.");
        }
        return reimbursementDao.selectAll();
    }

    /**
     * Gets a list of all reimbursement requests made by the given user.
     * 
     * @param userId the ID of the user whose reimbursement requests to find
     * @return a list of the user's reimbursement requests
     * @throws PermissionDeniedException if the actor does not have permission
     *                                   to see the given user's requests
     *                                   (normal employees can only see their
     *                                   own requests)
     */
    public List<Reimbursement> getAllForUser(int userId)
        throws PermissionDeniedException {
        if (actor.getRole() != UserRole.MANAGER && actor.getId() != userId) {
            throw new PermissionDeniedException(
                "Only managers are allowed to see reimbursement requests from other users.");
        }
        return reimbursementDao.selectAllByAuthor(userId);
    }

    /**
     * Resolves the reimbursement with the given ID.
     * 
     * @param id       the ID of the reimbursement to resolve
     * @param approved whether the reimbursement is to be approved (if false, it
     *                 is to be denied)
     * @return the reimbursement that was resolved
     * @throws PermissionDeniedException             if the actor is not a
     *                                               manager
     * @throws ReimbursementNotFoundException        if there is no
     *                                               reimbursement with the
     *                                               given ID
     * @throws ReimbursementAlreadyResolvedException if the reimbursement has
     *                                               already been resolved
     */
    public Reimbursement resolve(int id, boolean approved)
        throws PermissionDeniedException, ReimbursementNotFoundException,
        ReimbursementAlreadyResolvedException {
        if (actor.getRole() != UserRole.MANAGER) {
            throw new PermissionDeniedException(
                "Only managers can resolve reimbursement requests.");
        }
        Reimbursement reimbursement = get(id);
        // Make sure the reimbursement isn't already resolved.
        if (reimbursement.getResolved() != null) {
            throw new ReimbursementAlreadyResolvedException(id);
        }
        reimbursementDao.resolve(reimbursement, approved, actor.getId());
        return reimbursement;
    }
}
