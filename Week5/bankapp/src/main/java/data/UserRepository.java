package data;

import java.util.List;

import org.hibernate.Session;

import models.User;
import util.ConnectionUtil;

public class UserRepository {
	public User findById(int id) {
		Session session = ConnectionUtil.getSession();
		User u = session.get(User.class, id);
		session.close();
		return u;
	}
	
	public List<User> findAll(){
//		List<User> = null;
		
		return null;
	}
	
	public User save(User u) {
		Session session = ConnectionUtil.getSession();
		session.save(u);
		session.close();
//		tx.commit;
		return u;
	}
	
	public User update(User u) {
		Session session = ConnectionUtil.getSession();
		session.update(u);
		return u;
	}
	
	public User findByUsername(String name) {
		return null;
	}
}
