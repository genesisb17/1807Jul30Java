package com.iantimothyjohnson.notes.week5.hellohibernate.driver;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.iantimothyjohnson.notes.week5.hellohibernate.pojos.Bear;
import com.iantimothyjohnson.notes.week5.hellohibernate.pojos.Cave;
import com.iantimothyjohnson.notes.week5.hellohibernate.pojos.Honey;
import com.iantimothyjohnson.notes.week5.hellohibernate.pojos.Person;
import com.iantimothyjohnson.notes.week5.hellohibernate.util.ConnectionUtil;

public class Driver {
	public static void main(String[] args) {
//		Bear b = new Bear();
//		b.setBreed("Polar Bear");
//		b.setFurColor("White");
//		b.setHeight(80.9);
//
//		BearDao bd = new BearDao();
//		Bear b = bd.loadById(1);
//		System.out.println(b.getClass());
//		System.out.println(b);

//		for (Bear b : bd.findByColor("white")) {
//			System.out.println(b);
//		}

		// addBearDemo();
		
		addPersonDemo();
	}
	
	static void addPersonDemo() {
		Person p = new Person("Ian", "Johnson");
		try (Session s = ConnectionUtil.getSession()) {
			Transaction tx = s.beginTransaction();
			s.save(p);
			tx.commit();
		}
	}

	static void addBearDemo() {
		// We want to add an entire bear family here.
		Session s = ConnectionUtil.getSession();
		try {
			Transaction tx = s.beginTransaction();

			Honey h1 = new Honey();
			h1.setAmount(50);
			h1.setFlavor("Raspberry");
			Honey h2 = new Honey();
			h2.setAmount(25);
			h2.setFlavor("Lavender");
			Honey h3 = new Honey();
			h3.setAmount(10);
			h3.setFlavor("Original");
			s.save(h1);
			s.save(h2);
			s.save(h3);

			Cave home = new Cave();
			home.setRent(1600);
			home.setSquareFootage(800);
			s.save(home);

			// We make the child bears first.
			Bear cub1 = new Bear("Brown", 70, "Polar", home, h3, null);
			Bear cub2 = new Bear("White", 80, "Polar", home, h2, null);
			Set<Bear> cubs = new HashSet<>();
			cubs.add(cub1);
			cubs.add(cub2);
			Bear papa = new Bear("Black", 100, "Polar", home, h1, cubs);

			s.save(cub1);
			s.save(cub2);
			s.save(papa);
			tx.commit();
		} finally {
			s.close();
		}
	}
}
