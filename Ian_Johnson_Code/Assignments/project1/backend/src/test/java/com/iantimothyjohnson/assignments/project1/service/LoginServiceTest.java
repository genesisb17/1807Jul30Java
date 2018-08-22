package com.iantimothyjohnson.assignments.project1.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.iantimothyjohnson.assignments.project1.dao.MockUserDAO;
import com.iantimothyjohnson.assignments.project1.dao.UserDAO;
import com.iantimothyjohnson.assignments.project1.pojos.User;
import com.iantimothyjohnson.assignments.project1.pojos.UserRole;
import com.iantimothyjohnson.assignments.project1.util.Passwords;

class LoginServiceTest {
    static final String TEST_USERNAME = "testuser";
    static final char[] TEST_PASSWORD = "password".toCharArray();

    UserDAO userDao;
    LoginService loginService;
    User testUser;

    @BeforeEach
    void setUp() {
        userDao = new MockUserDAO();
        testUser = new User();
        testUser.setRole(UserRole.MANAGER);
        testUser.setUsername(TEST_USERNAME);
        testUser.setFirstName("Test");
        testUser.setLastName("User");
        testUser.setEmail("email@email.com");
        testUser.setPasswordSalt(Passwords.generateSalt());
        testUser.setPasswordHash(
            Passwords.hashPassword(TEST_PASSWORD, testUser.getPasswordSalt()));
        loginService = new LoginService(userDao);

        userDao.insert(testUser);
    }

    @AfterEach
    void tearDown() {
        userDao = null;
        loginService = null;
        testUser = null;
    }

    @Test
    @DisplayName("can successfully log in with correct username and password")
    final void testLogin() throws Exception {
        char[] password = Arrays.copyOf(TEST_PASSWORD, TEST_PASSWORD.length);
        assertEquals(testUser, loginService.login(TEST_USERNAME, password),
            "Failed to get user by logging in.");
        assertArrayEquals(new char[password.length], password,
            "Password not cleared after logging user in.");
    }

    @Test
    @DisplayName("can successfully log in with an uppercase username")
    final void testLoginUppercase() throws Exception {
        char[] password = Arrays.copyOf(TEST_PASSWORD, TEST_PASSWORD.length);
        assertEquals(testUser,
            loginService.login(TEST_USERNAME.toUpperCase(), password),
            "Failed to get user by logging in with uppercase username.");
        assertArrayEquals(new char[password.length], password,
            "Password not cleared after logging user in with uppercase username.");
    }
}
