package q18;

public class Concrete extends Super{

	public static void main(String[] args) {
		
		//Instantiates class to use methods
		Concrete a = new Concrete();
		
		//Declares String
		String temp = "Happy";
		
		//Method to check if there is an uppercase letter and prints result
		boolean b = a.isUpper(temp);
		System.out.println(b);
		
		//Method to make String all upper and return result
		String c = a.upper(temp);
		System.out.println(c);
		
		//Method to convert string to int, add 10, and print result.
		a.stringPlus10("20");
		
	}
	
	//Method to check if there is an uppercase letter
	@Override
	public boolean isUpper(String a) {
		//Split string into individual letters in an array
		String[] temp = a.split("");
		//For each letter
		for(String b: temp) {
			//Convert to character and check if uppercase
			if(Character.isUpperCase(b.charAt(0))) {
				//If there is even 1, return true and exit
				return true;
			}
		}
		//If there are none, return false and exit
		return false;
	}

	//Method to convert string to uppercase
	@Override
	public String upper(String a) {
		//Method to convert string to uppercase
		String b = a.toUpperCase();
		//Returns result
		return b;
	}

	//Method to convert String to int, add 10, and return
	@Override
	public void stringPlus10(String a) {
		//Takes int from String
		int b = Integer.parseInt(a);
		//Adds 10 to it
		int c = b + 10;
		//Prints result
		System.out.println(c);
	}

}
