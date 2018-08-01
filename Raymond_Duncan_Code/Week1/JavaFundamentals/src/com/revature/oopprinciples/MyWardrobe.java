package com.revature.oopprinciples;

public class MyWardrobe {

	public static void main(String[] args) {
		ClothingTop[] tops = new ClothingTop[5];
		tops[0] = new TShirt(Color.BLUE);
		tops[1] = new TShirt(Color.BLACK, Pattern.STRIPED);
		tops[2] = new SuitJacket();
		tops[3] = new SuitJacket(Color.WHITE);
		tops[4] = new SuitJacket(Color.BLUE, Pattern.STRIPED);
	
		for(ClothingTop c:tops) {
			c.Wear();
		}
	
		for(ClothingTop c:tops) {
			c.Wash();
		}
	}
}
