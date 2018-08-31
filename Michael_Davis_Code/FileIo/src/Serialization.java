import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialization {
	
	public static void main(String[] args) {
		//Student s=new Student("Genesis","email.x",99.37);
		//SerializeObject(s);
		
	    
	    System.out.println(deserializeObject());
		
	}
	
	
	static void SerializeObject(Object o) {
		
		try (ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("src/files/serial.txt"))){
		oos.writeObject(o);
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

static Object deserializeObject() {
		Object obj=null;
		try (ObjectInputStream ois=new ObjectInputStream(new FileInputStream("src/files/serial.txt"))){
	obj=ois.readObject();
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
}
