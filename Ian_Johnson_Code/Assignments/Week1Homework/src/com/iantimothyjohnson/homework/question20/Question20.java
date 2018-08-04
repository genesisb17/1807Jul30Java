package com.iantimothyjohnson.homework.question20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Create a notepad file called Data.txt and enter the following:
 * 
 * <pre>
 * Mickey:Mouse:35:Arizona
 * Hulk:Hogan:50:Virginia
 * Roger:Rabbit:22:California
 * Wonder:Woman:18:Montana
 * </pre>
 * 
 * Write a program that would read from the file and print it out to the screen
 * in the following format:
 * 
 * <pre>
 * Name: Mickey Mouse
 * Age: 35 years
 * State: Arizona State
 * </pre>
 * 
 * @author Ian Johnson
 */
public class Question20 {
	/**
	 * The path to the data file to read.
	 */
	private static final String FILEPATH = "Data.txt";

	public static void main(String[] args) {
		// We can use try-with-resources to open the file without having to
		// worry about manually closing it later:
		try (BufferedReader br = new BufferedReader(new FileReader(FILEPATH))) {
			String line;
			// We need to read the file line-by-line; each entry is a separate
			// line.
			while ((line = br.readLine()) != null) {
				// The field delimiter is a colon (':'), so we get the fields by
				// splitting around it.
				String[] fields = line.split(":");
				if (fields.length != 4) {
					// Skip this line if it doesn't have the right number of
					// fields.
					System.err.println("Bad entry: '" + line + "' does not have four fields.");
					continue;
				}

				// Let's give the fields descriptive names to make the code
				// easier to read and understand.
				String firstName = fields[0];
				String lastName = fields[1];
				// We also need to be careful about parsing the age.
				int age;
				try {
					age = Integer.parseInt(fields[2]);
				} catch (NumberFormatException e) {
					System.err.println("Bad entry: '" + fields[2] + "' is not an integer.");
					continue;
				}
				String homeState = fields[3];

				// Now we can output the entry in the desired format.
				System.out.println("Name: " + firstName + " " + lastName);
				System.out.println("Age: " + age + " years");
				System.out.println("State: " + homeState);
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			System.err.println("File not found:");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Could not read from file:");
			e.printStackTrace();
		}
	}
}
