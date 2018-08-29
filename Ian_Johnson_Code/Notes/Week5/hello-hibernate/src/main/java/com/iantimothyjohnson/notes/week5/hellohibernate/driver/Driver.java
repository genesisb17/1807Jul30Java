package com.iantimothyjohnson.notes.week5.hellohibernate.driver;

import com.iantimothyjohnson.notes.week5.hellohibernate.dao.BearDao;
import com.iantimothyjohnson.notes.week5.hellohibernate.pojos.Bear;

public class Driver {
	public static void main(String[] args) {
		Bear b = new Bear();
		b.setBreed("Polar Bear");
		b.setFurColor("white");
		b.setHeight(80.9);
		
		BearDao bd = new BearDao();
		bd.addBear(b);
	}
}
