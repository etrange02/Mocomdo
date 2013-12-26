package domain;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		DAOContact dao = new DAOContact();
		
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
			jsp.forward(request, response);
		} else {
			response.sendRedirect("ModifyContact.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOContact dao = new DAOContact();
		//dao.modifyContact(Integer.parseInt(request.getParameter("idContact")),request.getParameter("firstname"), request.getParameter("lastname"), request.getParameter("email"));
		response.sendRedirect("ModifyContact.jsp");
	}

}
