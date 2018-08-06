package com.revature.q20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class QuestionTwenty {

	public static void displayFileInfo(String srcPath) {
		
		/*
		 * Attempt to open the file
		 * If this fails, FileReader will throw FileNotFoundException.
		 */
		try (BufferedReader br = new BufferedReader(new FileReader(srcPath));) {

			String lineRead;
			String[] splitLine;
			
			/*
			 *  Read each line from the file
			 *  If this fails, throws IOException
			 */
			while ((lineRead = br.readLine()) != null) {

				splitLine = lineRead.split(":");
				
				/*
				 * Display the information in a neat format
				 * If the file format is altered (e.g. missing state), throws ArrayIndexOutOfBoundsException
				 */
				System.out.println("Name: " + splitLine[0] + " " + splitLine[1]);
				System.out.println("Age: " + splitLine[2]);
				System.out.println("State: " + splitLine[3] + " State\n");
			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		} catch (IOException e) {
			System.out.println("IO Exception.");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("File format corrupted.");
		}
	}

	public static void main(String[] args) {
		
		// Invoke method with path of Data.txt file
		displayFileInfo("src/com/revature/q20/Data.txt");
		
	}

}
