<%@ page import="domain.Contact" %>
<%@ page import="domain.Address" %>
<%@ page import="domain.ContactGroup" %>
<%@ page import="domain.PhoneNumber" %>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modify Contact</title>
<script type="text/javascript">
	function reset() {
		document.getElementById("idContact").setAttribute("value", "");
		document.getElementById("firstname").setAttribute("value", "");
		document.getElementById("lastname").setAttribute("value", "");
		document.getElementById("email").setAttribute("value", "");
	}
</script>
</head>
<body>
	<h2>Modifier un contact</h2>
	<br />
	<form action="ModifyContactServlet" method="post">
	    <input type="hidden" name="id" value="${ contact.getId() }" />
		<table>
            <tr>
                <td><label for="idFirstname">Firstname</label></td><td><input type="text" name="firstname" id="idFirstname" value="${ contact.getFirstname() }" /></td>
            </tr>
            <tr>
                <td><label for="idLastname">Lastname</label></td><td><input type="text" name="lastname" id="idLastname" value="${ contact.getLastname() }" /></td>
            </tr>
            <tr>
                <td><label for="idEmail">Email</label></td><td><input type="text" name="email" id="idEmail" value="${ contact.getEmail() }" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="Valider (non fonctionnel)" /></td><td><input type="button" value="Reset" onclick="reset();" /></td>
            </tr>
		</table>
	</form>
</body>
</html>