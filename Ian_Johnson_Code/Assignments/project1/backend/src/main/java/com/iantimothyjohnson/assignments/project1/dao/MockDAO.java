package com.iantimothyjohnson.assignments.project1.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.iantimothyjohnson.assignments.project1.pojos.Copiable;
import com.iantimothyjohnson.assignments.project1.pojos.Identifiable;

/**
 * An abstract class representing a mock DAO that stores data in memory. Mock
 * DAOs are not persistent, and they are meant to be used for testing rather
 * than in a production environment.
 * 
 * @author Ian Johnson
 *
 * @param <T> the underlying type of the DAO
 */
public abstract class MockDAO<T extends Copiable<T> & Identifiable>
    implements DAO<T> {
    /**
     * The "rows" or entries of the mock database.
     */
    protected List<T> entries = new ArrayList<>();
    /**
     * The next ID to use for a new entry.
     */
    private int nextId = 1;

    public MockDAO() {
    }

    @Override
    public boolean insert(T obj) {
        // Update the object's ID and insert a (deep) copy of it.
        obj.setId(getNextId());
        entries.add(obj.copy());
        return true;
    }

    @Override
    public List<T> selectAll() {
        // Return a list of deep copies of the elements in our entries list.
        return entries.stream().map(o -> o.copy()).collect(Collectors.toList());
    }

    @Override
    public T selectById(int id) {
        return entries.stream().filter(o -> o.getId() == id).findFirst()
            .map(o -> o.copy()).orElse(null);
    }

    @Override
    public boolean update(T obj) {
        // Find the object that is already present with the given ID.
        Optional<T> toUpdate = entries.stream()
            .filter(o -> o.getId() == obj.getId()).findFirst();
        if (toUpdate.isPresent()) {
            toUpdate.get().copyFrom(obj);
            return true;
        }
        return false;
    }
    
    @Override
    public boolean delete(int id) {
        return entries.removeIf(o -> o.getId() == id);
    }

    /**
     * Gets the next ID to use for a new entry inserted into this DAO.
     * 
     * @return the next ID value that should be used. This value is guaranteed
     *         to be unique among other ID values of entries in this DAO.
     */
    protected int getNextId() {
        return nextId++;
    }
}
