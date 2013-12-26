<%@ page import="domain.ContactGroup"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="domain.Contact"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Contact</title>
</head>
<body>
	<h2>Rechercher un contact</h2>
	<br />
	<form action="SearchContactServlet" method="post">
		<input type="text" name="criteria" id="criteria" />
		<input type="submit" value="Rechercher" />
	</form>
	<%
	   List<Contact> listeContact = (List<Contact>) request.getAttribute("listeContact");
	
	   if (listeContact != null) {
		   Iterator<Contact> iter = listeContact.iterator();
		   Contact c = null;
		   if (iter.hasNext()) {
			   out.println("<table>");
			   while (iter.hasNext()) {
				   c = iter.next();
				   out.print("<tr><td>");
				   out.print(c.getFirstname());
				   out.print(" ");
				   out.print(c.getLastname());	   
                   out.print("</td><td>");
                   out.print("<form action=\"ModifyContactServlet\" method=\"get\"><input type=\"hidden\" value=\"");
                   out.print(c.getId());
                   out.print("\" name=\"id\" /><input type=\"submit\" value=\"Modifier\" /></form>");
                   out.print("</td><td>");
                   out.print("<form action=\"RemoveContactServlet\" method=\"get\"><input type=\"hidden\" value=\"");
                   out.print(c.getId());
                   out.print("\" name=\"id\" /><input type=\"submit\" value=\"Supprimer (pas fait pour le moment)\" /></form>");     
                   out.println("</td></tr>");
	               
	               /*out.print("<tr><td><a href=\"ModifyContactServlet?id=");
	               out.print(c.getId());
	               out.print("\">");
	               out.print(c.getFirstname());
	               out.print(" ");
	               out.print(c.getLastname());
	               out.println("</a></td></tr>");*/
			   }
	           out.println("</table>");
		   } else {
			   out.println("<p>Aucun contact ne correspond à cette recherche.</p>");
		   }
	   }
	%>
</body>
</html>