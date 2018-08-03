package com.revature.io;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IODAO {
	//The vehicle by which we communicate with our Data Score
	//Holds no business logic, only used to hold methods
	
	//Class used to read from and write to text file
	
	public void addStudent(Student student) {
		//name;email;grade
		
		//BufferWriter
		//FileWriter
		
		/*
		 * Try with resources
		 * Parameterized try block used with object that implement the AutoClosable interface
		 * so that you d o not need a finally block to close your resource after using it
		 */
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/exampleoutputs/students.txt", true));) {
			bw.write(student.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Student> readStudents(){
		//List only takes Student objects because of the <Student>
		List<Student> students = new ArrayList<Student>();
		try(BufferedReader br = new BufferedReader(
				new FileReader("src/exampleoutputs/students.txt"))) {
			String line = null;
			while((line=br.readLine()) != null) {
				String[] studentInfo = line.split(";");
				Student temp = new Student();
				temp.setName(studentInfo[0]);
				temp.setEmail(studentInfo[1]);
				temp.setGrade(Double.parseDouble(studentInfo[2]));
				students.add(temp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return students;
	}
	
}
