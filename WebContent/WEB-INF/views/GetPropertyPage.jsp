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

<title>Property</title>
</head>
<body>
<%@ include file="Header.jsp" %>
<div class="container">
<h2>Property Details</h2>
<p>${location.getLocationId()}</p>
	<form action="getProperty?id=${currentUser.userId}" method="post">
		<div>
			<label>What is market value of your home?</label> 
			$<input type="text" name="marketValue" required/>
			<input type="hidden" name="locationId" value="${location.locationId}">
		</div>
		<div>
			<label>What year was your home was originally built?</label> 
			<input type="text" name="yearBuilt" required/>
		</div>
		<div>
			<label>Square Footage:</label> 
			<input type="text" name="squareFootage" required/>sq ft
		</div>
		<div>
			<label>Dwelling Style:</label> 
			<select name="dwellingStyle">
				<option value="1" selected>1 Story</option>
				<option value="1.5">1 ½ Stories</option>
				<option value="2">2 Stories</option>
				<option value="2.5">2 ½ Stories</option>
				<option value="3">3 Stories</option>				
			</select>

		</div>
		<div>
			<label>Roofing Material:</label> 
			<select name="roofingMaterial">
				<option value="Concrete" selected>Concrete</option>
				<option value="Clay">Clay</option>
				<option value="Rubber">Rubber</option>
				<option value="Steel">Steel</option>
				<option value="Tin">Tin</option>
				<option value="Wood">Wood</option>				
			</select>
		</div>
		<div>
			<label>Type of Garage:</label> 
			<select name="garageType">
				<option value="Attached" selected>Attached</option>
				<option value="Detached">Detached</option>
				<option value="Basement">Basement</option>
				<option value="Built">Built-In</option>
				<option value="None">None</option>				
			</select>
		</div>
		
		<div>
			<label>Number of Full-Baths:</label> 
			<select name="fullBaths">
				<option value="1" selected>1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4 or more</option>			
			</select>
		</div>
		<div>
			<label>Number of Half-Baths:</label> 
			<select name="halfBaths">
				<option value="1" selected>1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4 or more</option>			
			</select>
		</div>
		<div>
			<label>Does your home have a swimming pool?</label> 
			<input type="radio" name="swimmingPool" value="1" />Yes
			<input type="radio" name="swimmingPool" value="2" checked/>No
		</div>

		<div>
			<input type="submit" value="Continue" class="btn"/>
		</div>
	</form>
	</div>
<%@ include file="Footer.jsp" %>
</body>
</html>