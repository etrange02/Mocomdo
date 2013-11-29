<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Contact</title>
<script type="text/javascript">
	function reset() {
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
	<h2>Créer un nouveau contact</h2>
	<br />
	<form action="CreateContactServlet" method="post">
	   <table>
           <tr>
               <td>Firstname</td><td><input type="text" name="firstname" id="firstname" /></td>
           </tr>
           <tr>
               <td>Lastname</td><td><input type="text" name="lastname" id="lastname" /></td>
           </tr>
           <tr>
               <td>Email</td><td><input type="text" name="email" id="email" /></td>
           </tr>
           <tr>
               <td>Street</td><td><input type="text" name="street" id="street" /></td>
           </tr>
           <tr>
               <td>City</td><td><input type="text" name="city" id="city" /></td>
           </tr>
           <tr>
               <td>Zip</td><td><input type="text" name="zip" id="zip" /></td>
           </tr>
           <tr>
               <td>Country</td><td><input type="text" name="country" id="country" /></td>
           </tr>
           <tr>
               <td>Home Phone Number</td><td><input type="text" name="homephone" id="homephone" /></td>
           </tr>
           <tr>
               <td>Office Phone Number</td><td><input type="text" name="officephone" id="officephone" /></td>
           </tr>
           <tr>
               <td>Cellphone Number</td><td><input type="text" name="cellphone" id="cellphone" /></td>
           </tr>
           <tr>
               <td><input type="submit" value="Valider" /></td><td><input type="button" value="Reset" onclick="reset();" /></td>
           </tr>
	   </table>
	</form>
</body>
</html>