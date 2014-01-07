<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<link rel="stylesheet" href="css/normalize.css">
<link rel="stylesheet" href="css/foundation.css">
<link rel="stylesheet" href="css/design.css">
<script src="js/modernizr.js"></script>

</head>
<body>
<<<<<<< HEAD
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
=======
	<%
		Cookie cookie = null;
		if (request.getParameter("login") != null) {
		cookie = new Cookie("mocomdo_username",request.getParameter("login"));
		response.addCookie(cookie);
			}else{
		   Cookie[] cookies = null;
		   cookies = request.getCookies();
		   if( cookies != null ){
		      for (int i = 0; i < cookies.length; i++){
		         if(cookies[i].getName().equals("mocomdo_username")){
		        	 cookie=cookies[i];
		        	 break;
		         }
		      }
		    }
		}  
		if(cookie == null){
			
	%>
	<jsp:forward page="index.jsp"/>
	<% } %>
	<div class="truc small-10 columns small-centered">
		<nav class="top-bar contain-to-grid fixed" data-topbar>
			<ul class="title-area">
				<li class="name"><h1>
						<a href="index.jsp">Mocomdo</a>
					</h1></li>
			</ul>
			<section class="top-bar-section">
				<!-- Right Nav Section -->
				<ul class="right">
					<li class="has-dropdown"><a href="#">Account</a>
						<ul class="dropdown">
							<li><a href="deconnection.jsp" >Deconnexion</a></li>
						</ul></li>
				</ul>
			</section>
		</nav>
		<div class="myBody small-12 columns"></div>
		<div class="small-12 columns">
			<div class="small-12 small-centered columns">
				<ul class="button-group round even-6">
					<li><a href="#" class="button small" disabled>-</a></li>
					<li><a href="#" class="button small" disabled>-</a></li>
					<li><a href="CreateContact.jsp" class="button small">Create
							Contact</a></li>
					<li><a href="SearchContact.jsp" class="button small">Search
							Contact</a></li>
					<li><a href="#" class="button small" disabled>-</a></li>
					<li><a href="#" class="button small" disabled>-</a></li>
				</ul>
			</div>
			<div class="panel callout radius">
				<%
					if (cookie != null) {
				%>
				<h1>
					Hello Mr.
					<%=cookie.getValue()%></h1>
				<br />
				<%
					}
				%>

			</div>
		</div>
	</div>

	<div id="ConnectionModal" class="reveal-modal small" data-reveal tiny></div>

	<script src="js/vendor/jquery.js"></script>
	<script src="js/foundation/foundation.js"></script>
	<script src="js/foundation/foundation.topbar.js"></script>
	<script src="js/foundation/foundation.reveal.js"></script>
>>>>>>> 279ae5b1c9082158ed1a2f791e4f74b7f5bfc44e

	<script> $(document).foundation(); </script>
</body>
</html>