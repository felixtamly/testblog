<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
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

		<h1>Latest posts</h1>
		<br>

		<c:forEach var="blog" items="${blogList}">
			<div class="jumbotron container-fluid">


				<h2>${blog.title}</h2>
				<h5>
					<fmt:formatDate type="both" dateStyle="long" timeStyle="long"
						value="${blog.dateOfPublication}" var="formattedDate" />
					<span class="glyphicon glyphicon-time"></span> Post by
					${blog.member.username}, ${formattedDate}
				</h5>
				<br>
				<div class="container">
					<c:choose>
						<c:when test="${fn:length(blog.content) gt 300}">
							<pre>${fn:substring(blog.content, 0, 300)}...</pre>
						</c:when>
						<c:otherwise>
							<pre>${blog.content}</pre>
						</c:otherwise>
					</c:choose>
				</div>

				<br>
				<form method="post" action="ShowDetails">
					<input type="hidden" class="form-control" id="blogId" name="blogId"
						value="${blog.blogId}">
					<button type="submit" class="btn btn-default">Details</button>
				</form>
			</div>
		</c:forEach>
	</div>

	<!-- 
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th>Date of Publication</th>
					<th>Title</th>
					<th>&nbsp;</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="blog" items="${blogList}">
					<tr>
						<fmt:formatDate type="both" dateStyle="long" timeStyle="long"
							value="${blog.dateOfPublication}" var="formattedDate" />
						<td><c:out value="${formattedDate}" /></td>
						<td><c:out value="${blog.title}" /></td>
						<td><form method="post" action="ShowDetails">
								<input type="hidden" class="form-control" id="blogId"
									name="blogId" value="${blog.blogId}">
								<button type="submit">Details</button>
							</form></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
	 -->

</body>
</html>