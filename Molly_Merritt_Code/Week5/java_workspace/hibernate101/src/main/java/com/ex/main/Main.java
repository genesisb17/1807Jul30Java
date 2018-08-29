package com.ex.main;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ex.dao.BearDao;
import com.ex.pojos.Bear;
import com.ex.pojos.Cave;
import com.ex.pojos.Honey;
import com.ex.pojos.Person;
import com.ex.util.ConnectionUtil;

public class Main {

	public static void main(String[] args) {
//		Bear b = new Bear();
//		b.setBreed("Polar Bear");
//		b.setFurColor("white");
//		b.setHeight(80.9);	// inches
//		
		BearDao bd = new BearDao();
//		bd.addBear(b);
		
//		addBearDemo();
//		Bear b = bd.getById(1);
//		System.out.println(b);
		List<Bear> bears = bd.findAllCriteria();
		for(Bear b : bears) {
			System.out.println(b);
		}
	}
	
	static void addPersonDemo() {
		Person p  = new Person();
		p.setFirstName("Genesis");
		p.setLastName("Bonds");
		try(Session s = ConnectionUtil.getSession()) {
			Transaction tx = s.beginTransaction();
			s.save(p);
			tx.commit();
		}
	}
	
	static void addBearDemo() {
		// adding bear family
		Session session = ConnectionUtil.getSession();
		try {
			Transaction tx = session.beginTransaction();
			
			Honey h1 = new Honey();
			h1.setAmount(50);
			h1.setHoney("Raspberry Honey");
			
			Honey h2 = new Honey();
			h2.setAmount(25);
			h2.setHoney("Organic");
			
			Honey h3 = new Honey();
			h3.setAmount(30);
			h3.setHoney("Manuka Honey");
			
			// family home
			Cave home = new Cave();
			home.setRent(1600);
			home.setSquareFootage(800);
			
			// make bears. make child bears first
			Bear cub1 = new Bear("Brown", 70, "Polar", home, h1, null);
			Bear cub2 = new Bear("White", 80, "Polar", home, h2, null);
			Set<Bear> cubs = new HashSet<Bear>();
			cubs.add(cub1);
			cubs.add(cub2);
			Bear poppaBear = new Bear("Black", 100, "Polar", home, h3, cubs);
			
			session.save(h1);
			session.save(h2);
			session.save(h3);
			session.save(home);
			session.save(cub1);
			session.save(cub2);
			session.save(poppaBear);
			tx.commit();
		} finally {
			session.close();
		}
	}

}
