package com.revature.hw1.q18;

// Allows Concrete to be an AbstractClass
public class Concrete extends AbstractClass {

	 boolean upperCase(String x) {
		
		// Will loop and turn false if it finds any lower case characters
		// Will simply return true if it finds only upper case characters
		boolean flag = false;
		for (int i = 0 ; i < x.length() ; i++) {
			if (Character.isUpperCase(x.charAt(i)));
			flag = true;
		}
		return flag;
	}

	// Converts argument to lower case
	String convertLowerCase(String y) {
		String lowerCase = y.toLowerCase();
		return lowerCase;		
	}

	// Converts argument to int then adds 10 then outputs it
	int strToInt(String z) {
		int monster = Integer.parseInt(z);
		monster += 10;
		System.out.println();
		return monster;	
	}
}

// Abstract class
abstract class AbstractClass {
	
	// Each one is used by Concrete objects
	abstract boolean upperCase(String x);
	
	abstract String convertLowerCase(String y);
	
	abstract int strToInt(String z);
}

class TestConcrete {
	
	// Creates an ob object 
	public static void main(String[] args) {
		// Creates the Concrete object with a Concrete reference point which extends to the AbstractClass
		Concrete ob = new Concrete();
		System.out.print("The results of the upper case method: ");
		
		// if-else statement to state whether the input has an uppcase in it or not.
		if (ob.upperCase("Salutation")) {
			System.out.println("This has an upper case letter in it!");
		}
		else {
			System.out.println("Why you giving me string with no upper case in it?!");
		}
		
		System.out.println();
		
		// Sends the string to the method to be converted to all lower case
		String upperCaseString = ("ISHALLNOTBECONVERETED");
		String lowerCaseString = ob.convertLowerCase(upperCaseString);
		System.out.print("Converting " + upperCaseString + " to : ");
		System.out.print(lowerCaseString);
		System.out.println("...");
		
		// Changes the string with numbers in it to int then adds to it...the madness!
		String bunny = "20";
		int monster = ob.strToInt(bunny);
		System.out.println("This poor creature in the form of a " + bunny + " has been turned into a monster!");
		System.out.println(monster + " should not exist!");
	}
}
