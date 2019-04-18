<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
<title>Buy Policy</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<div class="container">
	<h2>Buy Policy</h2>
	<p>
		<b>Quote Id:</b> ${qId}
	</p>
	<p>
		<b><span style="color: red">Note:</span>
			Policy Start date cannot be more than 60days from today's date.
		</b>
	</p>
	<form action="buyPolicy?qid=${qId}&id=${currentUser.userId}" method="post">
		<div class="form-group">
			<label>Enter Policy Start Date:</label> 
			<input type="date" name="startDate" required /> 
			</div>
			<div>
			<label><a
				href="showTerm?id=${currentUser.userId}">Please click and read
					terms and conditions before buying policy. </a>
			</label> 
			</div>
			<div>
			<input type="radio" name="term" required /> This is to acknowledge that I have read the
			terms and conditions of the policy.
		</div>
		<div>
		<input type="submit" value="Submit" class="btn"/>
		</div>

	</form>
</div>
	<%@ include file="Footer.jsp"%>

</body>
</html>