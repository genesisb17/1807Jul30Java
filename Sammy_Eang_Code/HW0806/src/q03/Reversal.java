package q03;

public class Reversal {

	public static void main(String[] args) {
		
		//Calls function which takes a String
		reverse("racecar");
		
	}
	
	public static void reverse(String normal) {
		
		//Converts String into array
		String[] strArray = normal.split("");
		
		//Creates a new String Array the same size the String parameter
		String[] reStringArray = new String[strArray.length];
		
		//Sets a reverse counter for the String Array
		int aCount = strArray.length - 1;
		
		//Loops through each "letter" of the new String Array
		for(int count = 0; count < strArray.length; count++) {
			
			//The first "letter" of the new String array is equal to the last "letter" of the passed String Array
			reStringArray[count] = strArray[aCount];
			
			//Lowers the original String Array count
			--aCount;
		}
		
		//Takes the new String Array and joins it together
		String reString = String.join("", reStringArray);
		
		//Prints out the reverse String
		System.out.println(reString);
	}
	
	//Done!

}
