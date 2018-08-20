package com.iantimothyjohnson.assignments.project1.pojos;

import java.util.HashMap;
import java.util.Map;

/**
 * The type of a reimbursement.
 * 
 * @author Ian Johnson
 */
public enum ReimbursementType {
    LODGING(1), TRAVEL(2), FOOD(3), OTHER(4);

    private static final Map<Integer, ReimbursementType> typesById = new HashMap<>();

    private int id;

    static {
        for (ReimbursementType v : ReimbursementType.values()) {
            typesById.put(v.getId(), v);
        }
    }

    /**
     * Gets the reimbursement type corresponding to the given ID.
     * 
     * @param id the ID of a reimbursement type
     * @return the corresponding reimbursement type
     * @throws IllegalArgumentException if the given ID does not correspond to a
     *                                  reimbursement type
     */
    public static ReimbursementType fromId(int id) {
        ReimbursementType type = typesById.get(id);
        if (type == null) {
            throw new IllegalArgumentException(
                "ID " + id + " does not correspond to a reimbursement type.");
        }
        return type;
    }

    ReimbursementType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
