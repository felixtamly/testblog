<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log in</title>
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
	
	<p style="color:red">${loginErrorMessage} </p><br>
	
		<form method="post" action="Login">
			<div class="form-group">
				<label for="username">Username:</label> <input type="text"
					class="form-control" name="username" placeholder="Enter username"
					required>
			</div>
			<div class="form-group">
				<label for="password">Password:</label> <input type="password"
					class="form-control" name="password" placeholder="Enter password"
					required>
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form>
	</div>
</body>

</html>