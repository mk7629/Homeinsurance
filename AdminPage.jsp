<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
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
<title>Admin Login Page</title>
</head>
<body>
<div class="container">
<header>
	<h1>Home Insurance</h1>
</header>
	
	<h2>Welcome to admin page!</h2>
	
	<form action="/homeinsurance/admin/AdminLogin" method="post">
		<div class="form-group row">
			<label>User Name:</label>
			<input type="text" name="userName" placeholder="Enter user name" class="form-control"/>
		</div>
		<div class="form-group row">
			<label>Password:</label>
			<input type="password" name="password" placeholder="Enter password" class="form-control"/>
		</div>
		<div class="form-group row">
			<input type="submit" value="Admin Login" class="btn btn-primary"/>
			
		</div>
	</form>
	
	<%@ page import="java.util.ArrayList"%>
	<p>
	<div class="form-group row"><a href="/homeinsurance/login">Back to user</a></div>
	</p>
	<c:forEach items="${errorList}" var="error"> 
	    <p style="color: red;">${error}</p>
	</c:forEach>
</div>
<%@ include file="Footer.jsp" %>
</body>
</html>