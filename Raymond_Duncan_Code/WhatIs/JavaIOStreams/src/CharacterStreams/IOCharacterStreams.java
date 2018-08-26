package CharacterStreams;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOCharacterStreams {
	
	public static void main(String[] args) {
		FileReader in = null;
		FileWriter out = null;
		
		try {
			in = new FileReader("./input.txt");
			out = new FileWriter("src/CharacterStreams/output.txt");
			
			int c;
			while((c = in.read()) != -1) {
				System.out.println(c);
				out.write(c);
			}
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
