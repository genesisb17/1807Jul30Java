package com.ex.main;

import com.ex.dao.BearDao;
import com.ex.pojos.Bear;

public class Main {

	public static void main(String[] args) {
		Bear b = new Bear();
		b.setBreed("Polar Bear");
		b.setFurColor("white");
		b.setHeight(80.9);	// inches
		
		BearDao bd = new BearDao();
		bd.addBear(b);
	}

}
