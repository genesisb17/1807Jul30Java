package com.revature.oopprinciples;

public class TShirt extends ClothingTop {
	
	@Override
	public void Wash() {
		System.out.println("Into the washer you go");
		super.Wash();
	}
}
