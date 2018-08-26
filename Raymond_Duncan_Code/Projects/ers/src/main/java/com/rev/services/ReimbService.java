package com.rev.services;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import com.rev.dao.ReimbTicketDAO;
import com.rev.pojos.ReimbTicket;
import com.rev.pojos.User;
import com.rev.utils.AuthLevel;

public class ReimbService {

	private ReimbTicketDAO rtdao = new ReimbTicketDAO();

	public List<ReimbTicket> getReimbs(User u) {
		List<ReimbTicket> reimbTickets = null;
		AuthLevel authLevel = AuthLevel.getAuthLevel(u);
		switch (authLevel) {
		case ADMIN:
			reimbTickets = rtdao.getAll();
			break;
		case MANAGER:
			reimbTickets = rtdao.getAll();
			break;
		case EMPLOYEE:
			reimbTickets = rtdao.getAll(u);
			break;
		default:
			break;
		}
		return reimbTickets;
	}

	public ReimbTicket createReimbTicket(User u, double amount, String description, ReimbType type) {
		ReimbTicket reimbTicket = new ReimbTicket();
		reimbTicket.setreimbAmount(amount);
		reimbTicket.setReimbSubmitted(Timestamp.valueOf(LocalDateTime.now()));
		reimbTicket.setReimbResolved(null);
		reimbTicket.setReimbDescription(description);
		reimbTicket.setReceipt(null);
		reimbTicket.setReimbAuthor(u.getUserID());
		reimbTicket.setReimbResolver(null);
		reimbTicket.setReimbStatus(ReimbStatus.PENDING.ordinal());
		reimbTicket.setReimbType(type.ordinal());
		return rtdao.saveNew(reimbTicket); // If the SQL insert is successful, it will return the new ReimbTicket
											// object!
	}

	public ReimbTicket approveReimbTicket(ReimbTicket t, User u) {
		if (t.getReimbAuthor() != u.getUserID() && AuthLevel.getAuthLevel(u).compareTo(AuthLevel.EMPLOYEE) < 0 && t.getReimbAuthor() == null) {
			//If the resolver is not the author, and has the authorization to resolve reimbTickets, and the ticket is not resolved
			t.setReimbResolved(Timestamp.valueOf(LocalDateTime.now()));
			t.setReimbAuthor(u.getUserID());
			t.setReimbStatus(ReimbStatus.APPROVED.ordinal());
			return rtdao.save(t); // If the SQL update is successful, it will return the updated ReimbTicket
		}
		return null;
	}

	public ReimbTicket rejectReimbTicket(ReimbTicket t, User u) {
		if (t.getReimbAuthor() != u.getUserID() && AuthLevel.getAuthLevel(u).compareTo(AuthLevel.EMPLOYEE) < 0 && t.getReimbAuthor() == null) {
			//If the resolver is not the author, and has the authorization to resolve reimbTickets, and the ticket is not resolved
			t.setReimbResolved(Timestamp.valueOf(LocalDateTime.now()));
			t.setReimbAuthor(u.getUserID());
			t.setReimbStatus(ReimbStatus.REJECTED.ordinal());
			return rtdao.save(t); // If the SQL update is successful, it will return the updated ReimbTicket
		}
		return null;
	}
	
	public ReimbTicket rescindReimbTicket(ReimbTicket t, User u) {
		if (t.getReimbAuthor() != u.getUserID() && t.getReimbAuthor() == null) {
			//If the resolver is the author, and the ticket is not resolved
			t.setReimbResolved(Timestamp.valueOf(LocalDateTime.now()));
			t.setReimbAuthor(u.getUserID());
			t.setReimbStatus(ReimbStatus.RESCINDED.ordinal());
			return rtdao.save(t); // If the SQL update is successful, it will return the updated ReimbTicket
		}
		return null;
	}

}
