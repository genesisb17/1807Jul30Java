package com.iantimothyjohnson.notes;

public class Enums {
	public enum Days {
		MONDAY {
			@Override
			public void live() {
				System.out.println("Mondays are long days");
			}
		},
		TUESDAY {
			@Override
			public void live() {
				System.out.println("Tequila/Taco Tuesdays");
			}
		},
		WEDNESDAY {
			@Override
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
				System.out.println("pay day");
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
				System.out.println("");
			}
		};
		
		public abstract void live();
	}

	public static void main(String[] args) {
		Days day = Days.MONDAY;
		day.live();
	}
}
