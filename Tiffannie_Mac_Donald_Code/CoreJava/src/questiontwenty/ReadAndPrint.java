package questiontwenty;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadAndPrint {
/*Create a note pad file called Data.txtand enter the following: 
 * 
 * Mickey:Mouse:35:Arizona
 * Hulk:Hogan:50:Virginia
 * Roger:Rabbit:22:California
 * Wonder:Woman:18:Montana
 * 
 * Write a program that would read from the file and print it out to the screen in the
 *  following format:Name: Mickey MouseAge: 35 yearsState: Arizona State
 * 
 */
	public static void main(String[] args) {
		
		ArrayList<Character> characters = characters();
		
		for(Character c : characters) {
			System.out.println("Name: " + c.getFirstName()+" "+c.getLastName());
			System.out.println("Age: " + c.getAge() + " years");
			System.out.println("State: " + c.getState() + " State");
			System.out.println("\n");
		}
	}
	
	public static ArrayList<Character> characters(){
		ArrayList<Character> characters = new ArrayList<Character>();
		
		try(BufferedReader br = new BufferedReader(
				new FileReader("src/files/characters.txt"))){
			String line = null;
			
			while((line=br.readLine()) != null) {
				
				String[] characterInfo = line.split(":");
				
				Character temp = new Character();
				temp.setFirstName(characterInfo[0]);
				temp.setLastName(characterInfo[1]);
				temp.setAge(Integer.parseInt(characterInfo[2]));
				temp.setState(characterInfo[3]);
				characters.add(temp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return characters;
	}

}
