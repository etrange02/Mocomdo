<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modify Contact</title>
<script type="text/javascript">
function reset () {
	document.getElementById("idContact").setAttribute("value", "");
	document.getElementById("firstname").setAttribute("value", "");
	document.getElementById("lastname").setAttribute("value", "");
	document.getElementById("email").setAttribute("value", "");
	}
</script>
</head>
<body>
<h2>Modifier un contact</h2><br />
<form action="ModifyContactServlet" method="post">
	Id du Contact : <input type="text" name="idContact" id="idContact"/><br />
	Firstname: <input type="text" name="firstname" id="firstname"/><br />
	Lastname: <input type="text" name="fastname" id="lastname"/><br />
	Email: <input type="text" name="email" id="email"/><br />
		<input type="submit" value="Valider" /> <input type="button" value="Reset" onclick="reset();" />
</form>
</body>
</html>