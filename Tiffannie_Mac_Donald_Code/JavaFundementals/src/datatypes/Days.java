package datatypes;

public enum Days {
	MONDAY {
		public void live() {
			System.out.println("Mondays are long days");
		}
	},
	TUESDAY{
		public void live() {
			System.out.println("/Taco Tuesday");
		}
	},
	WEDNESDAY{
		public void live() {
			System.out.println("On wednesdays we wear pink");
		}
	},
	THURSDAY{
		public void live() {
			System.out.println("almost there");
		}
	},
	FRIDAY{
		public void live() {
			System.out.println("whoooo");
		}
	},
	SATURDAY{
		public void live() {
			System.out.println("nap day");
		}
	},
	SUNDAY{
		public void live() {
			System.out.println("Go to church");
		}
	};
	
	public abstract void live();
}
