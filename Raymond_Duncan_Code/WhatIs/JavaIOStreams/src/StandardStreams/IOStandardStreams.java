package StandardStreams;

import java.io.IOException;
import java.io.InputStreamReader;

public class IOStandardStreams {

	public static void main(String[] args) throws IOException {
		/*
		 * This program will listen for when the user enters the letter q
		 */
		InputStreamReader cin = null;

		try {
			cin = new InputStreamReader(System.in);
			char c;
			do {
				c = (char) cin.read();
				System.out.println(c);
			} while (c != 'q');
		} finally {
			if (cin != null) {
				cin.close();
			}
		}
	}

}
