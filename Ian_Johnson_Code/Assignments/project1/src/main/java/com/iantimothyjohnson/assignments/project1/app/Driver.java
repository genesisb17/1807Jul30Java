package com.iantimothyjohnson.assignments.project1.app;

import com.iantimothyjohnson.assignments.project1.dao.SQLUserDAO;

public class Driver {
    public static void main(String[] args) {
        System.out.println(SQLUserDAO.getInstance().selectAll());
    }
}
