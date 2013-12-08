package domain;

import java.util.ArrayList;

import org.hibernate.Criteria;
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
		Address a = new Address();
		a.setCity("i");
		a.setCountry("c");
		a.setStreet("s");
		a.setZip("z");
		c.setAddress(a);
		
		ContactGroup cg = new ContactGroup();
		cg.setGroupName("ami");
		
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			System.out.println(session.save(a));
			System.out.println(session.save(c));
			System.out.println(session.save(cg));
			tx.commit();
			session.close();
		} catch(Exception e){
			System.err.println("ERREUR DETECTE");
			System.out.println(e.getMessage());
		}
	}

	/*public void modifyContact(int id, String firstname, String lastname, String email) {
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
			
			if (contact != null)
				System.out.println(contact.getId());
			else
				System.out.println("Not Found");
			
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contact;
	}*/

}
