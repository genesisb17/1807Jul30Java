package com.iantimothyjohnson.assignments.project1.pojos;

import java.util.HashMap;
import java.util.Map;

/**
 * The status of a reimbursement.
 * 
 * @author Ian Johnson
 */
public enum ReimbursementStatus {
    PENDING(1), APPROVED(2), DENIED(3);

    private static final Map<Integer, ReimbursementStatus> statusesById = new HashMap<>();

    private int id;

    // Set up the ID to status map.
    static {
        for (ReimbursementStatus v : ReimbursementStatus.values()) {
            statusesById.put(v.getId(), v);
        }
    }

    /**
     * Gets the reimbursement status corresponding to the given ID.
     * 
     * @param id the ID of a reimbursement status
     * @return the corresponding reimbursement status
     * @throws IllegalArgumentException if the given ID does not correspond to a
     *                                  reimbursement status
     */
    public static ReimbursementStatus fromId(int id) {
        ReimbursementStatus status = statusesById.get(id);
        if (status == null) {
            throw new IllegalArgumentException(
                "ID " + id + " does not correspond to a reimbursement status.");
        }
        return status;
    }

    private ReimbursementStatus(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
