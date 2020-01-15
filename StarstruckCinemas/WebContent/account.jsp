<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>StarStruck Cinemas</title>
	<link href="css/default.css" type="text/css" rel="StyleSheet">
</head>
<body>
	<header>
	<div id="header"><span id="company-logo"><a href="index.jsp" rel="StarStruck Cinemas"><span class="small-text">StarStruck</span> Cinemas <span class="smaller-text"> ...back</span></a></span>
		<span id="members">
		<% if(session.getAttribute("email") != null) { %>
		<span><a href="account.jsp" rel="Go to Account">Account</a></span><span><a href="logout.jsp" rel="Logout">Logout</a></span>
		<% } else { %>
		<span><a href="signup.jsp" rel="link to Sign Up">Sign Up</a></span><span><a href="login.jsp" rel="Link to Login">Login</a></span>
		<% } %>
		</span>
	</div>
	<hr id="header-underline-blockout">
	<hr id="header-underline">
	</header>
	
	<br>
	<div id="discount"><em>Did you know?  Members receive a 20% discount from November, 17<sup>th</sup> to November 23<sup>rd</sup>!</em></div>
	<br>
	
	<div id="container">


	</div>

</body>
</html>