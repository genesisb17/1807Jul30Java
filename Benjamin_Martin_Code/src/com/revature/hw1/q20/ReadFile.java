package com.revature.hw1.q20;

import java.io.*;
public class ReadFile {

	// Has the Exception in case it gets mad
	public static void main(String[] args)throws Exception {
	  
		// Holds the path to the file where the file is at
		String file = "C:\\Users\\Benjamin Martin\\Desktop\\Data.txt";
		// Will hold each line per iteration
		String line = "";
		// Will tell the while loop what divides each item
		String splitBy = ":";
		
		// Executed in a try block in case of exceptions
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			// As long as it reads a line that has values, it will continue
			while ((line = br.readLine()) != null) {
				// Stores each line into an info variable split by :
				String[] info = line.split(splitBy);
				 
				// Will print each item in the requested format...trust me I got it to work on my machine
				System.out.println("Name: " + info[0] + " " + info[1]);
				System.out.println("Age: " + info[2]);
				System.out.println("State: " + info[3]);
				System.out.println("");
			}
		}
	}
}