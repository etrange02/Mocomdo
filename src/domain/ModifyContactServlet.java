package domain;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			/*Iterator<PhoneNumber> iter = contact.getPhones().iterator();
			PhoneNumber pn = null;
			while (iter.hasNext()) {
				pn = iter.next();
				request.setAttribute(pn.getPhoneKind(), pn.getPhoneNumber());
			}
			Iterator<ContactGroup> it = contact.getBooks().iterator();
			ContactGroup cg = null;
			while (it.hasNext()) {
				cg = it.next();
				request.setAttribute(cg.getGroupName(), "on");
			}*/
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
		
		//Iterator<PhoneNumber> it = contact.getPhones().iterator();
		
		dao.updateContact(contact);
		
		response.sendRedirect("ModifyContact.jsp");
	}

}
