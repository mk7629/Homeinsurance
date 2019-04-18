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
<title>Admin Search Result Page</title>
</head>
<body>

	<%@ include file="AdminHeader.jsp"%>
	<h2>${user.userName} Policies</h2>
	<div class="container">
		<div class="row">
			<table class="table table-bordered">
				<tr>
					<th>User Id</th>
					<th>Quote Id</th>
					<th>Policy Key</th>
					<th>Effective Date</th>
					<th>End Date</th>
					<th>Policy Term</th>
					<th>Policy Status</th>
					<th>Renew</th>
					<th>Cancel</th>
				</tr>
				<c:forEach items="${policies}" var="policy">
					<tr>
						<td>${policy.userId}</td>
						<td>${policy.quoteId}</td>
						<td>${policy.policyId}</td>
						<td>${policy.effectiveDate}</td>
						<td>${policy.endDate}</td>
						<td>${policy.term}</td>
						<td>${policy.policyStatus}</td>
						<td><form action="updatePolicy?pid=${policy.policyId}&ele=update" method="post">
								<input type="submit" value="Renew" class="btn" />
							</form></td>
						<td><form action="updatePolicy?pid=${policy.policyId}&ele=delete" method="post">
								<input type="submit" value="Cancel" class="btn" />
							</form></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<form action="SearchUser" method="post">
			<div class="form-group">
				<label>Search User</label> <input type="text" name="userName" required />
			</div>

			<div>
				<input type="submit" value="Search" class="btn" />
			</div>

		</form>
	</div>
	<%@ include file="Footer.jsp"%>
</body>
</html>