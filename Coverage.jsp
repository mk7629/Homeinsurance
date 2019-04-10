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
<title>Coverage Detail</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<div class="container">
		<h2>Coverage Details</h2>

		<div class="row">
			<a href="showAddPage?id=${currentUser.userId}"> Additional Info </a>
		</div>
		<div class="row">
			<table>
				<tr>
					<td>Quote Id:</td>
					<td>${quote.quoteId}</td>
				</tr>
				<tr>
					<td>Monthly Premium:</td>
					<td>$ ${quote.monthlyPremium}</td>
				</tr>
				<tr>
					<td>Dwelling Coverage:</td>
					<td>$ ${quote.dwellingCoverage}</td>
				</tr>
				<tr>
					<td>Detached Structures:</td>
					<td>$ ${quote.detatchedStructures}</td>
				</tr>
				<tr>
					<td>Personal Property:</td>
					<td>$ ${quote.personalProperty}</td>
				</tr>
				<tr>
					<td>Additional Living Expense:</td>
					<td>$ ${quote.addLivingExp}</td>
				</tr>
				<tr>
					<td>Medical Expense:</td>
					<td>$ ${quote.medicalExpenses}</td>
				</tr>
				<tr>
					<td>Deductible:</td>
					<td>$ ${quote.deductible}</td>
				</tr>
			</table>
		</div>
		<div class="row">
			<div class="form">
				<form
					action="showSummary?qid=${quote.quoteId}&id=${currentUser.userId}"
					method="post">
					<input type="submit" value="Proceed to Buy" class="btn" />
				</form>
			</div>
		</div>
	</div>


	<%@ include file="Footer.jsp"%>
</body>
</html>