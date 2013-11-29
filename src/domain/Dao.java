package domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Dao {

	public void createContact(String firstname, String lastname, String email) {
		Session session = null;
		try{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
		} catch(Exception e){
			System.err.println("ERREUR DETECTE");
			System.out.println(e.getMessage());
		}
	}
	
	public void modifyContact(int id, String firstname, String lastname, String email) {

	}
	
	public void removeContact(int id) {

	}
	
	public void searchContact() {

	}

}
