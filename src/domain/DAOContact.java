package domain;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

import util.*;

public class DAOContact {

	public void createContact(String firstname, String lastname, String email) {
		Session session = null;
		Contact c = new Contact();
		c.setFirstname(firstname);
		c.setLastname(lastname);
		c.setEmail(email);
		c.setPhones(new ArrayList<PhoneNumber>());
		Address a = new Address();
		a.setCity("i");
		a.setCountry("c");
		a.setStreet("s");
		a.setZip("z");
		c.setAddress(a);
		
		ContactGroup cg = new ContactGroup();
		cg.setGroupName("ami");
		
		List<Contact> cs = new ArrayList<>();
		cs.add(c);
		cg.setContacts(cs);
		List<ContactGroup> book = new ArrayList<>();
		book.add(cg);
		c.setBooks(book);
		
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			System.out.println(session.save(a));
			System.out.println(session.save(cg));
			System.out.println(session.save(c));
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
	}*/

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

	/// From type request
	/// Search with member name
	public ArrayList<Contact> searchContactByName(String criteria) {
		Session session = null;
		ArrayList<Contact> contacts = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			
			StringBuffer sb = new StringBuffer();
			sb.append("from Contact as c where c.firstname = ? or c.lastname = ?");
			
			contacts = (ArrayList<Contact>) session.createQuery(sb.toString()).setString(0, criteria).setString(1, criteria).list();
			contacts.isEmpty();
			//List<Contact> liste = session.createQuery(sb.toString()).setInteger(0, Integer.parseInt(criteria)).list();
			
			/*contact = (Contact) (liste.isEmpty() ? null : liste.get(0));
			
			if (contact != null)
				System.out.println(contact.getId());
			else
				System.out.println("Not Found");*/
			
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contacts;
	}
	
	/// Criteria type
	/// Simple type
	public ArrayList<Contact> searchContactByPhone(String phone) {
		Session session = null;
		ArrayList<Contact> contacts = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			
			StringBuffer phoneRequest = new StringBuffer("%");
			phoneRequest.append(phone);
			phoneRequest.append("%");
			
			contacts = (ArrayList<Contact>) session.createCriteria(Contact.class)
						.createCriteria("phones")
							.add(Restrictions.ilike("phoneNumber", phoneRequest.toString()))
						.list();
			
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contacts;
	}
	
	/// Example type request
	public ArrayList<ContactGroup> searchGroupByName(String criteria) {
		Session session = null;
		ArrayList<ContactGroup> groups = null;
		try {
			ContactGroup group = new ContactGroup();
			group.setGroupName(criteria);
			session = HibernateUtil.getSessionFactory().openSession();
			
			groups = (ArrayList<ContactGroup>) session.createCriteria(ContactGroup.class)
						.add(Example.create(group).excludeProperty("groupId").excludeProperty("contacts").ignoreCase().enableLike())
						.list();			
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return groups;
	}
	
	public Contact searchContact(int id) {		
		Session session = null;
		Contact contact = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			
			ArrayList<Contact> contacts =
					(ArrayList<Contact>) session.createCriteria(Contact.class)
					.add(Restrictions.eq("id", id))
					.list();
			
			contact = (Contact) (contacts.isEmpty() ? null : contacts.get(0));
			
			if (contact != null)
				System.out.println(contact.getId());
			else
				System.out.println("Not Found");
			
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contact;
	}
}
