package Q20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class readWriteToFile {

	public static void main(String[] args) 
	{
		try(BufferedReader br = new BufferedReader(new FileReader("assignment1/Q20/Data.txt")))
		{
			
			String line = null;
			while((line=br.readLine()) != null)
			{
				String[] dataInfo = line.split(":");

				System.out.println("Name: " + dataInfo[0] + " " + dataInfo[1]);
				System.out.println("Age: " + dataInfo[2] + " years");
				System.out.println("State: " + dataInfo[3] + " State");
				System.out.println();
							
			}			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
