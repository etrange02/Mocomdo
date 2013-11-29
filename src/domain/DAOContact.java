package domain;

import org.hibernate.Session;
import org.hibernate.Transaction;
import util.*;

public class DAOContact {

	public void createContact(String firstname, String lastname, String email) {
		Session session = null;
		Contact c = new Contact();
		c.setFirstname(firstname);
		c.setLastname(lastname);
		c.setEmail(email);
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			System.out.println(session.save(c));
			tx.commit();
			session.close();
		} catch(Exception e){
			System.err.println("ERREUR DETECTE");
			System.out.println(e.getMessage());
		}
	}

	public void modifyContact(int id, String firstname, String lastname, String email) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			Contact c = (Contact) session.load(Contact.class, id);
			System.out.println(c.getId());
			c.setFirstname(firstname);
			c.setLastname(lastname);
			c.setEmail(email);
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeContact(int id) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			Contact c = (Contact) session.load(Contact.class, id);
			System.out.println(c.getId());
			session.delete(c);
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Contact searchContact(String criteria) {
		Session session = null;
		Contact contact = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			contact = (Contact) session.load(Contact.class, criteria);
			System.out.println(contact.getId());
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contact;
	}

}
