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
	function activeNumSiret() {
		document.getElementById("idNumSiret").disabled = !document.getElementById("idNumSiret").disabled;
	}
</script>
</head>
<body>
	<h2>Créer un nouveau contact</h2>
	<br />
	<form action="CreateContactServlet" method="post">
	   <table>
           <tr>
               <td><label for="idfirstname">Firstname</label></td><td><input type="text" name="firstname" id="idfirstname" /></td>
           </tr>
           <tr>
               <td><label for="idlastname">Lastname</label></td><td><input type="text" name="lastname" id="idlastname" /></td>
           </tr>
           <tr>
               <td><label for="idemail">Email</label></td><td><input type="text" name="email" id="idemail" /></td>
           </tr>
           <tr>
               <td><label for="idstreet">Street</label></td><td><input type="text" name="street" id="idstreet" /></td>
           </tr>
           <tr>
               <td><label for="idcity">City</label></td><td><input type="text" name="city" id="idcity" /></td>
           </tr>
           <tr>
               <td><label for="idzip">Zip</label></td><td><input type="text" name="zip" id="idzip" /></td>
           </tr>
           <tr>
               <td><label for="idcountry">Country</label></td><td><input type="text" name="country" id="idcountry" /></td>
           </tr>
           <tr>
               <td><label for="idhomephone">Home Phone Number</label></td><td><input type="text" name="homephone" id="idhomephone" /></td>
           </tr>
           <tr>
               <td><label for="idofficephone">Office Phone Number</label></td><td><input type="text" name="officephone" id="idofficephone" /></td>
           </tr>
           <tr>
               <td><label for="idcellphone">Cellphone Number</label></td><td><input type="text" name="cellphone" id="idcellphone" /></td>
           </tr>
           <tr>
               <td>Group</td><td><div><input type="checkbox" name="ami" id="idAmi" /><label for="idAmi">Ami</label><br />
                                      <input type="checkbox" name="collegue" id="idCollegue" /><label for="idCollegue">Collègue</label><br />
                                      <input type="checkbox" name="famille" id="idFamille" /><label for="idFamille">Famille</label><br />
                                </div></td>
           </tr>
           <tr>
               <td><input type="checkbox" name="entreprise" id="idEntreprise" onclick="activeNumSiret()" /><label for="idEntreprise">Entreprise</label></td><td><input type="text" name="numSiret" id="idNumSiret" disabled="disabled" title="Numéro de siret" /></td>
           </tr>
           <tr>
               <td><input type="submit" value="Valider" /></td><td><input type="button" value="Reset" onclick="reset();" /></td>
           </tr>
	   </table>
	</form>
</body>
</html>