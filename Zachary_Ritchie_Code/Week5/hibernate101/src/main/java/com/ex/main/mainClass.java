package com.ex.main;

import com.ex.dao.BearDao;
import com.ex.pojos.Bear;

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

}
