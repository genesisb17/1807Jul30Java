import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//ctrl space to see methods for object
public class IODAO 
{
	//class used to read from and write to text file
	
	void addStudent(Student student)
	{
		//name;email;grade
		
		//Bufferwriter
		//Filerwriter
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/files/students.txt"));)
		{
			bw.write(student.toString());
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}		
	}
	
	List<Student> readStudents()
	{
		List<Student> student = new ArrayList<Student>();
		try(BufferedReader br = new BufferedReader(new FileReader("src/files/students.txt")))
		{
			
			String line = null;
			while((line=br.readLine()) != null)
			{
				String[] studentInfo = line.split(";");
				Student temp = new Student();
				temp.setName(studentInfo[0]);
				temp.setEmail(studentInfo[1]);
				temp.setGrade(Double.parseDouble(studentInfo[2]));
				student.add(temp);
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
