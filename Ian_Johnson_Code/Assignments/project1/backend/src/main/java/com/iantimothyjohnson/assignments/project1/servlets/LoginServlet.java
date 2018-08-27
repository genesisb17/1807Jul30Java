package com.iantimothyjohnson.assignments.project1.servlets;

import java.io.IOException;

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
import com.iantimothyjohnson.assignments.project1.dao.SQLUserDAO;
import com.iantimothyjohnson.assignments.project1.exceptions.AuthenticationFailureException;
import com.iantimothyjohnson.assignments.project1.exceptions.PermissionDeniedException;
import com.iantimothyjohnson.assignments.project1.exceptions.UserNotFoundException;
import com.iantimothyjohnson.assignments.project1.pojos.User;
import com.iantimothyjohnson.assignments.project1.service.LoginService;
import com.iantimothyjohnson.assignments.project1.service.UserService;
import com.iantimothyjohnson.assignments.project1.servlets.types.LoginCredentials;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = LogManager.getLogger();

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        logger.trace("Received GET login request.");

        // Make sure the user is logged in.
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            resp.sendError(HttpServletResponse.SC_FORBIDDEN,
                "Must be logged in to access the API.");
            return;
        }
        User actor = (User) session.getAttribute("user");
        UserService userService = new UserService(actor);
        // Update the actor value.
        try {
            actor = userService.get(actor.getId());
            session.setAttribute("user", actor);
        } catch (PermissionDeniedException | UserNotFoundException e) {
            logger.error(
                "Encountered impossible exception when getting same user information.",
                e);
        }

        // Send back the currently logged-in user.
        resp.setContentType("application/json");
        mapper.writeValue(resp.getWriter(), actor);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        logger.trace("Received POST login request.");
        try {
            LoginCredentials credentials = mapper.readValue(req.getReader(),
                LoginCredentials.class);
            if (credentials.getUsername() == null
                || credentials.getPassword() == null) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST,
                    "Must provide a username and password.");
                return;
            }

            LoginService loginService = new LoginService(new SQLUserDAO());
            User user = loginService.login(credentials.getUsername(),
                credentials.getPassword().toCharArray());
            // Log in the user using a session. The only object we store in the
            // session is the user object, which is then passed around to other
            // endpoints and used to check permissions and whatnot.
            req.getSession().setAttribute("user", user);
            resp.setContentType("application/json");
            // Return the user object to the client.
            mapper.writeValue(resp.getWriter(), user);
        } catch (AuthenticationFailureException | UserNotFoundException e) {
            resp.sendError(HttpServletResponse.SC_FORBIDDEN,
                "Incorrect username or password.");
        } catch (JsonParseException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST,
                "Malformed JSON: " + e.getMessage());
        } catch (JsonMappingException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST,
                "JSON does not match expected format: " + e.getMessage());
        }
    }
}
