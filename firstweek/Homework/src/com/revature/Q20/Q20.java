package com.revature.Q20;

import java.io.File;
import java.util.Scanner;

public class Q20 {
	private Scanner x;
	
	public void openFile() {
		try {
			x = new Scanner(new File("src/files/data.txt"));
			
		}
		catch(Exception e) {
			System.out.println("could not find file");
		}
	}
	public void readFile() {
		while(x.hasNext()) {
			String a = x.nextLine();
			String b = x.nextLine();
			String c = x.nextLine();
			String d = x.nextLine();
			
			System.out.printf("%s %s %s %s",a,b,c,d);
		}
	}
	public void closeFile() {
		x.close();
	}
	
	public static void main(String[] args) {
		Q20 readFile = new Q20();
		readFile.openFile();
		readFile.readFile();
		readFile.closeFile();
	}
	
}
