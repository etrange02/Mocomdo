package domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DAOContact {

	public void createContact(String firstname, String lastname, String email) {
		Session session = null;
		Contact c = new Contact();
		c.setFirstName(firstname);
		c.setLastName(lastname);
		c.setEmail(email);
		try{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.persist(c);
			tx.commit();
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
