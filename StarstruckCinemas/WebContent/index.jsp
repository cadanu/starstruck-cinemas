<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>StarStruck Cinemas</title>
	<link href="css/default.css" type="text/css" rel="StyleSheet">
</head>
<body>
	<header>
	<div id="header"><span id="company-logo"><a href="index.jsp" rel="StarStruck Cinemas"><span class="small-text">StarStruck</span> Cinemas</a></span>
		<span id="members">
		
		<span><a href="account.jsp" rel="Go to Account">Account</a></span><span><a href="logout.jsp" rel="Logout">Logout</a></span>
		>
		<span><a href="signup.jsp" rel="link to Sign Up">Sign Up</a></span><span><a href="login.jsp" rel="Link to Login">Login</a></span>
	
		</span>
	</div>
	<hr id="header-underline-blockout">
	<hr id="header-underline">
	</header>
	
	<br>
	<div id="discount"><em>Did you know?  Members receive a 20% discount from November, 17<sup>th</sup> to November 23<sup>rd</sup>!</em></div>
	<br>
	
	<div id="container">

		<form id="movie-select" action="control" method="post">
		
		<%! int seatsAvailable(String movieName) {
				com.prog32578.Ticket tic = new com.prog32578.Ticket();
				int seats = 0;
				if(String.valueOf(com.prog32578.CRUD.getSeatsSold(movieName)) != null) {
					seats = com.prog32578.CRUD.getSeatsSold(movieName);
				}
				seats = Integer.parseInt(tic.getCapacity()) - seats;
				return seats;
			}
		%>
		
			<div class="display-box">
			<table><tr><td>
				<img src="media/LethalWeapon.jpg" alt="'Lethal Weapon' movie poster"/>
			</td>
			<td>
			<span class="display-box-text">
				<span><strong>Lethal Weapon: </strong>Action/Comedy</span>
				<input type="checkbox" name="movie1" value="Lethal Weapon">
				<br>
				<label for="movie-date">Date: </label>
				<input type="date" id="date" name="date" min="2019-11-22" max="2020-01-01">
				<br>
				<label for="movie-time">Movie Times: </label>
				<select id="movie-time" name="movie-time">
					<option value="12:10">12:10 pm</option>
					<option value="4:40">4:40 pm</option>
					<option value="7:30">7:30 pm</option>
					<option value="10:10">10:10 pm</option>
				</select>
				<br>				
				<label for="ticket-type">Ticket Type: </label>
				<select id="ticket-type" name="ticket-type">
					<option value="general">General Admission - $15.00</option>
					<option value="age-specific">Senior/Child - $5.00</option>
					<option value="special">Tuesday Special - $5.00</option>
				</select>
				<br>				
				<label for="how-many">Number of Tickets: </label>
				<input type="number" name="amount" size="2" min="1" max="<%= seatsAvailable("Lethal Weapon") %>"/><br>
				<span>There are <%= seatsAvailable("Lethal Weapon") %> seats left.</span>
			</span>
			</td></tr></table>
			</div>
			
			<hr>
			
			<div class="display-box">
			<table><tr><td>
				<img src="media/TheGrinch.jpg" alt="'The Grinch' movie poster"/>
			</td>
			<td>
			<span class="display-box-text">
				<span><strong>The Grinch who Stole Christmas: </strong>Comedy</span>
				<input type="checkbox" name="movie2" value="The Grinch Who Stole Christmas"><br>
				<br>
				<label for="movie-date">Date: </label>
				<input type="date" id="date" name="date" min="2019-11-22" max="2020-01-01">
				<br>
				<label for="movie-time">Movie Times: </label>
				<select id="movie-time" name="movie-time">
					<option value="12:10">12:10 pm</option>
					<option value="4:40">4:40 pm</option>
					<option value="7:30">7:30 pm</option>
					<option value="10:10">10:10 pm</option>
				</select>
				<br>				
				<label for="ticket-type">Ticket Type: </label>
				<select id="ticket-type" name="ticket-type">
					<option value="general">General Admission - $15.00</option>
					<option value="age-specific">Senior/Child - $5.00</option>
					<option value="special">Tuesday Special - $5.00</option>
				</select>
				<br>				
				<label for="how-many">Number of Tickets: </label>
				<input type="number" name="amount" size="2" min="1" max="<%= seatsAvailable("The Grinch Who Stole Christmas") %>"/><br>
				<span>There are <%= seatsAvailable("The Grinch Who Stole Christmas") %> seats left.</span>
			</span>
			</td></tr></table>
			</div>
			
			<hr>
			
			<div class="display-box">
			<table><tr><td>
				<img src="media/Titanic.jfif" alt="'Titanic' movie poster"/>
			</td>
			<td>
			<span class="display-box-text">
				<span><strong>Titanic: </strong>Drama</span>
				<input type="checkbox" name="movie3" value="Titanic"><br>
				<br>
				<label for="movie-date">Date: </label>
				<input type="date" id="date" name="date" min="2019-11-22" max="2020-01-01">
				<br>
				<label for="movie-time">Movie Times: </label>
				<select id="movie-time" name="movie-time">
					<option value="12:10">12:10 pm</option>
					<option value="4:40">4:40 pm</option>
					<option value="7:30">7:30 pm</option>
					<option value="10:10">10:10 pm</option>
				</select>
				<br>				
				<label for="ticket-type">Ticket Type: </label>
				<select id="ticket-type" name="ticket-type">
					<option value="general">General Admission - $15.00</option>
					<option value="age-specific">Senior/Child - $5.00</option>
					<option value="special">Tuesday Special - $5.00</option>
				</select>
				<br>				
				<label for="how-many">Number of Tickets: </label>
				<input type="number" name="amount" size="2" min="1" max="<%= seatsAvailable("Titanic") %>"/><br>
				<span>There are <%= seatsAvailable("Titanic") %> seats left.</span>
			</span>
			</td></tr></table>
			</div>
			
			<hr>
			
			<div class="display-box">
			<table><tr><td>
				<img src="media/TheMatrix.jfif" alt="'The Matrix' movie poster"/>
			</td>
			<td>
			<span class="display-box-text">
				<span><strong>The Matrix: </strong>Action/Sci-fi</span>
				<input type="checkbox" name="movie4" value="The Matrix"><br>
				<br>
				<label for="movie-date">Date: </label>
				<input type="date" id="date" name="date" min="2019-11-22" max="2020-01-01">
				<br>
				<label for="movie-time">Movie Times: </label>
				<select id="movie-time" name="movie-time">
					<option value="12:10">12:10 pm</option>
					<option value="4:40">4:40 pm</option>
					<option value="7:30">7:30 pm</option>
					<option value="10:10">10:10 pm</option>
				</select>
				<br>				
				<label for="ticket-type">Ticket Type: </label>
				<select id="ticket-type" name="ticket-type">
					<option value="general">General Admission - $15.00</option>
					<option value="age-specific">Senior/Child - $5.00</option>
					<option value="special">Tuesday Special - $5.00</option>
				</select>
				<br>				
				<label for="how-many">Number of Tickets: </label>
				<input type="number" name="amount" size="2" min="1" max="<%= seatsAvailable("The Matrix") %>"/><br>
				<span>There are <%= seatsAvailable("The Matrix") %> seats left.</span>
			</span>
			</td></tr></table>
			</div>
			
			<hr>
			
			<div class="display-box">
			<table><tr><td>
				<img src="media/ForrestGump.png" alt="'Forrest Gump' movie poster"/>
			</td>
			<td>
			<span class="display-box-text">
				<span><strong>Forrest Gump: </strong>Drama/Comedy</span>
				<input type="checkbox" name="Forrest Gump"><br>
				<br>
				<label for="movie-date">Date: </label>
				<input type="date" id="date" name="date" min="2019-11-22" max="2020-01-01">
				<br>
				<label for="movie-time">Movie Times: </label>
				<select id="movie-time" name="movie-time">
					<option value="12:10">12:10 pm</option>
					<option value="4:40">4:40 pm</option>
					<option value="7:30">7:30 pm</option>
					<option value="10:10">10:10 pm</option>
				</select>
				<br>				
				<label for="ticket-type">Ticket Type: </label>
				<select id="ticket-type" name="ticket-type">
					<option value="general">General Admission - $15.00</option>
					<option value="age-specific">Senior/Child - $5.00</option>
					<option value="special">Tuesday Special - $5.00</option>
				</select>
				<br>				
				<label for="how-many">Number of Tickets: </label>
				<input type="number" name="amount" size="2" min="1" max="<%= seatsAvailable("Forrest Gump") %>"/><br>
				<span>There are <%= seatsAvailable("Forrest Gump") %> seats left.</span>
			</span>
			</td></tr></table>
			</div>
			
			<div class="submit-button">
				<b><input type="submit" value="BUY TICKETS"></b>
			</div>
			
			
		</form>
	</div>

</body>
</html>