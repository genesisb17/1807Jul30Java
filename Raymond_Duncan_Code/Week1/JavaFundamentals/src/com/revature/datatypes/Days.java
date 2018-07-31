package com.revature.datatypes;

public enum Days {
	/*
	 * A Java Enum is a special type used to define
	 * collections of constants. They are special types of classes
	 * 
	 * They were integrated in Java 5
	 */
	MONDAY {
		public void live() {
			System.out.println("Mondays are long days");
		}
	},
	TUESDAY {
		public void live() {
			System.out.println("tequila/Taco Tuesdays");
		}
	},
	WEDNESDAY {
		public void live() {
			System.out.println("Humpdayyyy! Yeah!!!");
		}
	},
	THURSDAY {
		public void live() {
			System.out.println("On Thursday, we wait for Fridays");
		}
	},
	FRIDAY {
		@Override
		public void live() {
			System.out.println("Pay day!");
		}
	},
	SATURDAY {
		@Override
		public void live() {
			System.out.println("Saturdays are for sleeping in");
		}
	},
	SUNDAY {
		@Override
		public void live() {
			System.out.println("Time to get ready for mondays :(");
		}
	};
	
	public abstract void live();
}
