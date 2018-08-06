package cjh.question20;

import java.util.List;

public class ReadsFile {
	/*
	 * Create a notepad file called Data.txt and enter the following:
	 * 		Mickey:Mouse:35:Arizona		
	 * 		Hulk:Hogan:50:Virginia
	 * 		Roger:Rabbit:22:California
	 * 		Wonder:Woman:18:Montana
	 * Write a program that would read from the file and print it out to the screen in the following format:
	 * 		Name: Mickey Mouse
	 * 		Age: 35 years
	 * 		State: Arizona State
	 */
	
	public static void main(String[] args) {
		IODAO iodao = new IODAO();
		List<Personnage> personnages = iodao.readPersonnages();
		for(Personnage p:personnages) {
			System.out.println(p.toString());
		}
	}
}
