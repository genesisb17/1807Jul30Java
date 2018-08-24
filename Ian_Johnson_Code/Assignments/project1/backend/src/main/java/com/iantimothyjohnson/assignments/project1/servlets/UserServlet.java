package com.iantimothyjohnson.assignments.project1.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iantimothyjohnson.assignments.project1.exceptions.PermissionDeniedException;
import com.iantimothyjohnson.assignments.project1.exceptions.UserNotFoundException;
import com.iantimothyjohnson.assignments.project1.exceptions.UsernameNotAvailableException;
import com.iantimothyjohnson.assignments.project1.pojos.User;
import com.iantimothyjohnson.assignments.project1.service.UserService;
import com.iantimothyjohnson.assignments.project1.servlets.types.UserWithPassword;

/**
 * The servlet that handles getting and creating users.
 * 
 * @author Ian Johnson
 */
@WebServlet("/users")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = LogManager.getLogger();

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        logger.trace("Got GET request for users.");

        String idParam = req.getParameter("id");
        String usernameParam = req.getParameter("username");

        if (idParam != null && usernameParam != null) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST,
                "id and username parameters are exclusive.");
            return;
        }

        // Make sure the user is logged in.
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            resp.sendError(HttpServletResponse.SC_FORBIDDEN,
                "Must be logged in to access the API.");
            return;
        }
        User actor = (User) session.getAttribute("user");
        // We make a user service with our logged-in user to service the
        // request.
        UserService userService = new UserService(actor);

        if (idParam != null) {
            try {
                int id = Integer.parseInt(idParam);
                User user = userService.get(id);
                resp.setContentType("application/json");
                mapper.writeValue(resp.getWriter(), user);
            } catch (NumberFormatException e) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST,
                    "id parameter is not a valid number.");
            } catch (PermissionDeniedException e) {
                resp.sendError(HttpServletResponse.SC_FORBIDDEN,
                    e.getMessage());
            } catch (UserNotFoundException e) {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND,
                    e.getMessage());
            }
        } else if (usernameParam != null) {
            try {
                User user = userService.get(usernameParam);
                resp.setContentType("application/json");
                mapper.writeValue(resp.getWriter(), user);
            } catch (PermissionDeniedException e) {
                resp.sendError(HttpServletResponse.SC_FORBIDDEN,
                    e.getMessage());
            } catch (UserNotFoundException e) {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND,
                    e.getMessage());
            }
        } else {
            try {
                List<User> user = userService.getAll();
                resp.setContentType("application/json");
                mapper.writeValue(resp.getWriter(), user);
            } catch (PermissionDeniedException e) {
                resp.sendError(HttpServletResponse.SC_FORBIDDEN,
                    e.getMessage());
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        logger.trace("Got POST request for users.");

        // Make sure the user is logged in.
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            resp.sendError(HttpServletResponse.SC_FORBIDDEN,
                "Must be logged in to access the API.");
            return;
        }
        User actor = (User) session.getAttribute("user");
        UserService userService = new UserService(actor);

        try {
            UserWithPassword newUser = mapper.readValue(req.getReader(),
                UserWithPassword.class);
            User user = newUser.getUser();
            userService.create(user, newUser.getPassword().toCharArray());
            // Return the new user data.
            resp.setStatus(HttpServletResponse.SC_CREATED);
            resp.setContentType("application/json");
            mapper.writeValue(resp.getWriter(), user);
        } catch (UsernameNotAvailableException e) {
            resp.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
        } catch (PermissionDeniedException e) {
            resp.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
        } catch (JsonParseException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST,
                "Malformed JSON: " + e.getMessage());
        } catch (JsonMappingException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST,
                "JSON does not match expected format: " + e.getMessage());
        }
    }
}
