package com.iantimothyjohnson.assignments.project1.pojos;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

/**
 * A reimbursement request (at any stage of the process) in the ERS.
 * 
 * @author Ian Johnson
 */
public class Reimbursement implements Copiable<Reimbursement>, Identifiable {
    private int id;
    private ReimbursementType type;
    private ReimbursementStatus status;
    private BigDecimal amount;
    private String description;
    // TODO: figure out how to represent the receipt in here.
    private int authorId;
    private int resolverId;
    private OffsetDateTime submitted;
    private OffsetDateTime resolved;

    public Reimbursement() {
    }

    public Reimbursement(Reimbursement r) {
        copyFrom(r);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public ReimbursementType getType() {
        return type;
    }

    public void setType(ReimbursementType type) {
        this.type = type;
    }

    public ReimbursementStatus getStatus() {
        return status;
    }

    public void setStatus(ReimbursementStatus status) {
        this.status = status;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getResolverId() {
        return resolverId;
    }

    public void setResolverId(int resolverId) {
        this.resolverId = resolverId;
    }

    public OffsetDateTime getSubmitted() {
        return submitted;
    }

    public void setSubmitted(OffsetDateTime submitted) {
        this.submitted = submitted;
    }

    public OffsetDateTime getResolved() {
        return resolved;
    }

    public void setResolved(OffsetDateTime resolved) {
        this.resolved = resolved;
    }

    @Override
    public String toString() {
        return "Reimbursement [id=" + id + ", type=" + type + ", status="
            + status + ", amount=" + amount + ", description=" + description
            + ", authorId=" + authorId + ", resolverId=" + resolverId
            + ", submitted=" + submitted + ", resolved=" + resolved + "]";
    }

    @Override
    public Reimbursement copy() {
        return new Reimbursement(this);
    }

    @Override
    public void copyFrom(Reimbursement r) {
        id = r.id;
        type = r.type;
        status = r.status;
        amount = r.amount;
        description = r.description;
        // TODO: initialize receipt field here.
        authorId = r.authorId;
        resolverId = r.resolverId;
        submitted = r.submitted;
        resolved = r.resolved;
    }
}
