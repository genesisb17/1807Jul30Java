package com.revature.oopprinciples;

public class SuitJacket extends ClothingTop {

	@Override
	public void Wash() {
		System.out.println("Taking this suit to the dry-cleaner's");
		super.Wash();
	}
}
