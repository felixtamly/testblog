<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit ${blog.title}</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
</head>

<body>
	<jsp:include page="navbar.jsp" />
	<div class="container">

		<form:form modelAttribute="blog" method="post" action="UpdatePost">

			<form:hidden path="blogId" />

			<div class="form-group">
				<form:label class="control-label" path="title">Title</form:label>
				<form:input type="text" class="form-control" name="title"
					path="title" required="required"></form:input>
			</div>

			<div class="form-group">
				<form:label class="control-label" path="content">Content:</form:label>
				<form:textarea class="form-control" id="textarea" rows="6" name="content"
					path="content" required="required"></form:textarea>
				<p id="count"></p>
			</div>
			<button type="submit" class="btn btn-default">Update</button>
		</form:form>
	</div>

	<script>
		document.getElementById('textarea').onkeyup = function() {
			document.getElementById('count').innerHTML = "Characters left: "
					+ (4000 - this.value.length) + "/4000";
		};
	</script>
</body>
</html>