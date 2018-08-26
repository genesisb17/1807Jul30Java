package ByteStreams;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOByteStreams {
	
	public static void main(String[] args) {
		FileInputStream in = null;
		FileOutputStream out = null;
		
		try {
			in = new FileInputStream("./input.txt");
			out = new FileOutputStream("src/ByteStreams/output.txt");
			
			int b;
			while((b = in.read()) != -1) {
				System.out.println(b);
				out.write(b);
			}
		} catch(IOException ioe){
			ioe.printStackTrace();
		}
	}

}
