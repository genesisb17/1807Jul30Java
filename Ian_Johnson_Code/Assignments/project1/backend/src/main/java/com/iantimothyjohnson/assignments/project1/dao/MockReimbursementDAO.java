package com.iantimothyjohnson.assignments.project1.dao;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.iantimothyjohnson.assignments.project1.pojos.Reimbursement;
import com.iantimothyjohnson.assignments.project1.pojos.ReimbursementStatus;

/**
 * A reimbursement DAO class intended for use in testing.
 * 
 * @author Ian Johnson
 */
public final class MockReimbursementDAO extends MockDAO<Reimbursement>
    implements ReimbursementDAO {
    @Override
    public boolean insert(Reimbursement r) {
        // We need to set the new ID as well as the submitted timestamp and
        // pending status.
        r.setId(getNextId());
        r.setStatus(ReimbursementStatus.PENDING);
        r.setSubmitted(OffsetDateTime.now());
        // Overwrite properties that are invalid for a newly-submitted
        // reimbursement.
        r.setResolved(null);
        r.setResolverId(0);
        entries.add(r);
        return true;
    }

    @Override
    public List<Reimbursement> selectAllByAuthor(int userId) {
        return entries.stream().filter(r -> r.getAuthorId() == userId)
            .map(r -> r.copy()).collect(Collectors.toList());
    }

    @Override
    public boolean resolve(Reimbursement r, boolean approved, int resolverId) {
        // Look up the reimbursement to resolve by ID.
        Optional<Reimbursement> optionalToResolve = entries.stream()
            .filter(re -> re.getId() == r.getId()).findFirst();
        if (!optionalToResolve.isPresent()) {
            return false;
        }

        Reimbursement toResolve = optionalToResolve.get();
        ReimbursementStatus newStatus = approved ? ReimbursementStatus.APPROVED
            : ReimbursementStatus.DENIED;
        OffsetDateTime newResolved = OffsetDateTime.now();
        toResolve.setStatus(newStatus);
        r.setStatus(newStatus);
        toResolve.setResolved(newResolved);
        r.setResolved(newResolved);
        toResolve.setResolverId(resolverId);
        r.setResolverId(resolverId);

        return true;
    }
}
