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
<title>Quote List</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<h2>Here is your Quote List, ${currentUser.userName}!</h2>
	<div class="container">

		<div class="row">
			<table class="table table-bordered">
				<tr>
					<th>Quote Id</th>
					<th>Monthly Premium</th>
					<th>Dwelling Coverage</th>
					<th>Detached Structures</th>
					<th>Personal Property</th>
					<th>Additional Living Expense</th>
					<th>Medical Expense</th>
					<th>Deductible</th>
					<th>Buy</th>

				</tr>
				<c:forEach items="${quotes}" var="quote">
					<tr>
						<td>${quote.quoteId}</td>
						<td>$ ${quote.monthlyPremium}</td>
						<td>$ ${quote.dwellingCoverage}</td>
						<td>$ ${quote.detatchedStructures}</td>
						<td>$ ${quote.personalProperty}</td>
						<td>$ ${quote.addLivingExp}</td>
						<td>$ ${quote.medicalExpenses}</td>
						<td>$ ${quote.deductible}</td>
						<td>
							<form
								action="showBuyPolicy?qid=${quote.quoteId}&id=${currentUser.userId}"
								method="post">
								<input type="submit" value="Buy Quote" class="btn" />
							</form>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>


		<%@ include file="Footer.jsp"%>
</body>
</html>