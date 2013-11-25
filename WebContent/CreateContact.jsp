<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Contact</title>
<script type="text/javascript">
function reset () {
	document.getElementById("login").setAttribute("value", "");
	document.getElementById("password").setAttribute("value", "");
	}
</script>
</head>
<body>
<h2>Créer un nouveau contact</h2><br />
<form action="CreateContactServlet" method="post">
	Firstname: <input type="text" name="firstname" /><br />
	Lastname:  <input type="text" name="lastname" /><br />
	Email:     <input type="text" name="email" /><br />
		<input type="submit" value="Valider" /> <input type="button" value="Reset" onclick="reset();" />
</form>
</body>
</html>