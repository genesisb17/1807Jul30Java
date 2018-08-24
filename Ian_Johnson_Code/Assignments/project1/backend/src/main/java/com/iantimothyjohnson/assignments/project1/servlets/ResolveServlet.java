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
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.iantimothyjohnson.assignments.project1.exceptions.PermissionDeniedException;
import com.iantimothyjohnson.assignments.project1.exceptions.ReimbursementAlreadyResolvedException;
import com.iantimothyjohnson.assignments.project1.exceptions.ReimbursementNotFoundException;
import com.iantimothyjohnson.assignments.project1.pojos.Reimbursement;
import com.iantimothyjohnson.assignments.project1.pojos.User;
import com.iantimothyjohnson.assignments.project1.service.ReimbursementService;
import com.iantimothyjohnson.assignments.project1.servlets.types.ReimbursementResolution;

/**
 * The servlet that handles resolving reimbursements.
 * 
 * @author Ian Johnson
 */
@WebServlet("/resolve")
public class ResolveServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = LogManager.getLogger();

    private final ObjectMapper mapper = new ObjectMapper()
        .registerModule(new JavaTimeModule());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        logger.trace("Got POST request for reimbursement resolution.");

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

        try {
            ReimbursementResolution rr = mapper.readValue(req.getReader(),
                ReimbursementResolution.class);
            Reimbursement r = reimbursementService.resolve(rr.getId(),
                rr.isApproved());
            // We should return the new reimbursement data to the user.
            resp.setContentType("application/json");
            mapper.writeValue(resp.getWriter(), r);
        } catch (PermissionDeniedException e) {
            resp.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
        } catch (ReimbursementNotFoundException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
        } catch (ReimbursementAlreadyResolvedException e) {
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
