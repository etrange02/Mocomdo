package domain;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.classic.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Servlet implementation class ModifyContactServlet
 */
public class ModifyContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyContactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		DAOContact dao = (DAOContact) context.getBean("beanDAOContact");
		
		int id = -1;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			id = -1;
		}
		
		Contact contact = dao.searchContact(id);
		
		if (contact != null) {
			RequestDispatcher jsp = request.getRequestDispatcher("ModifyContact.jsp");
			request.setAttribute("contact", contact);
			request.setAttribute("address", contact.getAddress());
			
			Iterator<ContactGroup> it = contact.getBooks().iterator();
			while (it.hasNext())
			{
				ContactGroup cg = it.next();
				request.setAttribute(cg.getGroupName(), cg.getGroupName());
				System.out.println(cg.getGroupName());
			}
			
			Iterator<PhoneNumber> iter = contact.getPhones().iterator();
			while (iter.hasNext())
			{
				PhoneNumber pn = iter.next();
				request.setAttribute(pn.getPhoneKind(), pn.getPhoneNumber());
				System.out.println(pn.getPhoneKind() + ":" +  pn.getPhoneNumber());
			}

			jsp.forward(request, response);
		} else {
			response.sendRedirect("ModifyContact.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		DAOContact dao = (DAOContact) context.getBean("beanDAOContact");
		
		int id = -1;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			id = -1;
		}
		Contact contact = dao.searchContact(id);
			
		contact.setFirstname(request.getParameter("firstname"));
		contact.setLastname(request.getParameter("lastname"));
		contact.setEmail(request.getParameter("email"));
		
		contact.getAddress().setCity(request.getParameter("city"));
		contact.getAddress().setCountry(request.getParameter("country"));
		contact.getAddress().setStreet(request.getParameter("street"));
		contact.getAddress().setZip(request.getParameter("zip"));

		if (request.getParameter("ami") != null)	
			checkContactGroup(context, contact, "ami");
		else
			uncheckContactGroup(context, contact, "ami");
		if (request.getParameter("collegue") != null)
			checkContactGroup(context, contact, "collegue");
		else
			uncheckContactGroup(context, contact, "collegue");
		if (request.getParameter("famille") != null)	
			checkContactGroup(context, contact, "famille");
		else
			uncheckContactGroup(context, contact, "famille");
		
		dao.updateContact(contact);
		
		//response.sendRedirect("ModifyContact.jsp?id=" + request.getParameter("id"));
		doGet(request, response);
	}
	
	private void checkContactGroup(ApplicationContext context, Contact contact, String name) {
		if (containsGroup(contact.getBooks(), name))
			return;
		DAOContactGroup daoGroup = (DAOContactGroup) context.getBean("beanDAOContactGroup");
		ContactGroup cg = daoGroup.searchContactGroup(name);
		if (cg == null) {
			System.out.println("CG NULL !");
			cg = (ContactGroup) context.getBean("beanContactGroup");
			cg.setGroupName(name);
			daoGroup.createContactGroup(cg);
		}
		cg.getContacts().add(contact);
		contact.getBooks().add(cg);
		daoGroup.updateContactGroup(cg);
	}
	
	private void uncheckContactGroup(ApplicationContext context, Contact contact, String name) {
		Iterator<ContactGroup> it = contact.getBooks().iterator();
		while (it.hasNext()) {
			ContactGroup cg = it.next();
			if (cg.getGroupName().equals(name)) {
				contact.getBooks().remove(cg);
				cg.getContacts().remove(contact);
				return;
			}
		}
	}
	
	private boolean containsGroup(List<ContactGroup> list, String name) {
		Iterator<ContactGroup> it = list.iterator();
		while (it.hasNext()) {
			ContactGroup cg = it.next();
			if (cg.getGroupName().equals(name))
				return true;
		}
		return false;
	}

}
