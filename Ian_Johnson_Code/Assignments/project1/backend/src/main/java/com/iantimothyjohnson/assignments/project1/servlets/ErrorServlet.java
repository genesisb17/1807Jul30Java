package com.iantimothyjohnson.assignments.project1.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iantimothyjohnson.assignments.project1.servlets.types.ServletMessage;

/**
 * A servlet to handle errors by sending some JSON in a response.
 * 
 * @author Ian Johnson
 */
@WebServlet("/error")
public class ErrorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = LogManager.getLogger();

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        handleError(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        handleError(req, resp);
    }

    private void handleError(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        int statusCode = (Integer) req
            .getAttribute("javax.servlet.error.status_code");
        String message = (String) req
            .getAttribute("javax.servlet.error.message");
        Throwable exception = (Throwable) req
            .getAttribute("javax.servlet.error.exception");
        if (exception != null) {
            logger.error("Responding with error due to exception.", exception);
        }

        if (message.length() == 0) {
            message = "Undisclosed error.";
        }
        ServletMessage err = new ServletMessage(statusCode, message);
        resp.setContentType("application/json");
        logger.info("Responding with error: " + err);
        mapper.writeValue(resp.getWriter(), err);
    }
}
