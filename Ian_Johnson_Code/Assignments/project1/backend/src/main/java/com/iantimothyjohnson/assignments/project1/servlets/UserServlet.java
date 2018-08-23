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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iantimothyjohnson.assignments.project1.exceptions.PermissionDeniedException;
import com.iantimothyjohnson.assignments.project1.exceptions.UserNotFoundException;
import com.iantimothyjohnson.assignments.project1.pojos.User;
import com.iantimothyjohnson.assignments.project1.service.UserService;

@WebServlet("/users")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = LogManager.getLogger();
    
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        logger.trace("Got request for users.");

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
}
