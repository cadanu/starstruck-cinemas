<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>StarStruck Cinemas: Sign Up</title>
	<link href="css/default.css" type="text/css" rel="StyleSheet">
</head>
<body>
	<header>
	<div id="header"><span id="company-logo"><a href="index.jsp" rel="to home"><span class="small-text">StarStruck</span> Cinemas <span class="smaller-text"> ...back</span></a></span>
		<span id="members">
		<span><a href="login.jsp" rel="link to Sign Up">Login</a></span>
		</span>
	</div>
	<hr id="header-underline-blockout">
	<hr id="header-underline">
	</header>
	
	<br>
	<div id="discount"><em>Did you know?  Members receive a 20% discount from November, 17<sup>th</sup> to November 23<sup>rd</sup>!</em></div>
	<br>
	<h1>Sign Up for an Account</h1>
	<div id="container">

		<form id="login-signup" name="signup" action="signup" method="post">
			<label for="first-name" class="left-side">First Name: </label>
			<input type="text" id="first-name" name="first-name" class="right-side" required>
			<br>
			<label for="last-name" class="left-side">Last Name: </label>
			<input type="text" id="last-name" name="last-name" class="right-side" required>
			<br>
			<label for="email" class="left-side">Email: </label>
			<input type="email" id="email" name="email" class="right-side" required>
			<br>
			<label for="password" class="left-side">Password: </label>
			<input type="password" name="pss" class="right-side" required>
			<br>
			<input type="submit" value="Sign Up">			
		</form>
	</div>

</body>
</html>