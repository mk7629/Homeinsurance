<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<style>
html
body{
	font-family: 'Open Sans', sans-serif;
	font-size: 14px;
	text-weight: normal;
	 

}

h1 {
	text-align: center;
	margin: 0 0 1% 0;
}

header {
    margin: 5% 5% 5% 5%;
    color: #a6a6a6;
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
<title>Registration Page</title>
</head>
<body>
	<h1>Registration Page</h1>
	<form action="registerUser" method="post">
		<div>
			<label>User Name:</label>
			<input type="text" name="userName" />
			<input type="hidden" name="adminRole" value="user">
		</div>
		<div>
			<label>Password:</label>
			<input type="password" name="password1" />
		</div>
		<div>
			<label>Password Confirmation:</label>
			<input type="password" name="password2" />
		</div>

		<div>
			<input type="submit" value="Register" />
		</div>
	</form>
	<a href="showLoginPage">Back to Login Page</a>
</body>
</html>