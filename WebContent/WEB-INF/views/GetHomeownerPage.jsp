<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<style>
html
body {
	font-family: 'Open Sans', sans-serif;
	font-size: 14px;
	text-weight: normal;
}

header {
	margin: 1% 5% 5% 5%;
	color: #08088A;
}

h1 {
	text-align: center;
	margin: 0 0 1% 0;
}

h2 {
	color: #0066ff;
	text-align: center;
}

a {
	color: #4d4dff;
}


footer {
	margin: 5% 5% 0 5%;
	text-align: center;
	color: #a6a6a6;
}
</style>
<title>Homeowner</title>
</head>
<body>
<%@ include file="Header.jsp" %>
<div class="container">
<h2>Homeowner Information</h2>
	<form action="getHomeowner?id=${currentUser.userId}" method="post">
		<div>
			<label>First Name:</label> 
			<input type="text" name="firstName" required/>
			
		</div>
		<div>
			<label>Last Name:</label> 
			<input type="text" name="lastName" required/>
		</div>
		<div>
			<label>Date of Birth:</label> 
			<input type="date" name="dob" required/>
		</div>
		<div>
			<label>Are you retired:</label> 
			<input type="radio" name="retired" value="1" checked/>Yes
			<input type="radio" name="retired" value="2" />No
		</div>
		<div>
			<label>Social Security Number:</label> 
			<input type="text" name="ssn" required/>
		</div>
		<div>
			<label>Email Address:</label> 
			<input type="text" name="email" required/>
		</div>

		<div>
			<input type="submit" value="Continue" class="btn"/>
		</div>
	</form>
	</div>
<%@ include file="Footer.jsp" %>
</body>
</html>