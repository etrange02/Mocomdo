package domain;

import java.io.IOException;

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
		Contact c = daoContact.searchContact(request.getParameter("criteria"));
		
		if (c!=null) {
			RequestDispatcher jsp = request.getRequestDispatcher("/ModifyContact.jsp");
			request.setAttribute("contact", c);
			jsp.forward(request, response);
			//response.sendRedirect("ModifyContact.jsp");
		}
		else
			response.sendRedirect("SearchContact.jsp");
	}

}
