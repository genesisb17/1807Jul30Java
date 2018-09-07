package com.revature.datatypes;

public enum Days {
	
	/*
	 * A Java Enum is a special type used to define 
	 * collections of constants. They are special classes
	 * Enums were added to Java in Java 5
	 */
	MONDAY {
		public void live() {
			System.out.println("Mondays are long days");
		}
	},
	TUESDAY{
		public void live() {
			System.out.println("Tequila/Taco Tuesdays");
		}
	},
	WEDNESDAY{
		public void live() {
			System.out.println("wear pink");
		}
	},
	THURSDAY {
		@Override
		public void live() {
			System.out.println("Happy pre friday aka friday eve");
			
		}
	},
	FRIDAY {
		@Override
		public void live() {
			System.out.println("pay day :)");
			
		}
	},
	SATURDAY {
		@Override
		public void live() {
			System.out.println("sleep til 12");
		}
	},
	SUNDAY {

		@Override
		public void live() {
			// TODO Auto-generated method stub
			
		}
	
	};
	
	public abstract void live();
}
