package com.iantimothyjohnson.assignments.project1.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.iantimothyjohnson.assignments.project1.dao.SQLUserDAO;
import com.iantimothyjohnson.assignments.project1.dao.UserDAO;
import com.iantimothyjohnson.assignments.project1.pojos.User;
import com.iantimothyjohnson.assignments.project1.pojos.UserRole;
import com.iantimothyjohnson.assignments.project1.util.Passwords;

/**
 * A "driver" class that can be used to perform various utility functions. Right
 * now, it just creates a single admin user if none exists.
 * 
 * @author Ian Johnson
 */
public class Driver {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        UserDAO userDao = new SQLUserDAO();
        if (userDao.selectByUsername("admin") == null) {
            User admin = new User();
            admin.setRole(UserRole.MANAGER);
            admin.setUsername("admin");
            admin.setFirstName("Global");
            admin.setLastName("Administrator");
            admin.setEmail("admin@revature.com");
            admin.setPasswordSalt(Passwords.generateSalt());
            // TODO: make this a bit more secure (don't put password in code).
            admin.setPasswordHash(Passwords.hashPassword(
                "password".toCharArray(), admin.getPasswordSalt()));
            userDao.insert(admin);
            logger.info("Inserted new admin user.");
        } else {
            logger.info("Admin user already exists; not creating a new one.");
        }
    }
}
