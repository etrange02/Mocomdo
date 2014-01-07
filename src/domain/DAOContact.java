package domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;

import util.*;

public class DAOContact extends HibernateDaoSupport {
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(SessionFactory sessionFactory){
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	public void createContact(final Contact contact) {
		this.getHibernateTemplate().execute(new HibernateCallback<Contact>() {

			@Override
			public Contact doInHibernate(Session session) throws HibernateException, SQLException {
				session.save(contact);
				Iterator<ContactGroup> iter = contact.getBooks().iterator();
				while (iter.hasNext()) {
					session.saveOrUpdate(iter.next());
				}

				Iterator<PhoneNumber> iter2 = contact.getPhones().iterator();
				while (iter2.hasNext()) {
					session.saveOrUpdate(iter2.next());
				}
				return null;
			}
		});
		
		/*Session session = null;
		
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
		}*/
	}
	
	public void updateContact(final Contact contact) {
		this.getHibernateTemplate().update(contact);
		
		
		/*Session session = null;
		
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			session.update(contact);
			
			/ *Iterator<ContactGroup> iter = contact.getBooks().iterator();
			while (iter.hasNext()) {
				session.saveOrUpdate(iter.next());
			}

			Iterator<PhoneNumber> iter2 = contact.getPhones().iterator();
			while (iter2.hasNext()) {
				session.saveOrUpdate(iter2.next());
			}* /
			
			tx.commit();
			session.close();
			
			System.out.println("\nok\n");
			
		} catch(Exception e){
			System.out.println("ERREUR update");
			System.out.println(e.getMessage());
		}*/
	}

	public void removeContact(final int id) {
		
		this.getHibernateTemplate().execute(new HibernateCallback<Contact>() {

			@Override
			public Contact doInHibernate(Session session) throws HibernateException, SQLException {
				Contact c = (Contact) session.load(Contact.class, id);
				session.delete(c);
				return null;
			}
		});
		
		/*Session session = null;
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
		}*/
	}

	/// From type request
	/// Search with member name
	public ArrayList<Contact> searchContactByName(final String criteria) {
		return (ArrayList<Contact>) getHibernateTemplate().executeFind(new HibernateCallback<ArrayList<Contact>>() {
			@Override
			public ArrayList<Contact> doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery("from Contact as c where c.firstname = ? or c.lastname = ?");
				query.setString(0, criteria);
				query.setString(1, criteria);
				query.setFirstResult(0).setMaxResults(10);
				return (ArrayList<Contact>) query.list();
			}
		});
		
		/*Session session = null;
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
		return contacts;*/
	}
	
	/// Criteria type
	/// Simple type
	public ArrayList<Contact> searchContactByPhone(final String phone) {
		return (ArrayList<Contact>) this.getHibernateTemplate().executeFind(new HibernateCallback<ArrayList<Contact>>() {
			@Override
			public ArrayList<Contact> doInHibernate(Session session) throws HibernateException, SQLException {
				StringBuffer phoneRequest = new StringBuffer("%");
				phoneRequest.append(phone);
				phoneRequest.append("%");
				return (ArrayList<Contact>) session.createCriteria(Contact.class).createCriteria("phones")
					.add(Restrictions.ilike("phoneNumber", phoneRequest.toString()))
					.list();
			}
		});
		
		/*Session session = null;
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
		return contacts;*/
	}
	
	/// Example type request
	public ArrayList<ContactGroup> searchGroupByName(final String criteria) {
		return (ArrayList<ContactGroup>) this.getHibernateTemplate().executeFind(new HibernateCallback<ArrayList<ContactGroup>>() {
			@Override
			public ArrayList<ContactGroup> doInHibernate(Session session) throws HibernateException, SQLException {				
				ContactGroup contactGroup = new ContactGroup();
				ArrayList<ContactGroup> groups = null;
				groups = (ArrayList<ContactGroup>) session.createCriteria(ContactGroup.class)
						.add(Example.create(contactGroup).excludeProperty("groupId").excludeProperty("contacts").ignoreCase().enableLike())
						.list();
				if (groups != null) {
					Iterator<ContactGroup> iter = groups.iterator();
					while (iter.hasNext()) {
						Iterator<Contact> it = iter.next().getContacts().iterator();
						while (it.hasNext())
							it.next().getFirstname();
					}
				}
				return groups;
			}
		});
		
		/*Session session = null;
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
		return groups;*/
	}
	
	public Contact searchContact(final int id) {
		return (Contact) this.getHibernateTemplate().execute(new HibernateCallback<Contact>() {
			@Override
			public Contact doInHibernate(Session session) throws HibernateException, SQLException {
				ArrayList<Contact> contacts = (ArrayList<Contact>) session.createCriteria(Contact.class)
						.add(Restrictions.eq("id", id)).list();
				Contact contact = (Contact) (contacts.isEmpty() ? null : contacts.get(0));
				
				if (contact != null) {
					/*contact.getAddress();
					for (ContactGroup cg: contact.getBooks());
					for (PhoneNumber pn: contact.getPhones());*/
					return contact;
				}
				return null;
			}
		});
		
		/*Session session = null;
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
		return contact;*/
	}
}
