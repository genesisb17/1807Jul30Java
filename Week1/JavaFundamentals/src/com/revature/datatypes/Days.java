package com.revature.datatypes;

public enum Days {
	
	/*
	 * 
	 */
	MONDAY {
		public void live() {
		System.out.println("Mondays are long days");
		}
	},
	TUESDAY {
		public void live() {
			System.out.println("Tequila Tuesday");
		}
	},
	WEDNESDAY{
		public void live() {
			System.out.println("It's Wednesday my Dude");
		}
	},
	THURSDAY {
		@Override
		public void live() {
			System.out.println("It's almost Friday!");
		}
	},
	FRIDAY {
		@Override
		public void live() {
			System.out.println("Party Hardy");
		}
	},
	SATURDAY {
		@Override
		public void live() {
			System.out.println("Sleep in ma bois");
		}
	},
	SUNDAY {
		@Override
		public void live() {
			System.out.println("Let the dread set in");
		}
	};
	
	public abstract void live();
}
