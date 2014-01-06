package domain;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;

public class DAOContactGroup {

	public ContactGroup searchContactGroup(String criteria) {		
		Session session = null;
		ContactGroup contactGroup = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			
			ArrayList<ContactGroup> contactGroups =
				(ArrayList<ContactGroup>) session.createCriteria(ContactGroup.class)
				.add(Restrictions.ilike("groupName", criteria)).list();
			
			contactGroup = (contactGroups.isEmpty() ? null : contactGroups.get(0));
			if (contactGroup != null) {
				Iterator<Contact> it = contactGroup.getContacts().iterator();
				while(it.hasNext()) {
					Iterator<ContactGroup> iter = it.next().getBooks().iterator();
					while (iter.hasNext())
						iter.next().getGroupId();
				}
			}
			
			session.flush();
			/*session.clear();*/
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contactGroup;
	}
}
