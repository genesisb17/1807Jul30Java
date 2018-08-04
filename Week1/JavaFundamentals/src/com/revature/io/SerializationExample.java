package com.revature.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationExample {

	public static void main(String[] args) {
		Student s = new Student("Sammy", "sam@eang.com", 100);
	}
	
	static void serializeObject(Object o) {
		try(ObjectOutputStream oos = 
				new ObjectOutputStream(
						new FileOutputStream("src/exampleoutput/serial.txt"))) {
			oos.writeObject(o);
		} catch (FileNotFoundException e ) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static Object deserializeObject() {
		return null;
	}

}

