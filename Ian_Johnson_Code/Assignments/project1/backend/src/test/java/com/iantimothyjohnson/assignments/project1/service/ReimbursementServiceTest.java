package com.iantimothyjohnson.assignments.project1.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.iantimothyjohnson.assignments.project1.dao.MockReimbursementDAO;
import com.iantimothyjohnson.assignments.project1.dao.MockUserDAO;
import com.iantimothyjohnson.assignments.project1.dao.ReimbursementDAO;
import com.iantimothyjohnson.assignments.project1.dao.UserDAO;
import com.iantimothyjohnson.assignments.project1.exceptions.PermissionDeniedException;
import com.iantimothyjohnson.assignments.project1.pojos.Reimbursement;
import com.iantimothyjohnson.assignments.project1.pojos.ReimbursementStatus;
import com.iantimothyjohnson.assignments.project1.pojos.ReimbursementType;
import com.iantimothyjohnson.assignments.project1.pojos.User;
import com.iantimothyjohnson.assignments.project1.pojos.UserRole;
import com.iantimothyjohnson.assignments.project1.util.Passwords;

class ReimbursementServiceTest {
    static final String TEST_MANAGER_USERNAME = "testmanager";
    static final char[] TEST_MANAGER_PASSWORD = "password".toCharArray();
    static final String TEST_EMPLOYEE_USERNAME = "testemployee";
    static final char[] TEST_EMPLOYEE_PASSWORD = "password123".toCharArray();

    UserDAO userDao;
    ReimbursementDAO reimbursementDao;
    User testManager;
    User testEmployee;
    List<Reimbursement> employeeReimbursements;

    @BeforeEach
    void setUp() throws Exception {
        userDao = new MockUserDAO();
        reimbursementDao = new MockReimbursementDAO();

        // Insert a couple of users to test with.
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

        // Give the employee a couple reimbursements.
        employeeReimbursements = new ArrayList<>();

        Reimbursement r1 = new Reimbursement();
        r1.setStatus(ReimbursementStatus.PENDING);
        r1.setType(ReimbursementType.FOOD);
        r1.setAmount(new BigDecimal("15.00"));
        r1.setAuthorId(testEmployee.getId());
        r1.setSubmitted(OffsetDateTime.now().minusDays(14));

        employeeReimbursements.add(r1);
        reimbursementDao.insert(r1);

        Reimbursement r2 = new Reimbursement();
        r2.setStatus(ReimbursementStatus.APPROVED);
        r2.setType(ReimbursementType.LODGING);
        r2.setAmount(new BigDecimal("149.99"));
        r2.setAuthorId(testEmployee.getId());
        r2.setSubmitted(OffsetDateTime.now().minusDays(7));
        r2.setResolved(OffsetDateTime.now().minusMinutes(10));

        employeeReimbursements.add(r2);
        reimbursementDao.insert(r2);
    }

    @AfterEach
    void tearDown() throws Exception {
        userDao = null;
        reimbursementDao = null;
        testEmployee = null;
        testManager = null;
        employeeReimbursements = null;
    }

    @Nested
    @DisplayName("with actions performed as a manager")
    class AsManager {
        ReimbursementService reimbursementService;

        @BeforeEach
        void setUp() {
            reimbursementService = new ReimbursementService(testManager,
                reimbursementDao);
        }

        @AfterEach
        void tearDown() {
            reimbursementService = null;
        }

        @Test
        @DisplayName("can get an employee's reimbursements")
        void testGetEmployeeReimbursements() throws Exception {
            assertEquals(employeeReimbursements,
                reimbursementService.getAllForUser(testEmployee.getId()),
                "Employee's reimbursements do not match what was inserted into the database.");
        }

        @Test
        @DisplayName("can add a reimbursement")
        void testCreateReimbursement() throws Exception {
            Reimbursement r = new Reimbursement();
            r.setType(ReimbursementType.FOOD);
            r.setAmount(new BigDecimal("16.73"));
            r.setDescription("A reimbursement.");
            // Let's also add some phony properties to make sure they're
            // rejected.
            r.setStatus(ReimbursementStatus.APPROVED);
            r.setAuthorId(testEmployee.getId());
            r.setResolved(OffsetDateTime.now());

            reimbursementService.create(r);
            // Make sure phony properties were corrected.
            assertEquals(ReimbursementStatus.PENDING, r.getStatus());
            assertEquals(0, r.getResolverId());
            assertNull(r.getResolved());
            assertEquals(testManager.getId(), r.getAuthorId());
            // And make sure that good properties were preserved/added.
            assertNotEquals(0, r.getId());
            assertEquals(new BigDecimal("16.73"), r.getAmount());
            // And finally, make sure that we can retrieve the reimbursement.
            assertNotNull(reimbursementService.get(r.getId()));
        }

        @Test
        @DisplayName("can resolve a reimbursement")
        void testResolveReimbursement() throws Exception {
            // Let's get a reimbursement that hasn't been resolved.
            Reimbursement r = employeeReimbursements.stream()
                .filter(re -> re.getStatus() == ReimbursementStatus.PENDING)
                .findAny().get();
            Reimbursement resolved = reimbursementService.resolve(r.getId(),
                true);
            assertEquals(ReimbursementStatus.APPROVED, resolved.getStatus());
            assertNotNull(resolved.getResolved());
            assertEquals(testManager.getId(), resolved.getResolverId());
            // Make sure the reimbursement that was returned is actually what
            // was inserted.
            assertEquals(resolved,
                reimbursementDao.selectById(resolved.getId()));
        }
    }

    @Nested
    @DisplayName("with actions performed as an ordinary employee")
    class AsEmployee {
        ReimbursementService reimbursementService;

        @BeforeEach
        void setUp() {
            reimbursementService = new ReimbursementService(testEmployee,
                reimbursementDao);
        }

        @AfterEach
        void tearDown() {
            reimbursementService = null;
        }

        @Test
        @DisplayName("cannot get another employee's reimbursements")
        void testGetOtherReimbursementsPermissionDenied() throws Exception {
            assertThrows(PermissionDeniedException.class,
                () -> reimbursementService.getAllForUser(testManager.getId()),
                "Successfully got another user's reimbursements.");
        }

        @Test
        @DisplayName("can get own reimbursements")
        void testGetOwnReimbursements() throws Exception {
            assertEquals(employeeReimbursements,
                reimbursementService.getAllForUser(testEmployee.getId()),
                "Employee's reimbursements do not match what was inserted into the database.");
        }

        @Test
        @DisplayName("cannot resolve reimbursements")
        void testResolveReimbursementPermissionDenied() throws Exception {
            // Let's get a reimbursement that hasn't been resolved.
            Reimbursement r = employeeReimbursements.stream()
                .filter(re -> re.getStatus() == ReimbursementStatus.PENDING)
                .findAny().get();
            assertThrows(PermissionDeniedException.class,
                () -> reimbursementService.resolve(r.getId(), false),
                "Ordinary employee successfully resolved reimbursement.");
        }
    }
}
