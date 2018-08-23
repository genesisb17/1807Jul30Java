package com.iantimothyjohnson.assignments.project1.servlets.types;

/**
 * A class that represents a basic message from the server to the client.
 * 
 * @author Ian Johnson
 */
public class ServletMessage {
    private int statusCode;
    private String message;

    public ServletMessage(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ServletMessage [statusCode=" + statusCode + ", message=" + message
            + "]";
    }
}
