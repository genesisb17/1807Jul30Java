package com.iantimothyjohnson.assignments.project1.pojos;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.iantimothyjohnson.assignments.project1.util.StringUtils;

/**
 * A reimbursement request (at any stage of the process) in the ERS.
 * 
 * @author Ian Johnson
 */
public class Reimbursement implements Copiable<Reimbursement>, Identifiable {
    /**
     * The maximum amount a reimbursement can have.
     */
    public static final BigDecimal MAX_AMOUNT = new BigDecimal("99999999.99");
    /**
     * The maximum length of a description, in characters.
     */
    public static final int MAX_DESCRIPTION_LEN = 500;

    private int id;
    private ReimbursementType type;
    private ReimbursementStatus status;
    private BigDecimal amount;
    private String description;
    // TODO: figure out a way to put a receipt here.
    private int authorId;
    private int resolverId;
    @JsonFormat(shape = JsonFormat.Shape.STRING,
        pattern = "yyyy-MM-dd'T'hh:mm'Z'", timezone = "UTC")
    private OffsetDateTime submitted;
    @JsonFormat(shape = JsonFormat.Shape.STRING,
        pattern = "yyyy-MM-dd'T'hh:mm'Z'", timezone = "UTC")
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
        if (amount.compareTo(MAX_AMOUNT) > 0) {
            throw new IllegalArgumentException(
                "Amount is greater than the maximum of "
                    + StringUtils.formatMoney(amount) + ".");
        }
        if (amount.scale() > 2) {
            throw new IllegalArgumentException(
                "Fractional cents are not allowed in reimbursement amounts.");
        }
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description.length() > MAX_DESCRIPTION_LEN) {
            throw new IllegalArgumentException(
                "Description length is greater than the maximum of "
                    + MAX_DESCRIPTION_LEN + ".");
        }
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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((amount == null) ? 0 : amount.hashCode());
        result = prime * result + authorId;
        result = prime * result
            + ((description == null) ? 0 : description.hashCode());
        result = prime * result + id;
        result = prime * result
            + ((resolved == null) ? 0 : resolved.hashCode());
        result = prime * result + resolverId;
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result
            + ((submitted == null) ? 0 : submitted.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Reimbursement)) {
            return false;
        }
        Reimbursement other = (Reimbursement) obj;
        if (amount == null) {
            if (other.amount != null) {
                return false;
            }
        } else if (!amount.equals(other.amount)) {
            return false;
        }
        if (authorId != other.authorId) {
            return false;
        }
        if (description == null) {
            if (other.description != null) {
                return false;
            }
        } else if (!description.equals(other.description)) {
            return false;
        }
        if (id != other.id) {
            return false;
        }
        if (resolved == null) {
            if (other.resolved != null) {
                return false;
            }
        } else if (!resolved.equals(other.resolved)) {
            return false;
        }
        if (resolverId != other.resolverId) {
            return false;
        }
        if (status != other.status) {
            return false;
        }
        if (submitted == null) {
            if (other.submitted != null) {
                return false;
            }
        } else if (!submitted.equals(other.submitted)) {
            return false;
        }
        if (type != other.type) {
            return false;
        }
        return true;
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
