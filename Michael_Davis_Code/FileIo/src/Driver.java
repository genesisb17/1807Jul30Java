
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s = new Student("another", "gab12@duke.edu", 99.99);
		System.out.println(s);
		
		TextDao dao = new TextDao();
		dao.addStudent(s);
	}

}
