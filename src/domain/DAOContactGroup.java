package domain;

import java.util.ArrayList;

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
						
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contactGroup;
	}
}
