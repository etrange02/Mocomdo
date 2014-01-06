package domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

import util.*;

public class DAOContact {

	public void createContact(Contact contact) {
		Session session = null;
		
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			session.save(contact);
			
			Iterator<ContactGroup> iter = contact.getBooks().iterator();
			while (iter.hasNext()) {
				session.saveOrUpdate(iter.next());
			}

			Iterator<PhoneNumber> iter2 = contact.getPhones().iterator();
			while (iter2.hasNext()) {
				session.saveOrUpdate(iter2.next());
			}
			
			tx.commit();
			session.close();
			
			System.out.println("\nok\n");
			
		} catch(Exception e){
			System.err.println("ERREUR DETECTE");
			System.out.println(e.getMessage());
		}
	}
	
	public void updateContact(Contact contact) {
		Session session = null;
		
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			session.update(contact);
			
			/*Iterator<ContactGroup> iter = contact.getBooks().iterator();
			while (iter.hasNext()) {
				session.saveOrUpdate(iter.next());
			}

			Iterator<PhoneNumber> iter2 = contact.getPhones().iterator();
			while (iter2.hasNext()) {
				session.saveOrUpdate(iter2.next());
			}*/
			
			tx.commit();
			session.close();
			
			System.out.println("\nok\n");
			
		} catch(Exception e){
			System.out.println("ERREUR update");
			System.out.println(e.getMessage());
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
			
			if (groups != null) {
				Iterator<ContactGroup> iter = groups.iterator();
				while (iter.hasNext()) {
					Iterator<Contact> it = iter.next().getContacts().iterator();
					while (it.hasNext())
						it.next().getFirstname();
				}
			}
			
			session.flush();
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
					.add(Restrictions.eq("id", id)).list();
			
			contact = (Contact) (contacts.isEmpty() ? null : contacts.get(0));
			
			if (contact != null) {
				System.out.println(contact.getId());
				contact.getAddress();
				for (ContactGroup cg: contact.getBooks());
				for (PhoneNumber pn: contact.getPhones());
			} else
				System.out.println("Not Found");
			session.flush();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contact;
	}
}
