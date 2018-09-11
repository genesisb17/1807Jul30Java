package com.ex.main;

import com.ex.dao.BearDao;
import com.ex.pojos.Bear;

public class Main {
	
	public Main() {
		
		Bear b = new Bear();
		
		b.setBreed("Polar Bear");
		b.setFurColor("white");
		b.setHeight(80.9);
		
		BearDao bd = new BearDao();
		bd.addBear(b);
	}
	
}
