package domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Dao {

	public void createContact(int id, String firstname, String lastname, String email) {
//		System.out.println("Dans createContact -> id = "+id);
//		System.out.println("Dans createContact -> firstname = "+firstname);
//		System.out.println("Dans createContact -> lastname = "+lastname);
//		System.out.println("Dans createContact -> email = "+email);
		
		Session session = null;
		try{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
		} catch(Exception e){
			System.err.println("ERREUR DETECTE");
			System.out.println(e.getMessage());
		}
	}

}
