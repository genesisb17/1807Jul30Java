package com.iantimothyjohnson.assignments.project1.servlets;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.iantimothyjohnson.assignments.project1.exceptions.PermissionDeniedException;
import com.iantimothyjohnson.assignments.project1.pojos.Reimbursement;
import com.iantimothyjohnson.assignments.project1.pojos.ReimbursementStatus;
import com.iantimothyjohnson.assignments.project1.pojos.User;
import com.iantimothyjohnson.assignments.project1.service.ReimbursementService;

@WebServlet("/reimbursements")
public class ReimbursementServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = LogManager.getLogger();

    private final ObjectMapper mapper = new ObjectMapper()
        .registerModule(new JavaTimeModule());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        logger.trace("Got request for reimbursements.");
        String authorParam = req.getParameter("author");
        String statusParam = req.getParameter("status");

        // Make sure the user is logged in.
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            resp.sendError(HttpServletResponse.SC_FORBIDDEN,
                "Must be logged in to access the API.");
            return;
        }
        User actor = (User) session.getAttribute("user");
        ReimbursementService reimbursementService = new ReimbursementService(
            actor);

        // We need to get the requests for the given user (or all requests) and
        // filter them by status.
        try {
            List<Reimbursement> reimbursements;
            if (authorParam != null) {
                try {
                    int userId = Integer.parseInt(authorParam);
                    reimbursements = reimbursementService.getAllForUser(userId);
                } catch (NumberFormatException e) {
                    resp.sendError(HttpServletResponse.SC_BAD_REQUEST,
                        "author parameter is not a valid number (user ID).");
                    return;
                }
            } else {
                reimbursements = reimbursementService.getAll();
            }
            // Filter by status.
            if (statusParam != null) {
                try {
                    reimbursements = reimbursements.stream()
                        .filter(r -> r.getStatus() == ReimbursementStatus
                            .valueOf(statusParam.toUpperCase()))
                        .collect(Collectors.toList());
                } catch (IllegalArgumentException e) {
                    resp.sendError(HttpServletResponse.SC_BAD_REQUEST,
                        "status parameter is not a valid reimbursement status.");
                }
            }

            // Respond with reimbursements.
            resp.setContentType("application/json");
            mapper.writeValue(resp.getWriter(), reimbursements);
        } catch (PermissionDeniedException e) {
            resp.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
        }
    }
}
