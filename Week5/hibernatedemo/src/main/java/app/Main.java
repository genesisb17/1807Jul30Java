package app;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.BearDao;
import pojos.Bear;
import pojos.Cave;
import pojos.Honey;
import util.ConnectionUtil;

public class Main {

	public static void main(String[] args) {
		Bear b = new Bear();
		b.setBreed("Polar Bear");
		b.setFurColor("white");
		b.setHeight(80.9);
		
		BearDao bd = new BearDao();
		bd.addBear(b);
	}

	static void addBearDemo() {
		Session session = ConnectionUtil.getSession();
		try {
			Transaction tx = session.beginTransaction();
			
			Honey h1 = new Honey();
			h1.setAmount(50);
			h1.setHoney("Raspberry Honey");
			
			Honey h2 = new Honey();
			h2.setAmount(30);
			h2.setHoney("Manuka");
			
			Honey h3 = new Honey();
			h3.setAmount(30);
			h3.setHoney("Organic");
			
			Cave home = new Cave();
			home.setRent(1600);
			home.setSquareFootage(800);
			
			Bear cub1 = new Bear(1, "Brown", 70, "Polar", home, h1, null);
			Bear cub2 = new Bear(2, "White", 80, "Polar", home, h2, null);
			Set<Bear> cubs = new HashSet<Bear>();
			cubs.add(cub1);
			cubs.add(cub2);
			
			Bear poppaBear = new Bear(3, "Black", 100, "Polar", home, h3, cubs);
			
			session.save(h1);
			session.save(h2);
			session.save(h3);
			session.save(cub1);
			session.save(cub2);
			session.save(poppaBear);
			tx.commit();
		}
		finally {
			session.close();
		}
		
	}
	
}