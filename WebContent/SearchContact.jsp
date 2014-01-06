<%@ page import="domain.ContactGroup"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="domain.Contact"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>
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
	<%--<c:if test="${ listeContact != null }">
	   <c:choose>
	       <c:when test="${ listeContact.size() > 0 }">
	           <table>
	               <tr>
	                   <th>Prénom Nom</th>
	                   <th colspan="2">Action</th>
	               </tr>
		           <c:foreach var="contact" items="${listeContact}" >
			       <tr>
				       <td><c:out value="${ contact.getFirstname() }" />
				       <c:out value=" " />
				       <c:out value="${ contact.getLastname() }" />
				       </td>
				       <td>
				       <form action="ModifyContactServlet" method="get">
				        <input type="hidden" name="id" value="${ contact.getId() }" />
				        <input type="submit" value="Modifier" />
				       </form>
				       </td>
				       <td>
				       <form action="RemoveContactServlet" method="get">
				        <input type="hidden" name="id" value="${ contact.getId() }" />
				        <input type="submit" value="Supprimer" />
				       </form>
				       </td>
			       </tr>
			    </c:foreach>
		    </table>
	       </c:when>
	       <c:otherwise>
	           <p>Aucun contact ne correspond à cette recherche.</p>
	       </c:otherwise>
	   </c:choose>
	</c:if> --%>
	
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
                   out.print("</td>");   
                   out.print("<td>");
                   out.print("<form action=\"ModifyContactServlet\" method=\"get\"><input type=\"hidden\" value=\"");
                   out.print(c.getId());
                   out.print("\" name=\"id\" /><input type=\"submit\" value=\"Modifier\" /></form>");
                   out.print("</td>");
                   out.print("<td>");
                   out.print("<form action=\"RemoveContactServlet\" method=\"get\"><input type=\"hidden\" value=\"");
                   out.print(c.getId());
                   out.print("\" name=\"id\" /><input type=\"submit\" value=\"Supprimer\" /></form>");     
                   out.println("</td></tr>");
 			   }
 	           out.println("</table>");
 		   } else {
 			   out.println("<p>Aucun contact ne correspond à cette recherche.</p>");
 		   }
 	   }
 	%>
</body>
</html>