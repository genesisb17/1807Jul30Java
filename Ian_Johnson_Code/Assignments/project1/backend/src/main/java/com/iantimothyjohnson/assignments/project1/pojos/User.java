package com.iantimothyjohnson.assignments.project1.pojos;

import java.util.Arrays;

/**
 * A user of the ERS.
 * 
 * @author Ian Johnson
 */
public class User implements Copiable<User>, Identifiable {
    private int id;
    private UserRole role;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private byte[] passwordSalt;
    private byte[] passwordHash;

    public User() {
    }

    public User(User u) {
        copyFrom(u);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(byte[] passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public byte[] getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(byte[] passwordHash) {
        this.passwordHash = passwordHash;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", role=" + role + ", username=" + username
            + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
            + email + ", passwordSalt=" + Arrays.toString(passwordSalt)
            + ", passwordHash=" + Arrays.toString(passwordHash) + "]";
    }

    @Override
    public User copy() {
        return new User(this);
    }

    @Override
    public void copyFrom(User u) {
        id = u.id;
        role = u.role;
        username = u.username;
        firstName = u.firstName;
        lastName = u.lastName;
        email = u.email;
        passwordSalt = Arrays.copyOf(u.passwordSalt, u.passwordSalt.length);
        passwordHash = Arrays.copyOf(u.passwordHash, u.passwordHash.length);
    }
}
