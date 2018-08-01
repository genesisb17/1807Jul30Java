package com.iantimothyjohnson.notes;

@SuppressWarnings("unused")
public class OOPStatics {
	// You can have static blocks of code that execute when the class loads.
	static {
		System.out.println("In block before main.");
	}

	// Apparently these things are like static blocks.
	static MoreStatics stuff = new MoreStatics();
	
	private static class MoreStatics {
		static {
			System.out.println("Loaded other class.");
		}
	}

	public static void main(String[] args) {
		System.out.println("In main method.");
		// Static blocks only run when the class is first used (loaded).
		MoreStatics more = new MoreStatics();
		MoreStatics evenMore = new MoreStatics();
	}
	
	// All the static blocks are executed in order BEFORE the main method is
	// executed.
	static {
		System.out.println("In block after main.");
	}
}
