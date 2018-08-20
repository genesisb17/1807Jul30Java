package com.iantimothyjohnson.assignments.project1.pojos;

import java.util.HashMap;
import java.util.Map;

/**
 * The role of a user in the ERS. A user's role determines the actions they can
 * perform.
 * 
 * @author Ian Johnson
 */
public enum UserRole {
    EMPLOYEE(1), MANAGER(2);

    private static final Map<Integer, UserRole> rolesById = new HashMap<>();

    private int id;

    static {
        for (UserRole v : UserRole.values()) {
            rolesById.put(v.getId(), v);
        }
    }

    /**
     * Gets the user role corresponding to the given ID.
     * 
     * @param id the ID of a user role
     * @return the corresponding user role
     * @throws IllegalArgumentException if the given ID does not correspond to a
     *                                  user role
     */
    public static UserRole fromId(int id) {
        UserRole role = rolesById.get(id);
        if (role == null) {
            throw new IllegalArgumentException(
                "ID " + id + " does not correspond to a user role.");
        }
        return role;
    }

    UserRole(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
