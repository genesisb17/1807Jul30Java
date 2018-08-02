package io;

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
	void addStudent(Student student) {
		//name;email;grade
		
		//BufferedWriter
		//FileWriter
		/*
		 * try with resources
		 * parameterized try block used with classes that  implement the Autocloseable
		 * interface so that you do not need to finally block to close your resource
		 * after using it
		 */
		try (BufferedWriter bw = new BufferedWriter(
				new FileWriter("src/files/student.txt", true));){
			bw.write(student.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	List<Student> readStudents(){
		List<Student> s = new ArrayList<Student>();
		try(BufferedReader br = new BufferedReader(
				new FileReader("src/files/student.txt"))){
			String line = null;
			while((line=br.readLine()) != null) {
				String[] studentInfo = line.split(";");
				Student temp = new Student();
				temp.setName(studentInfo[0]);
				temp.setEmail(studentInfo[1]);
				temp.setGrade(Double.parseDouble(studentInfo[2]));
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}


}
