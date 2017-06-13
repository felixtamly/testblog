<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Write an entry</title>
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
		<form method="post" action="SubmitPost">
			<div class="form-group">
				<label for="title">Title:</label> <input type="text"
					class="form-control" name="title" placeholder="Your title" required>
			</div>

			<div class="form-group">
				<label for="content">Content:</label>
				<textarea class="form-control" id="textarea" rows="6" name="content" maxlength="4000" required></textarea>
				<p id="count">Characters left: 4000/4000</p>
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form>
	</div>

	<script>
		document.getElementById('textarea').onkeyup = function() {
			document.getElementById('count').innerHTML = "Characters left: "
					+ (4000 - this.value.length) + "/4000";
		};
	</script>


</body>
</html>