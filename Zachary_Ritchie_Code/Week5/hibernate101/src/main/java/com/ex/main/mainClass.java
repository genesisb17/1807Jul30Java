package com.ex.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ex.dao.BearDao;
import com.ex.pojos.Bear;
import com.ex.pojos.Cave;
import com.ex.pojos.Honey;
import com.ex.util.ConnectionUtil;

public class mainClass {

	public static void main(String[] args) 
	{
		Bear b = new Bear();
		b.setBreed("Polar Bear");
		b.setFurColor("White");
		b.setHeight(80.9);
		
		BearDao bd = new BearDao();
		bd.addBear(b);
	}

	
	static void addBearDemo()
	{
		Session session = ConnectionUtil.getSession();
		
		try
		{
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
			
			//fammily home
			Cave home = new Cave();
			home.setRent(1600);
			home.setSquareFootage(800);
			
			//make bears. make child bears first
			//Bear cub1 = new Bear("Brown", "Polar", 70, home, h1, null);
			
		}
		finally
		{
			session.close();
		}
		
		
	}
}
