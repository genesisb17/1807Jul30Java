package com.iantimothyjohnson.assignments.project1.dao;

import java.util.List;

import com.iantimothyjohnson.assignments.project1.pojos.Reimbursement;

public class SQLReimbursementDAO implements ReimbursementDAO {
    @Override
    public boolean insert(Reimbursement obj) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Reimbursement> selectAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Reimbursement selectById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(Reimbursement obj) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Reimbursement> selectAllByAuthor(int userId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean resolve(Reimbursement r, boolean approved, int resolverId) {
        // TODO Auto-generated method stub
        return false;
    }
}
