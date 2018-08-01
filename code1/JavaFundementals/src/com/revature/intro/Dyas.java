package com.revature.intro;

public enum Dyas {
	MONDAY {
		public void live() {
			System.out.println("Mondays require suits and formal wear");
		}
	},
	TUESDAY {
		public void live() {
			System.out.println("Tuesdays we wear business casual");
		}
	},
	WEDNESDAY {
		public void live() {
			System.out.println("Tuesdays we wear business casual");
		}
	},
	THURSDAY {

		@Override
		public void live() {
			System.out.println("thursday is not that great");
		}
	},
	FRIDAY {
		@Override
		public void live() {
			System.out.println("Fridays are great");
		}
	},
	SATURDAY {
		@Override
		public void live() {
			System.out.println("Saturdays are for the boys");
		}
	},
	SUNDAY {
		@Override
		public void live() {
			System.out.println("Sunday funday");
		}
	};

	public abstract void live();
}
