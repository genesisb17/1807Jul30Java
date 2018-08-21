package com.iantimothyjohnson.assignments.project1.dao;

import com.iantimothyjohnson.assignments.project1.pojos.User;

/**
 * A user DAO class intended for use in testing.
 * 
 * @author Ian Johnson
 */
public class MockUserDAO extends MockDAO<User> implements UserDAO {
    @Override
    public User selectByUsername(String username) {
        return entries.stream()
            .filter(u -> u.getUsername().equals(username.toLowerCase()))
            .findFirst().map(u -> u.copy()).orElse(null);
    }
}
