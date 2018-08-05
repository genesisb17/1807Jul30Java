package com.revature.hw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadAFile {

	public static void main(String[] args) throws Exception {
		String tempString;
		String []splitString;
		File myFile = new File("C:\\Users\\Darius\\Documents\\temp\\Data.txt");
			
		BufferedReader br = new BufferedReader(new FileReader(myFile));
			
		while((tempString = br.readLine()) != null) {
			splitString = tempString.split(":", 4);
			System.out.println("Name: " + splitString[0] + " " + splitString[1]);
			System.out.println("Age: " + splitString[2]);
			System.out.println("State: " + splitString[3] + "\n");

		}
	}

}
