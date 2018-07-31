package com.revature.datatypes;

/* A Java enum is a special type used to define
 * collections of constants. They are special classes
 * Enums were added to Java in Java 5
 */

public enum Days {
	MONDAY {	// we can add methods to enums
		public void live() {
			System.out.println("Mondays are long days");
		}
	},
	TUESDAY {
		public void live() {
			System.out.println("Tequila/Taco Tuesdays");
		}
	},
	WEDNESDAY {
		public void live() {
			System.out.println("Wear pink");
		}
	},
	THURSDAY {
		public void live() {
			System.out.println("Happy pre friday aka friday eve");
		}
	},
	FRIDAY {
		public void live() {
			System.out.println("pay day :");
		}
	},
	SATURDAY {
		public void live() {
			System.out.println("sleep til 12");
		}
	},
	SUNDAY {
		public void live() {
			
		}
	};	// unless you're putting something after your list, you don't need a semicolon
	
	public abstract void live();
	
}
