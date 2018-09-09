package com.revature.questiontwenty;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromFile {
	 public static void main(String[] args) throws IOException {
         BufferedReader reader = null;
         try{
             reader = new BufferedReader(new FileReader("src/Data.txt"));
             String line = reader.readLine();
             String[] splitLine = line.split(":");
             System.out.println("Name: " + splitLine[0] + " " + splitLine[1] +
            		 "\nAge: " + splitLine[2] +
            		 "\nState: " + splitLine[3]);
         }catch(IOException ex){
             ex.printStackTrace();
         }finally{
             if(reader != null){
                 reader.close();
             }
         }
     }
}
