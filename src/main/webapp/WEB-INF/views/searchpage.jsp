<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search</title>
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

		<div>
			<h1>Search</h1>
		</div>

		<br> <br>

		<div class="jumbotron">
			<h4>Enter a keyword to search in any of the fields.</h4><br>
			<form class="form-horizontal" method="post" action="searchByTitle">
				<div class="form-group">
					<label for="titleSearch" class="col-sm-1 control-label">Title:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="titleSearch"
							name="title" placeholder="Title" required>
					</div>
					<div class="col-sm-1">
						<button type="submit" class="btn btn-default">Search</button>
					</div>
				</div>
			</form>
		</div>

		<c:choose>

			<c:when test="${fn:length(resultList) gt 0}">
				<div class="jumbotron">
					<table class="table">
						<thead>
							<tr>
								<th>Date of Publication</th>
								<th>Title</th>
								<th>&nbsp;</th>
							</tr>
						</thead>

						<tbody>
							<c:forEach var="blog" items="${resultList}">
								<tr>
									<fmt:formatDate type="both" dateStyle="long" timeStyle="long"
										value="${blog.dateOfPublication}" var="formattedDate" />
									<td>${formattedDate}</td>
									<td>${blog.title}</td>
									<td><form method="post" action="ShowDetails">
											<input type="hidden" class="form-control" id="blogId"
												name="blogId" value="${blog.blogId}">
											<button type="submit" class="btn btn-default">Details</button>
										</form></td>
								</tr>
							</c:forEach>

						</tbody>

					</table>
				</div>

			</c:when>

			<c:when test="${resultList eq null}">

			</c:when>

			<c:when test="${fn:length(resultList) eq 0}">
				<div class="jumbotron">
					<h4>No results found.</h4>
				</div>
			</c:when>

		</c:choose>

	</div>

</body>
</html>