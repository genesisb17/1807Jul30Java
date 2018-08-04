package q20;

import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class FormatText {

	public static void main(String[] args) throws IOException {
		
		//Gets file
		File file = new File("src/q20/Data.txt");
		//Declares stringbuilder object that is the length of the characters in the file
		StringBuilder fileContents = new StringBuilder((int)file.length());
		//Scanner scans file
		Scanner scan = new Scanner(file);
		//Finds the separating lines
	    String lineSeparator = System.getProperty("line.separator");
		
	    //For each new line
		while(scan.hasNextLine()) {
			//Scan the contents of the line and add it to the string builder
		    fileContents.append(scan.nextLine() + lineSeparator);
		}
		
		//Cast that string builder into a String
		String storeRaw = new String(fileContents);
		//For each new line, make the contents of that line a new String in an array
		String[] storeRawArray = storeRaw.split("\n");
		
		//For each string in that array
		for(String part: storeRawArray) {
			//Create a new array with info separated by ":"
			String[] storeTempInfo = part.split(":");
			//Print first two indexes of that array, aka first and last name
			System.out.println("Name: " + storeTempInfo[0] + " " + storeTempInfo[1]);
			//Print 3rd index, aka age
			System.out.println("Age: " + storeTempInfo[2] + " years");
			//Print 4th index, aka state. Also remove new line at end of each State via substring
			System.out.println("State: " + storeTempInfo[3].substring(0, storeTempInfo[3].length() - 1) + " State");
			//New line between entries for organization
			System.out.println("");
		}
	}
	
	
}
