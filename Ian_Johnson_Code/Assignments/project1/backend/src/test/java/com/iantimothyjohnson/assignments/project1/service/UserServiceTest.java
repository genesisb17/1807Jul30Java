package com.iantimothyjohnson.assignments.project1.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.iantimothyjohnson.assignments.project1.dao.MockUserDAO;
import com.iantimothyjohnson.assignments.project1.dao.UserDAO;
import com.iantimothyjohnson.assignments.project1.exceptions.PermissionDeniedException;
import com.iantimothyjohnson.assignments.project1.pojos.User;
import com.iantimothyjohnson.assignments.project1.pojos.UserRole;
import com.iantimothyjohnson.assignments.project1.util.Passwords;

class UserServiceTest {
    static final String TEST_MANAGER_USERNAME = "testmanager";
    static final char[] TEST_MANAGER_PASSWORD = "password".toCharArray();
    static final String TEST_EMPLOYEE_USERNAME = "testemployee";
    static final char[] TEST_EMPLOYEE_PASSWORD = "password123".toCharArray();

    UserDAO userDao;
    User testManager;
    User testEmployee;

    @BeforeEach
    void setUp() {
        userDao = new MockUserDAO();

        testManager = new User();
        testManager.setRole(UserRole.MANAGER);
        testManager.setUsername(TEST_MANAGER_USERNAME);
        testManager.setFirstName("Test");
        testManager.setLastName("Manager");
        testManager.setEmail("email@official.com");
        testManager.setPasswordSalt(Passwords.generateSalt());
        testManager.setPasswordHash(Passwords.hashPassword(
            TEST_MANAGER_PASSWORD, testManager.getPasswordSalt()));

        testEmployee = new User();
        testEmployee.setRole(UserRole.EMPLOYEE);
        testEmployee.setUsername(TEST_EMPLOYEE_USERNAME);
        testEmployee.setFirstName("Test");
        testEmployee.setLastName("Employee");
        testEmployee.setEmail("email@email.com");
        testEmployee.setPasswordSalt(Passwords.generateSalt());
        testEmployee.setPasswordHash(Passwords.hashPassword(
            TEST_EMPLOYEE_PASSWORD, testEmployee.getPasswordSalt()));

        userDao.insert(testManager);
        userDao.insert(testEmployee);
    }

    @AfterEach
    void tearDown() {
        userDao = null;
        testEmployee = null;
        testManager = null;
    }

    @Nested
    @DisplayName("with actions performed as a manager")
    class AsManager {
        UserService userService;

        @BeforeEach
        void setUp() {
            userService = new UserService(testManager, userDao);
        }

        @AfterEach
        void tearDown() {
            userService = null;
        }

        @Test
        @DisplayName("can create a new user")
        final void testCreate() throws Exception {
            User user = new User();
            user.setRole(UserRole.EMPLOYEE);
            // Avoid username conflicts with the existing user.
            user.setUsername(TEST_EMPLOYEE_USERNAME + "2");
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
                "Manager object does not match database contents.");
        }

        @Test
        @DisplayName("can retrieve an existing user")
        final void testGet() throws Exception {
            assertEquals(testManager, userService.get(TEST_MANAGER_USERNAME),
                "Retrieved user does not match original object.");
        }

        @Test
        @DisplayName("can retrieve an existing user using an uppercase username")
        final void testGetUppercase() throws Exception {
            assertEquals(testManager,
                userService.get(TEST_MANAGER_USERNAME.toUpperCase()),
                "Retrieved user does not match original object when using uppercase username.");
        }

        @Test
        @DisplayName("can update an existing user")
        final void testUpdate() throws Exception {
            testManager.setFirstName("Updated");
            testManager.setLastName("User2");
            userService.update(testManager);
            assertEquals(testManager, userDao.selectById(testManager.getId()),
                "Updated user information was not properly stored.");
        }
    }

    @Nested
    @DisplayName("with actions performed as an ordinary employee")
    class AsEmployee {
        UserService userService;

        @BeforeEach
        void setUp() {
            userService = new UserService(testEmployee, userDao);
        }

        @AfterEach
        void tearDown() {
            userService = null;
        }

        @Test
        @DisplayName("cannot create a new user")
        void testCreatePermissionDenied() throws Exception {
            User user = new User();
            user.setRole(UserRole.EMPLOYEE);
            // Avoid username conflicts with the existing user.
            user.setUsername(TEST_EMPLOYEE_USERNAME + "2");
            user.setFirstName("Test");
            user.setLastName("User");
            user.setEmail("email@email.com");
            char[] password = "password".toCharArray();

            assertThrows(PermissionDeniedException.class,
                () -> userService.create(user, password),
                "Successfully created new user.");
        }

        @Test
        @DisplayName("cannot get another user's information")
        void testGetOtherPermissionDenied() throws Exception {
            assertThrows(PermissionDeniedException.class,
                () -> userService.get(TEST_MANAGER_USERNAME),
                "Successfully got another user's information.");
        }

        @Test
        @DisplayName("can get own user information")
        void testGetSelf() throws Exception {
            assertEquals(testEmployee, userService.get(TEST_EMPLOYEE_USERNAME),
                "Employee object does not match database contents.");
        }

        @Test
        @DisplayName("cannot update another user's information")
        final void testUpdateOtherPermissionDenied() throws Exception {
            testManager.setFirstName("Updated");
            testManager.setLastName("User2");
            assertThrows(PermissionDeniedException.class,
                () -> userService.update(testManager),
                "Successfully updated another user's information.");
        }

        @Test
        @DisplayName("can update own user information")
        final void testUpdateSelf() throws Exception {
            testEmployee.setFirstName("Johnny");
            testEmployee.setLastName("Appleseed");
            userService.update(testEmployee);
            assertEquals(testEmployee, userDao.selectById(testEmployee.getId()),
                "Employee information not successfully updated.");
        }

        @Test
        @DisplayName("cannot update another user's password")
        final void testUpdateOtherPasswordPermissionDenied() throws Exception {
            assertThrows(PermissionDeniedException.class,
                () -> userService.updatePassword(testManager,
                    "newPassword".toCharArray()),
                "Successfully changed the manager's password.");
        }

        @Test
        @DisplayName("can update own password")
        final void testUpdateOwnPassword() throws Exception {
            userService.updatePassword(testEmployee, "p@ssw0rd".toCharArray());
            // Make sure we can log in.
            User loggedIn = new LoginService(userDao)
                .login(testEmployee.getUsername(), "p@ssw0rd".toCharArray());
            assertEquals(testEmployee, loggedIn,
                "Password was not successfully updated.");
        }
    }
}
