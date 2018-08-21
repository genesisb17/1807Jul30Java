package com.iantimothyjohnson.assignments.project1.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.iantimothyjohnson.assignments.project1.dao.MockUserDAO;
import com.iantimothyjohnson.assignments.project1.dao.UserDAO;
import com.iantimothyjohnson.assignments.project1.pojos.User;
import com.iantimothyjohnson.assignments.project1.pojos.UserRole;
import com.iantimothyjohnson.assignments.project1.util.Passwords;

class UserServiceTest {
    static final String TEST_USERNAME = "testuser";
    static final char[] TEST_PASSWORD = "password".toCharArray();

    UserDAO userDao;
    UserService userService;
    User testUser;

    @BeforeEach
    void setUp() {
        userDao = new MockUserDAO();
        userService = new UserService(userDao);

        testUser = new User();
        testUser.setRole(UserRole.EMPLOYEE);
        testUser.setUsername(TEST_USERNAME);
        testUser.setFirstName("Test");
        testUser.setLastName("User");
        testUser.setEmail("email@email.com");
        testUser.setPasswordSalt(Passwords.generateSalt());
        testUser.setPasswordHash(
            Passwords.hashPassword(TEST_PASSWORD, testUser.getPasswordSalt()));

        userDao.insert(testUser);
    }

    @AfterEach
    void tearDown() {
        userDao = null;
        userService = null;
        testUser = null;
    }

    @Test
    final void testCreate() throws Exception {
        User user = new User();
        user.setRole(UserRole.EMPLOYEE);
        // Avoid username conflicts with the existing user.
        user.setUsername(TEST_USERNAME + "2");
        user.setFirstName("Test");
        user.setLastName("User");
        user.setEmail("email@email.com");
        char[] password = "password".toCharArray();

        userService.create(user, password);
        assertNotEquals(0, user.getId(), "User ID was not set properly.");
        assertNotNull(user.getPasswordSalt(),
            "Password salt was not set properly.");
        assertNotNull(user.getPasswordHash(),
            "Password hash was not set properly.");

        User inserted = userDao.selectById(user.getId());
        assertEquals(inserted, user,
            "User object does not match database contents.");
    }

    @Test
    final void testGet() throws Exception {
        assertEquals(testUser, userService.get(TEST_USERNAME),
            "Retrieved user does not match original object.");
    }

    @Test
    final void testGetUppercase() throws Exception {
        assertEquals(testUser, userService.get(TEST_USERNAME.toUpperCase()),
            "Retrieved user does not match original object when using uppercase username.");
    }

    @Test
    final void testLogin() throws Exception {
        char[] password = Arrays.copyOf(TEST_PASSWORD, TEST_PASSWORD.length);
        assertEquals(testUser, userService.login(TEST_USERNAME, password),
            "Failed to get user by logging in.");
        assertArrayEquals(new char[password.length], password,
            "Password not cleared after logging user in.");
    }

    @Test
    final void testLoginUppercase() throws Exception {
        char[] password = Arrays.copyOf(TEST_PASSWORD, TEST_PASSWORD.length);
        assertEquals(testUser,
            userService.login(TEST_USERNAME.toUpperCase(), password),
            "Failed to get user by logging in with uppercase username.");
        assertArrayEquals(new char[password.length], password,
            "Password not cleared after logging user in with uppercase username.");
    }

    @Test
    final void testUpdate() {
        testUser.setFirstName("Updated");
        testUser.setLastName("User2");
        userService.update(testUser);
        assertEquals(testUser, userDao.selectById(testUser.getId()));
    }
}
