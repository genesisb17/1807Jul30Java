package com.revature.datatypes;

public enum Days {
	MONDAY{
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
	THURSDAY{
		@Override
		public void live() {
			System.out.println("happy friday eve");
			
		}
	},
 	FRIDAY{
		@Override
		public void live() {
			System.out.println("pay day :)");
			
		}
	},
 	SATURDAY{
		@Override
		public void live() {
			System.out.println("freeken weekend");
			
		}
	},
 	SUNDAY{
		@Override
		public void live() {
			System.out.println("UGH");
			
		}
	};
	
	public abstract void live(); //just stating that this method exists
}
