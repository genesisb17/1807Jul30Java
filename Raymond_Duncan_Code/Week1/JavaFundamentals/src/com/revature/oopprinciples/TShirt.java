package com.revature.oopprinciples;

public class TShirt extends ClothingTop {
	
	public TShirt() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TShirt(Color color1, Color color2, Pattern pattern) {
		super(color1, color2, pattern);
		// TODO Auto-generated constructor stub
	}

	public TShirt(Color color1, Pattern pattern) {
		super(color1, pattern);
		// TODO Auto-generated constructor stub
	}

	public TShirt(Color color1) {
		super(color1);
		// TODO Auto-generated constructor stub
	}

	public TShirt(Pattern pattern) {
		super(pattern);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Wash() {
		super.Wash();
		System.out.println("Into the washer you go");
	}
}
