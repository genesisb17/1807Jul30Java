package com.revature.oopprinciples;

public class SuitJacket extends ClothingTop {

	public SuitJacket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SuitJacket(Color color1, Color color2, Pattern pattern) {
		super(color1, color2, pattern);
		// TODO Auto-generated constructor stub
	}

	public SuitJacket(Color color1, Pattern pattern) {
		super(color1, pattern);
		// TODO Auto-generated constructor stub
	}

	public SuitJacket(Color color1) {
		super(color1);
		// TODO Auto-generated constructor stub
	}

	public SuitJacket(Pattern pattern) {
		super(pattern);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Wash() {
		super.Wash();
		System.out.println("Taking this suit jacket to the dry-cleaner's");
	}
}
