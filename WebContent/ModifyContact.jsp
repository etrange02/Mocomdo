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
	    <input type="hidden" name="idContact" value="${ contact.getId() }" />
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
               <td><label for="idstreet">Street</label></td><td><input type="text" name="street" id="idstreet" value="${ contact.getAddress().getStreet() }" /></td>
           </tr>
           <tr>
               <td><label for="idcity">City</label></td><td><input type="text" name="city" id="idcity" value="${ contact.getAddress().getCity() }" /></td>
           </tr>
           <tr>
               <td><label for="idzip">Zip</label></td><td><input type="text" name="zip" id="idzip" value="${ contact.getAddress().getZip() }" /></td>
           </tr>
           <tr>
               <td><label for="idcountry">Country</label></td><td><input type="text" name="country" id="idcountry" value="${ contact.getAddress().getCountry() }" /></td>
           </tr>
           
           <!-- <%!
	           public static String getPhone(List<PhoneNumber> listePhones, String kind) {		    
			       if (listePhones != null) {
			           Iterator<PhoneNumber> iter = listePhones.iterator();
			           PhoneNumber pn = null;
		               while (iter.hasNext()) {
		                   pn = iter.next();
		                   if (pn.getPhoneKind().equals(kind))
		                	   return pn.getPhoneNumber();
		               }
			       }
			       return "";
	           }
		    %>
           <tr>
               <td><label for="idhomephone">Home Phone Number</label></td><td><input type="text" name="homephone" id="idhomephone" value="${ getPhone(contact.getPhones(), "homephone") }" /></td>
           </tr>
           <tr>
               <td><label for="idofficephone">Office Phone Number</label></td><td><input type="text" name="officephone" id="idofficephone" value="${ getPhone(contact.getPhones(), "officephone") }" /></td>
           </tr>
           <tr>
               <td><label for="idcellphone">Cellphone Number</label></td><td><input type="text" name="cellphone" id="idcellphone" value="${ getPhone(contact.getPhones(), "cellphone") }" /></td>
           </tr>
           
           <%!
               public static String getGroup(List<ContactGroup> listeGroups, String kind) {
                   //List<PhoneNumber> listePhones = ((Contact)request.getAttribute("contact")).getPhones();            
                   if (listeGroups != null) {
                       Iterator<ContactGroup> iter = listeGroups.iterator();
                       ContactGroup cg = null;
                       while (iter.hasNext()) {
                           cg = iter.next();
                           if (cg.getGroupName().equals(kind))
                               return "checked";
                       }
                   }
                   return "unchecked";
               }
            %>
           
           <tr>
               <td>Group</td><td><div><input type="checkbox" name="ami" id="idAmi" checked="${ getGroup(contact.getBooks(), "ami") }" /><label for="idAmi">Ami</label><br />
                                      <input type="checkbox" name="collegue" id="idCollegue" checked="${ getGroup(contact.getBooks(), "collegue") }" /><label for="idCollegue">Collègue</label><br />
                                      <input type="checkbox" name="famille" id="idFamille" checked="${ getGroup(contact.getBooks(), "famille") }" /><label for="idFamille">Famille</label><br />
                                </div></td>
           </tr>
            -->
            <tr>
                <td><input type="submit" value="Valider" /></td><td><input type="button" value="Reset" onclick="reset();" /></td>
            </tr>
		</table>
	</form>
</body>
</html>