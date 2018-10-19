package com.rev.dao;

import java.sql.Timestamp;
import java.util.List;

import com.rev.pojos.ReimbTicket;

import junit.framework.TestCase;

public class ReimbTicketDAOTest extends TestCase {

	private ReimbTicketDAO rtdao = new ReimbTicketDAO();

	public void testGetAll() {
		List<ReimbTicket> reimbTickets = rtdao.getAll();
		assertEquals(5, reimbTickets.size());
	}

	public void testGetOne() {
		ReimbTicket reimbTicket = rtdao.getOne(1L);
		assertEquals(40.0, reimbTicket.getreimbAmount());
		assertEquals("Its cause Im dead homie", reimbTicket.getReimbDescription());
		assertEquals((long) 3L, (long) reimbTicket.getReimbAuthor());
		assertEquals(1, reimbTicket.getReimbStatus());
		assertEquals(6, reimbTicket.getReimbType());
	}

	public void testSave() {
		ReimbTicket reimbTicket = rtdao.getOne(1L);
		Timestamp t = new Timestamp(1000000);
		reimbTicket.setReimbResolved(t);
		reimbTicket.setReimbResolver(1L);
		reimbTicket.setReimbStatus(2);
		rtdao.save(reimbTicket);

		ReimbTicket reimbTicket2 = rtdao.getOne(1L);
		assertEquals(reimbTicket.getreimbAmount(), reimbTicket2.getreimbAmount());
		assertEquals(reimbTicket.getReimbSubmitted(),reimbTicket.getReimbSubmitted());
		assertEquals(reimbTicket.getReimbDescription(), reimbTicket2.getReimbDescription());
		assertEquals(reimbTicket.getReimbAuthor(), reimbTicket2.getReimbAuthor());
		assertEquals(reimbTicket.getReimbStatus(), reimbTicket2.getReimbStatus());
		assertEquals(reimbTicket.getReimbType(), reimbTicket2.getReimbType());
		assertEquals(reimbTicket.getReimbResolved(), reimbTicket2.getReimbResolved());
		assertEquals(reimbTicket.getReimbResolver(), reimbTicket2.getReimbResolver());
	}

	public void testSaveNew() {
		ReimbTicket reimbTicket = new ReimbTicket();
		reimbTicket.setreimbAmount(1000.00);
		Timestamp t = new Timestamp(1000000);
		reimbTicket.setReimbSubmitted(t);
		reimbTicket.setReimbDescription("This is a test ticket");
		reimbTicket.setReimbAuthor(1L);
		reimbTicket.setReimbStatus(1);
		reimbTicket.setReimbType(1);
		rtdao.saveNew(reimbTicket);
		
		List<ReimbTicket> reimbTickets = rtdao.getAll();
		assertEquals(6,reimbTickets.size());
		
		ReimbTicket reimbTicket2 = reimbTickets.get(5);
		assertEquals(reimbTicket.getreimbAmount(), reimbTicket2.getreimbAmount());
		assertEquals(reimbTicket.getReimbSubmitted(),reimbTicket.getReimbSubmitted());
		assertEquals(reimbTicket.getReimbDescription(), reimbTicket2.getReimbDescription());
		assertEquals(reimbTicket.getReimbAuthor(), reimbTicket2.getReimbAuthor());
		assertEquals(reimbTicket.getReimbStatus(), reimbTicket2.getReimbStatus());
		assertEquals(reimbTicket.getReimbType(), reimbTicket2.getReimbType());
		assertEquals(reimbTicket.getReimbResolved(), reimbTicket2.getReimbResolved());
		assertEquals(reimbTicket.getReimbResolver(), reimbTicket2.getReimbResolver());
		
		
	}

}
