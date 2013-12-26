<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Remove Contact</title>
<script type="text/javascript">
	function reset() {
		document.getElementById("idContact").setAttribute("value", "");
	}
</script>
</head>
<body>
	<h2>Supprimer un contact</h2>
	<br />
	<form action="RemoveContactServlet" method="post">
	   <input type="hidden" name="id" value="${ contact.getId() }" />
        <table>
            <tr>
                <td>${ contact.getFirstname() }</td>
                <td><a href="mailto:${ contact.getEmail() }">${ contact.getEmail() }</a></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Valider la suppression" /></td>
            </tr>
        </table>
	</form>
</body>
</html>