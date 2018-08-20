package com.iantimothyjohnson.assignments.project1.dao;

import com.iantimothyjohnson.assignments.project1.pojos.User;

public class MockUserDAO extends MockDAO<User> implements UserDAO {
    @Override
    public User selectByUsername(String username) {
        return entries.stream().filter(u -> u.getUsername().equals(username))
            .findFirst().map(u -> u.copy()).orElse(null);
    }
}
