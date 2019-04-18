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
<title>Quote Summary</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<div class="container">
		<h2>Quote Summary</h2>
		<h4 style="text-align: center">
			Monthly Premium: <span style="color: red">$</span>${quote.monthlyPremium}</h4>

		<div class="form-group">
			<form
				action="showBuyPolicy?qid=${quote.quoteId}&id=${currentUser.userId}"
				method="post">
				<input type="submit" value="Buy Quote" class="btn" />
			</form>
		</div>
		<div class="row">
			<div class="col-sm-6">
				<table class="table table-bordered ">
					<th colspan="2">Location Details</th>
					<tr>
						<td>Quote Id</td>
						<td>${quote.quoteId}</td>
					</tr>
					<tr>
						<td>Residence Type</td>
						<td>${location.residenceType}</td>
					</tr>
					<tr>
						<td>Adress1</td>
						<td>${location.addressLine1}</td>
					</tr>
					<tr>
						<td>Adress2</td>
						<td>${location.addressLine2}</td>
					</tr>
					<tr>
						<td>City</td>
						<td>${location.city}</td>
					</tr>
					<tr>
						<td>State</td>
						<td>${location.locationState}</td>
					</tr>

					<tr>
						<td>Zip</td>
						<td>${location.zipCode}</td>
					</tr>
					<tr>
						<td>Residence Use</td>
						<td>${location.residenceUse}</td>
					</tr>
				</table>
			</div>
			<div class="col-sm-6">
				<table class="table">
					<th colspan="2">Homeowner Details</th>
					<tr>
						<td>First Name</td>
						<td>${homeowner.firstName}</td>
					</tr>
					<tr>
						<td>Last Name</td>
						<td>${homeowner.lastName}</td>
					</tr>
					<tr>
						<td>Date of Birth</td>
						<td>${homeowner.dob}</td>
					</tr>
					<tr>
						<td>Is Retired?</td>
						<td>${homeowner.retiredStatus}</td>
					</tr>
					<tr>
						<td>Social Security Number</td>
						<td>${homeowner.ssn}</td>
					</tr>
					<tr>
						<td>Email</td>
						<td>${homeowner.email}</td>
					</tr>

				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-6">
				<table class="table">
					<th colspan="2">Property Details</th>
					<tr>
						<td>Market Value</td>
						<td>$ ${property.marketValue}</td>
					</tr>
					<tr>
						<td>Year Built</td>
						<td>${property.yearBuilt}</td>
					</tr>
					<tr>
						<td>Square Footage</td>
						<td>${property.squareFootage}</td>
					</tr>
					<tr>
						<td>Dwelling Type</td>
						<td>${property.dwellingType}</td>
					</tr>
					<tr>
						<td>Roof Material</td>
						<td>${property.roofMaterial}</td>
					</tr>
					<tr>
						<td>Garage Type</td>
						<td>${property.garageType}</td>
					</tr>

					<tr>
						<td>Full Baths</td>
						<td>${property.fullBaths}</td>
					</tr>
					<tr>
						<td>Half Baths</td>
						<td>${property.halfBaths}</td>
					</tr>
					<tr>
						<td>Swimming pool</td>
						<td>${property.pool}</td>
					</tr>
				</table>
			</div>
			<div class="col-sm-6">
				<table class="table">
					<th colspan="2">Coverage Details</th>
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
		</div>
	</div>

	<%@ include file="Footer.jsp"%>
</body>
</html>