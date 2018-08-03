package q05;

public class Sub {
	
	public static void main(String[] args) {
	
		subS("Sammy", 4);
		
	}
	
	static void subS(String s, int num) {
		
		//Converts String into array
				String[] strArray = s.split("");
				
				//Creates a new String Array the same size the String parameter
				String[] reStringArray = new String[num];
				
				//Loops through each "letter" of the new String Array
				for(int count = 0; count < num; count++) {
					
					//The first "letter" of the new String array is equal to the last "letter" of the passed String Array
					reStringArray[count] = strArray[count];
					
				}
				
				//Takes the new String Array and joins it together
				String reString = String.join("", reStringArray);
				
				//Prints out the reverse String
				System.out.println(reString);
	}
}
