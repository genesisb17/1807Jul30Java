package com.rev.app;

import java.util.HashSet;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rev.dao.BearDao;
import com.rev.pojos.Bear;
import com.rev.pojos.Cave;
import com.rev.pojos.Honey;
import com.rev.pojos.Person;
import com.rev.util.ConnectionUtil;

public class App {

	private static BearDao bdao = new BearDao();

	public static void main(String[] args) {
		Bear b = new Bear();
		b.setBreed("Polar Bear");
		b.setFurColor("white");
		b.setHeight(80);

//		bdao.addBear(b);
		
		addBearDemo();
		b = bdao.getById(3);
		System.out.println("getById(1) returned: " + b.toString());
		
		System.out.println("\n\nFIND ALL CRITERIA");
		List<Bear> bears = bdao.findAllCriteria();
		for(Bear bear: bears) {
			System.out.println(bear);
		}
		
		System.out.println("\n\nFIND ALL QUERY");
		bears = bdao.findAllQuery("Brown");
		for(Bear bear: bears) {
			System.out.println(bear);
		}
		
		
		addPersonDemo();		

	}

	static void addBearDemo() {
		//Adding bear family
		Session session = ConnectionUtil.getSession();
		try {
			Transaction tx = session.beginTransaction();
			//Bears have honey
			Honey h1 = new Honey();
			h1.setVolume(100);
			h1.setHoneyType("Raspberry");
			
			Honey h2 = new Honey();
			h2.setVolume(150);
			h2.setHoneyType("Cherry");
			
			Honey h3 = new Honey();
			h3.setVolume(200);
			h3.setHoneyType("Chocolate");
			
			//Bears live in a cave
			Cave home = new Cave();
			home.setRent(2000);
			home.setSquareFootage(1000);
			
			//Make the bear family backwards...
			Bear cub1 = new Bear("Brown",7,"Grizzly",home,h1,null);
			Bear cub2 = new Bear("Black",8.4,"Grizzly",home,h2,null);
			HashSet<Bear> cubs = new HashSet<Bear>();
			cubs.add(cub1);
			cubs.add(cub2);
			Bear Momma = new Bear("Brown",10.5,"Grizzly",home,h3,cubs);
			
			
			//Save bear family backwards
			session.save(h1);
			session.save(h2);
			session.save(h3);
			session.save(home);
			session.save(cub1);
			session.save(cub2);
			session.save(Momma);
			tx.commit();
		} finally {
			session.close();
		}
	}
	
	static void addPersonDemo() {
		Person p = new Person();
		p.setFirstname("Raymond");
		p.setLastname("Duncan");
		try(Session session = ConnectionUtil.getSession()){
			Transaction tx = session.beginTransaction();
			session.save(p);
			tx.commit();
		}
	}
}
