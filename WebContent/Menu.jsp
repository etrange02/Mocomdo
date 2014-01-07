<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu</title>
</head>
<body>
<% if(request.getParameter("login") !=null){  %>
<h1> Hello Mr. <%=request.getParameter("login")%></h1><br />
<% } %>
<h2>Menu</h2><br />
<ul>
<li> <a href="CreateContact.jsp">Créer un nouveau contact</a></li>
<!-- <li> <a href="RemoveContact.jsp">Supprimer un contact</a></li> -->
<!-- <li> <a href="ModifyContact.jsp">Modifier un contact</a></li> -->
<li> <a href="SearchContact.jsp">Rechercher un contact</a></li>
</ul>
<form action="SearchContactServlet" method="post">
    <input type="submit" value="Peupler" />
</form>

</body>
</html>