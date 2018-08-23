package com.iantimothyjohnson.assignments.project1.pojos;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * A user of the ERS.
 * 
 * @author Ian Johnson
 */
public class User implements Copiable<User>, Identifiable {
    /**
     * The maximum length of a username, in characters.
     */
    public static final int MAX_USERNAME_LEN = 50;
    /**
     * The maximum length of a first name, in characters.
     */
    public static final int MAX_FIRST_NAME_LEN = 100;
    /**
     * The maximum length of a last name, in characters.
     */
    public static final int MAX_LAST_NAME_LEN = 100;
    /**
     * The maximum length of an email, in characters.
     */
    public static final int MAX_EMAIL_LEN = 150;

    private int id;
    private UserRole role;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    @JsonIgnore
    private byte[] passwordSalt;
    @JsonIgnore
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
        if (username.length() > MAX_USERNAME_LEN) {
            throw new IllegalArgumentException(
                "Username length is greater than the maximum of "
                    + MAX_USERNAME_LEN + ".");
        }
        this.username = username.toLowerCase();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.length() > MAX_FIRST_NAME_LEN) {
            throw new IllegalArgumentException(
                "First name length is greater than the maximum of "
                    + MAX_FIRST_NAME_LEN + ".");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() > MAX_LAST_NAME_LEN) {
            throw new IllegalArgumentException(
                "Last name length is greater than the maximum of "
                    + MAX_LAST_NAME_LEN + ".");
        }
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email.length() > MAX_EMAIL_LEN) {
            throw new IllegalArgumentException(
                "Email length is greater than the maximum of " + MAX_EMAIL_LEN
                    + ".");
        }
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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result
            + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + id;
        result = prime * result
            + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + Arrays.hashCode(passwordHash);
        result = prime * result + Arrays.hashCode(passwordSalt);
        result = prime * result + ((role == null) ? 0 : role.hashCode());
        result = prime * result
            + ((username == null) ? 0 : username.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User other = (User) obj;
        if (email == null) {
            if (other.email != null) {
                return false;
            }
        } else if (!email.equals(other.email)) {
            return false;
        }
        if (firstName == null) {
            if (other.firstName != null) {
                return false;
            }
        } else if (!firstName.equals(other.firstName)) {
            return false;
        }
        if (id != other.id) {
            return false;
        }
        if (lastName == null) {
            if (other.lastName != null) {
                return false;
            }
        } else if (!lastName.equals(other.lastName)) {
            return false;
        }
        if (!Arrays.equals(passwordHash, other.passwordHash)) {
            return false;
        }
        if (!Arrays.equals(passwordSalt, other.passwordSalt)) {
            return false;
        }
        if (role != other.role) {
            return false;
        }
        if (username == null) {
            if (other.username != null) {
                return false;
            }
        } else if (!username.equals(other.username)) {
            return false;
        }
        return true;
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
