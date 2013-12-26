package domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchContactServlet
 */
public class SearchContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchContactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOContact daoContact = new DAOContact();
		List<Contact> lc1 = daoContact.searchContactByName(request.getParameter("criteria"));		
		List<Contact> lc2 = daoContact.searchContactByPhone(request.getParameter("criteria"));
		List<ContactGroup> lg = daoContact.searchGroupByName(request.getParameter("criteria"));
		
		List<Contact> lc = new ArrayList<Contact>();
		if (lc1 != null)
			lc.addAll(lc1);
		if (lc2 != null)
			lc.addAll(lc2);
		if (lg != null) {
			Iterator<ContactGroup> iter = lg.iterator();
			while (iter.hasNext())
				lc.addAll(iter.next().getContacts());
		}
		
		RequestDispatcher jsp = request.getRequestDispatcher("/SearchContact.jsp");
		request.setAttribute("listeContact", lc);
		jsp.forward(request, response);
	}

}
