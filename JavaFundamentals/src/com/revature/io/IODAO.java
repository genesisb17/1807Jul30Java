package com.revature.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class IODAO {
	//class used to read from and write to text file 
	
	
	void addStudent(Student student) {
		//name;email;grade
		
		//BufferedWriter
		//FileWriter
		
		/*TRY WITH RESOURCES
		 * Parameterized try block used with classes that 
		 * implement the AutoCloseable interface so that
		 * you do not need a finally block to close your
		 * resource after using it
		 */
		try (BufferedWriter bw = new BufferedWriter(
				new FileWriter("src/files/students.txt"));){
			bw.write(student.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
