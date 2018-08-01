package com.revature.challenged2;

class Honda extends Cars {

	public String logo;
	
	public Honda(String interior, String color, String logo) {
		super(interior, color);
		logo = "[H]";
		System.out.println("The old logo is: " + logo +"\n");
	}
	
	public void changeLogo(String newLogo) {
		logo = newLogo;
	}
	
	@Override
	public String toString() {
		return(super.toString()
				+ "\nThe new logo of the car is: " + "{H}");
	}
	

}
