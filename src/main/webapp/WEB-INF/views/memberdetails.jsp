<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${sessionUser.username}'sDetails</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="navbar.jsp" />

	<div class="container">

		<c:choose>
			<c:when test="${sessionUser.username eq viewingMember.username}">
				<h1>Your details</h1>
			</c:when>
			<c:otherwise>
				<h1>${viewingMember.username}'s details</h1>
			</c:otherwise>
		</c:choose>
		<br>

		<div class="jumbotron">

			<p>
				<strong>Username:</strong> ${viewingMember.username}
			</p>
			<br>
			<p>
				<strong>Email: </strong> ${viewingMember.email}
			</p>
			<br>
			<p>
				<strong>Number of posts:</strong> ${numberOfPosts}
			</p>

		</div>
	</div>

</body>
</html>