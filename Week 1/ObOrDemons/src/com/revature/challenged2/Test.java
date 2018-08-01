package com.revature.challenged2;

public class Test {

	public static void main(String[] args) {
		CarAccessories accessories = new CarAccessories();
		
		accessories.setRadio("yes");
		accessories.setSeats(4);
		
		System.out.println("Honda specs: \n");
		Honda hotRide = new Honda("leather", "Blue", "H");
		System.out.println(hotRide.toString());
		System.out.println("\nWill there be a radio: " + accessories.getRadio() +"\n"
				+"Number of seats: " + accessories.getSeats() +"\n");
		
		System.out.println("Toyota specs: \n");
		Toyota hotterRide = new Toyota();
		hotterRide.movingSpeed();
		hotterRide.inflatedWheels();
	}

}
