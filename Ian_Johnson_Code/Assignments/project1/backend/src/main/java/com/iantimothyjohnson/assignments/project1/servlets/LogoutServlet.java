package com.iantimothyjohnson.assignments.project1.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iantimothyjohnson.assignments.project1.servlets.types.ServletMessage;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        // Try to get the user's session and log them out if they have one.
        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.sendError(HttpServletResponse.SC_FORBIDDEN, "Not logged in.");
        } else {
            session.invalidate();
            resp.setContentType("application/json");
            mapper.writeValue(resp.getWriter(), new ServletMessage(
                HttpServletResponse.SC_OK, "Logout successful."));
        }
    }
}
