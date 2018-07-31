package com.revature.datatypes;

public enum Days {
	MONDAY {
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
	THURSDAY{
		public void live() {
			System.out.println("Happy pre Friday a.k.a Friday Eve");
		}
	},
	FRIDAY{
		public void live() {
			System.out.println("WOOT");
		}
	},
	SATURDAY{
		public void live() {
			System.out.println("Sleep til 12");
		}
	},
	SUNDAY{
		public void live() {
			System.out.println("Study");
		}
	}
}
