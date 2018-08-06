package com.revature.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class IODAO {
	
	//class used to read from and write to text file
	
	void addStudent(Student student) { //whats the point of this function?
		//name;email;grade
		
		//BufferedWriter
		//FileWriter
		
		//TRY WITH RESOURCES
		//Parameterized try block used with classes that implement
		//the AutoCloseable interface so that you do not need a finally block to 
		//close your resource after using it
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/files/students.txt", true));){
			bw.write(student.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	
	List<Student> readStudents(){
		//creates an object of students with type ArrayList
		//Possible to Link type because ArrayList implements it
		
		List<Student> students = new ArrayList<Student>();
		
		
		try(BufferedReader br = new BufferedReader(
				new FileReader("src/files/students.txt"))){
			String line = null; //what's the point of initializing it to null?
			while((line = br.readLine()) != null) {
				String[] studentInfo = line.split(";");
				Student temp = new Student();
				temp.setName(studentInfo[0]);
				temp.setEmail(studentInfo[1]);
				temp.setGrade(Double.parseDouble(studentInfo[2]));
				students.add(temp);
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return students;
	}
	
}
