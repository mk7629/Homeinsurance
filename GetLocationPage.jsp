<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
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

<title>Get Quote</title>
</head>

<body>
	
	<%@include file="Header.jsp" %>
	<div class="container">
	<h2>Get Quote</h2>
	
	<form action="getQuote?id=${currentUser.userId}" method="post">
		<div>
			<label>Residence Type:</label> 
			<select name="residenceType" required>
				<option value="" selected>Choose option</option>
				<option value="Single">Single-Family Home</option>
				<option value="Condo">Condo</option>
				<option value="Townhouse">Townhouse</option>
				<option value="Rowhouse">Rowhouse</option>
				<option value="Duplex">Duplex</option>
				<option value="Apartment">Apartment</option>
				
			</select>
			
		</div>
		<div>
			<label>Address Line 1:</label> 
			<input type="text" name="address1" required/>
		</div>
		<div>
			<label>Address Line 2:</label> 
			<input type="text" name="address2" />
		</div>
		<div>
			<label>State:</label> 
			<input type="text" name="state" required/>
		</div>
		<div>
			<label>City:</label> 
			<input type="text" name="city" required/>
		</div>
		<div>
			<label>Zip:</label> 
			<input type="text" name="zip" required/>
		</div>
		<div>
			<label>Residence Use:</label>
			<select name="residenceUse" required>
				<option value="" selected>Choose option</option>
				<option value="Primary">Primary</option>
				<option value="Secondary">Secondary</option>
				<option value="Rental">Rental Property</option>
			</select>
		</div>
		<div>
			<input type="submit" value="Continue" class="btn"/>
		</div>
	</form>
	</div>
<%@ include file="Footer.jsp" %>
</body>
</html>