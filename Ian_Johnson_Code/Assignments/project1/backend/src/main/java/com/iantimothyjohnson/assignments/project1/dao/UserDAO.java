package com.iantimothyjohnson.assignments.project1.dao;

import com.iantimothyjohnson.assignments.project1.pojos.User;

public interface UserDAO extends DAO<User> {
    /**
     * Queries the database for a single user based on username. Usernames must
     * be case-insensitive.
     * 
     * @param username the username of the user to find
     * @return the user that was found, or null if there is no user with the
     *         given username
     */
    User selectByUsername(String username);
}
