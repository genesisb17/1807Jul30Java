package com.iantimothyjohnson.assignments.project1.servlets.types;

import com.iantimothyjohnson.assignments.project1.pojos.User;

/**
 * A class that is to be deserialized from JSON, containing a User and an
 * accompanying password (for creating a new user).
 * 
 * @author Ian Johnson
 */
public class UserWithPassword {
    private User user;
    private String password;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
