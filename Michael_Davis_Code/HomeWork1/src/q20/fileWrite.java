package q20;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.awt.*;

public class fileWrite {
	
String fname;
String lname;
int age;
String from;
	void addEntries() {

		try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/q20/files/Data.txt",true));){
			bw.write("Mickey:Mouse:35:Arizona"+"\n");
			bw.write("Hulk:Hogan:50:Virginia"+"\n");
			bw.write("Roger:Rabbit:22:California"+"\n");
			bw.write("Wonder:Woman:18:Montana"+"\n");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public ArrayList<fileWrite> readEntries() {
	ArrayList<fileWrite> list=new ArrayList<>();
	
		try(BufferedReader vt = new BufferedReader(
				new FileReader("src/q20/files/Data.txt"))){
			String line = null;
			while((line=vt.readLine()) != null) {
				String[] personInfo = line.split(":");
				fileWrite g=new fileWrite();
				g.fname=personInfo[0];
				g.lname=personInfo[1];
				g.age=Integer.parseInt(personInfo[2]);
				g.from=personInfo[3];
				list.add(g);
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fileWrite p=new fileWrite();
		//p.addEntries();
		ArrayList<fileWrite> b=p.readEntries();
		
		for(fileWrite x:b) {
			System.out.println("Name: "+x.fname+" "+x.lname);
			System.out.println("Age: "+x.age+" years");
			System.out.println("State: "+x.from);
			System.out.println("--------------");
			
		}
		

	}

}