<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Registration Page</h1>
	<form action="/loginregistration/editUser?id=${userToUpdate.userId}" method="post">
		<div>
			<label>User Name:</label>
			<input type="text" name="userName" value="${userToUpdate.userName}"/>
		</div>
		<div>
			<label>Password:</label>
			<input type="text" name="password" value="${userToUpdate.password}"/>
		</div>
		<div>
			<label>City:</label>
			<input type="text" name="locationCity" value="${userToUpdate.locationCity}"/>
		</div>
		<div>
			<label>State:</label>
			<input type="text" name="locationState" value="${userToUpdate.locationState}"/>
		</div>
		<div>
			<input type="submit" value="Update" />
		</div>
	</form>
<a href="ShowWelcomePage">Cancel</a>
</body>
</html>