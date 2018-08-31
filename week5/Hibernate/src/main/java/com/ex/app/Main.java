package com.ex.app;

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
		/*
		Bear b=new Bear();
		b.setBreed("Polar");
		b.setFurColor("Brown");
		b.setHeight(80.9);
		
		BearDao a=new BearDao();
		a.addBear(b);
		
		*/
		//addBearDemo();
		
	//	BearDao bd=new BearDao();
		
		//Bear b=bd.getById(1);
		//Bear c=bd.loadById(1);
		//System.out.println(c);
		/*
		List<Bear> bears=bd.findByColor("R%");
		
		for(Bear b:bears) {
			System.out.println(b.toString());
		}
	
	}
	*/addPersonDemo();
	}	
		
	static void addPersonDemo() {
		Person p=new Person();
		p.setFirstName("Mike");
		p.setFirstName("Davis");
		try(Session session=ConnectionUtil.getSession();){
			Transaction tx=session.beginTransaction();
			session.save(p);
			tx.commit();
		}
		
	}
	
	static void addBearDemo() {
		Session session= ConnectionUtil.getSession();
		
		try {
		Transaction tx=session.beginTransaction();
		
		Honey h1=new Honey();
		h1.setAmount(23);
		h1.setHoney("rasberry");
		Honey h2=new Honey();
		h2.setAmount(43);
		h2.setHoney("organic");
		Honey h3=new Honey();
		h3.setAmount(53);
		h3.setHoney("Manuka");
		
		Cave home=new Cave();
		home.setRent(1600);
		home.setSquareFootage(800);
		
		Bear cub1=new Bear("Brown","White",20,home,null);
		Bear cub2=new Bear("Brown","Red",23,home,null);
		
		Set<Bear> cubs=new HashSet<Bear>();
		cubs.add(cub1);
		cubs.add(cub2);
		
		Bear poppaBear=new Bear("Brown","White",100,home,cubs);
		
		session.save(h1);
		session.save(h2);
		session.save(h3);
		session.save(home);
		session.save(cub1);
		session.save(cub2);
		
		session.save(poppaBear);
		tx.commit();
		}
		finally{
			
		}
		
		
	}

}
