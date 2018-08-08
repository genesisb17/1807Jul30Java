package q20;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * Create a notepad file called Data.txt and enter the following:
 * 
 * 		Mickey:Mouse:35:Arizong
 * 		Hulk:Hogan:50:Virginia
 * 		Roger:Rabbit:22:California
 * 		Wonder:Woman:18:Montana
 * 
 * Write a program that would read from the file and print it out to 
 * the screen in the following format:
 * 
 * 		Name: Mickey Mouse
 * 		Age: 35 years
 * 		State: Arizona State
 */

public class Q20 {

	public static void main(String[] args) {
		
		File file = new File("src/Data.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			FileWriter writer = new FileWriter(file);
			writer.write("Mickey:Mouse:35:Arizona\n");
			writer.write("Hulk:Hogan:50:Virginia\n");
			writer.write("Roger:Rabbit:22:California\n");
			writer.write("Wonder:Woman:18:Montana\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			FileReader fr = new FileReader("src/Data.txt");
			int c;
			for (int i=0; i<4; i++) {
				for (int j=0; j<4; j++) {
					if (i==0) { System.out.print("Name:"); }
					if (i==2) { System.out.print("\nAge:"); }
					if (i==3) { System.out.print("\nState:"); }
					System.out.print(" ");
					while((c=fr.read()) != 58) {
						System.out.print((char) c);
					}
				}
			}
			fr.close();
			System.out.print("\n");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
