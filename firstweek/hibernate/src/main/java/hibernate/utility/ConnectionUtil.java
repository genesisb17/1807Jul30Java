package hibernate.utility;




import org.hibernate.Session;

public class ConnectionUtil {
	
	private static SessionFactory sf = new Configuration().configure().buildSessionFactory();
	
	public static Session getSession() {
		
	}
}
