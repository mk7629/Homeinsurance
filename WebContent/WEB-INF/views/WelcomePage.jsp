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
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
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
<title>Welcome Page</title>
</head>
<body>

	<%@ include file="Header.jsp"%>
	<div class="container">
		<h2>Welcome ${currentUser.userName}!</h2>

		<div class="row">
			<div class="col-6">
				<p>Lorem Ipsum is simply dummy text of the printing and
					typesetting industry. Lorem Ipsum has been the industry's standard
					dummy text ever since the 1500s, when an unknown printer took a
					galley of type and scrambled it to make a type specimen book. It
					has survived not only five centuries, but also the leap into
					electronic typesetting, remaining essentially unchanged. It was
					popularised in the 1960s with the release of Letraset sheets
					containing Lorem Ipsum passages, and more recently with desktop
					publishing software like Aldus PageMaker including versions of
					Lorem Ipsum</p>
			</div>

			<div class="col-1">
				<form action="showGetQuote?id=${currentUser.userId}" method="post">
					<input type="submit" value="Get Start" class="btn btn-primary" />
				</form>
			</div>
			<div class="col-4">
				<form action="showQuoteList?id=${currentUser.userId}" method="post">
					<input type="submit" value="Retrieve a Quote" class="btn btn-info" />
				</form>

			</div>
		</div>
	</div>
	<%@ include file="Footer.jsp"%>
</body>
</html>