
public enum Days
{
	MONDAY {
		public void live()
		{
			System.out.println("Mondays are long days");
		}
	},
	TUESDAY {
		public void live()
		{
			System.out.println("Taco Tuesday");
		}
	},
	WEDNESDAY {
		@Override
		public void live() {
			System.out.println("Humpday");
			
		}
	},
	THURSDAY {
		@Override
		public void live() {
			System.out.println("Something");
		}
	},
	FRIDAY {
		@Override
		public void live() {
			System.out.println("Get down on Friday");
		}
	}, 
	SATURDAY {
		@Override
		public void live() {
			System.out.println("Movie Day");
		}
	},
	SUNDAY {
		@Override
		public void live() {
			System.out.println("Church");
		}
	};
	
	public abstract void live();
}


