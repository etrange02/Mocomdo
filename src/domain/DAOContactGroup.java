package domain;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;

public class DAOContactGroup {

	public ContactGroup searchContact(String criteria) {		
		Session session = null;
		ContactGroup contactGroup = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			
			ArrayList<ContactGroup> contactGroups =
					(ArrayList<ContactGroup>) session.createCriteria(ContactGroup.class).add(Restrictions.ilike("groupName", criteria)).list();
			
			contactGroup = (ContactGroup) (contactGroups.isEmpty() ? null : contactGroups.get(0));
			if (contactGroup != null) {
				Iterator<Contact> it = contactGroup.getContacts().iterator();
				while(it.hasNext())
					it.next();
			}
			
			session.flush();
						
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contactGroup;
	}
}
