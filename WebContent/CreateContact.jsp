<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Contact</title>
<script type="text/javascript">
function reset () {
	document.getElementById("firstname").setAttribute("value", "");
	document.getElementById("lastname").setAttribute("value", "");
	document.getElementById("email").setAttribute("value", "");
	document.getElementById("street").setAttribute("value", "");
	document.getElementById("city").setAttribute("value", "");
	document.getElementById("zip").setAttribute("value", "");
	document.getElementById("country").setAttribute("value", "");
	document.getElementById("homephone").setAttribute("value", "");
	document.getElementById("officephone").setAttribute("value", "");
	document.getElementById("cellphone").setAttribute("value", "");
	}
</script>
</head>
<body>
<h2>Créer un nouveau contact</h2><br />
<form action="CreateContactServlet" method="post">
	Firstname: <input type="text" name="firstname" id="firstname"/><br />
	Lastname:  <input type="text" name="lastname" id="lastname"/><br />
	Email:     <input type="text" name="email" id="email"/><br />
	Street:	   <input type="text" name="street" id="street"/><br />
	City:	   <input type="text" name="city" id="city"/><br />
	Zip:	   <input type="text" name="zip" id="zip"/><br />
	Country:	   <input type="text" name="country" id="country"/><br /><br />
	
	Home Phone Number:	   <input type="text" name="homephone" id="homephone"/><br />
	Office Phone Number:	   <input type="text" name="officephone" id="officephone"/><br />
	Cellphone Number:	   <input type="text" name="cellphone" id="cellphone"/><br />
	
	
	
		<br /><input type="submit" value="Valider" /> <input type="button" value="Reset" onclick="reset();" />
</form>
</body>
</html>