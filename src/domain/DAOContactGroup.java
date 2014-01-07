package domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import util.HibernateUtil;

public class DAOContactGroup extends HibernateDaoSupport {
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(SessionFactory sessionFactory){
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	
	public ContactGroup searchContactGroup(final String criteria) {
		return (ContactGroup) this.getHibernateTemplate().execute(new HibernateCallback<ContactGroup>() {
			@Override
			public ContactGroup doInHibernate(Session session) throws HibernateException, SQLException {
				ArrayList<ContactGroup> contactGroups =
						(ArrayList<ContactGroup>) session.createCriteria(ContactGroup.class)
						.add(Restrictions.ilike("groupName", criteria)).list();
					
				ContactGroup contactGroup = (contactGroups.isEmpty() ? null : contactGroups.get(0));
				if (contactGroup != null) {
					Iterator<Contact> it = contactGroup.getContacts().iterator();
					while(it.hasNext()) {
						Iterator<ContactGroup> iter = it.next().getBooks().iterator();
						while (iter.hasNext())
							iter.next().getGroupId();
					}
				}
				return contactGroup;
			}
		});
		
		
		/*Session session = null;
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
			/ *session.clear();* /
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contactGroup;*/
	}
}
