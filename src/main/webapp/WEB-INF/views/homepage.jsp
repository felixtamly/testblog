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
<style>
.buttonAsText {
	background: none;
	border: none;
	margin: 0;
	padding: 0;
}

#pageButton {
	font-family: 'Nunito', sans-serif;
	margin: auto;
}
</style>
</head>

<body>
	<jsp:include page="navbar.jsp" />

	<div class="container">

		<c:forEach var="blog2" items="${blogList2}">
			<p>Print: ${blog2.title}, ${blog2.dateOfPublication}</p>
		</c:forEach>

		<h1>Latest posts</h1>
		<br>

		<c:forEach var="blog" items="${blogList}">
			<div class="jumbotron container-fluid">


				<h2>${blog.title}</h2>
				<form method="get" action="listYourDetails">
					<h5>
						<fmt:formatDate type="both" dateStyle="long" timeStyle="long"
							value="${blog.dateOfPublication}" var="formattedDate" />
						<span class="glyphicon glyphicon-time"></span> Post by <input
							type="hidden" class="form-control" id="username" name="username"
							value="${blog.member.username}">
						<button class="buttonAsText" type="submit">
							<strong>${blog.member.username}</strong>,
						</button>
						${formattedDate}
					</h5>
				</form>

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

		<p style="text-align: center;">Page ${pageNumber}</p>

		<div id="pageButton" class="btn-group btn-group-justified">

			<c:if test="${not isFirstPage}">
				<a href="previouspage"
					class="glyphicon glyphicon-chevron-left btn btn-info"></a>
			</c:if>

			<c:if test="${not isLastPage}">
				<a href="nextpage"
					class="glyphicon glyphicon-chevron-right btn btn-info"></a>
			</c:if>

		</div>
		<br>
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