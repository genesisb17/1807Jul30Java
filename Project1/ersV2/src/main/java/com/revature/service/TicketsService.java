package com.revature.service;


import java.util.List;

import com.revature.dao.Dao;
import com.revature.dao.TicketDao;
import com.revature.pojos.Tickets;

public class TicketsService {
	static Dao<Tickets, Integer> tickdao = new TicketDao();
	
	public List<Tickets> getAllTickets(){
		return tickdao.getAll();
	}
	
	public List<Tickets> getAllTickets_ofUser(int userId){
		return tickdao.getAllOfUser(userId);
	}
	
	public Tickets addTicket(Tickets t) {
		return tickdao.save(t);
	}
	
	public Tickets updateTicket(Tickets t) {
		return tickdao.update(t);
	}

}
