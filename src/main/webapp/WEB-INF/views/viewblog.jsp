<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View your entries</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.container {
	background: white;
}
</style>
</head>

<body>
	<jsp:include page="navbar.jsp" />
	<div class="container">

		<!--  
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
						<td id="arrangedDate"><c:out value="${formattedDate}" /></td>
						<td><c:out value="${blog.title}" /></td>
						<td><form method="post" action="ShowDetails">
								<input type="hidden" class="form-control" id="blogId"
									name="blogId" value="${blog.blogId}">
								<button type="submit" class="btn btn-default">Details</button>
							</form></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		 -->

		<sql:setDataSource var="source" driver="oracle.jdbc.OracleDriver"
			url="jdbc:oracle:thin:@localhost:1521:xe" user="trainee1"
			password="!QAZSE4" />

		<sql:query dataSource="${source}" var="resultDateDesc">
		SELECT * FROM BLOG_BLOGS WHERE USERNAME='${sessionUser.username}' ORDER BY DATE_OF_PUBLICATION DESC
		</sql:query>

		<sql:query dataSource="${source}" var="resultDateAsc">
		SELECT * FROM BLOG_BLOGS WHERE USERNAME='${sessionUser.username}' ORDER BY DATE_OF_PUBLICATION
		</sql:query>

		<sql:query dataSource="${source}" var="resultTitleDesc">
		SELECT * FROM BLOG_BLOGS WHERE USERNAME='${sessionUser.username}' ORDER BY LOWER(TITLE) DESC
		</sql:query>

		<sql:query dataSource="${source}" var="resultTitleAsc">
		SELECT * FROM BLOG_BLOGS WHERE USERNAME='${sessionUser.username}' ORDER BY LOWER(TITLE)
		</sql:query>

		<table class="table">
			<thead>
				<tr>
					<th>Date of Publication
						<button class="glyphicon glyphicon-sort-by-attributes"
							onclick="showDateAsc()"></button>
						<button class="glyphicon glyphicon-sort-by-attributes-alt"
							onclick="showDateDesc()"></button>
					</th>
					<th>Title
						<button class="glyphicon glyphicon-sort-by-attributes"
							onclick="showTitleAsc()"></button>
						<button class="glyphicon glyphicon-sort-by-attributes-alt"
							onclick="showTitleDesc()"></button>
					</th>
					<th>&nbsp;</th>
				</tr>
			</thead>

			<tbody id="resultTable">

				<c:forEach var="row" items="${resultDateDesc.rows}">
					<tr>
						<fmt:formatDate type="both" dateStyle="long" timeStyle="long"
							value="${row.date_of_publication}" var="newFormattedDate" />
						<td id="arrangedDate"><c:out value="${newFormattedDate}" /></td>
						<td><c:out value="${row.title}" /></td>
						<td><form method="post" action="ShowDetails">
								<input type="hidden" class="form-control" id="blogId"
									name="blogId" value="${row.blog_id}">
								<button type="submit" class="btn btn-default">Details</button>
							</form></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<!-- date ascending order -->
		<script id="scriptDateAsc">
			<c:forEach var="row" items="${resultDateAsc.rows}">
			<tr>
			<fmt:formatDate type="both" dateStyle="long" timeStyle="long"
				value="${row.date_of_publication}" var="newFormattedDate" />
			<td id="arrangedDate"><c:out value="${newFormattedDate}" /></td>
			<td><c:out value="${row.title}" /></td>
			<td><form method="post" action="ShowDetails">
			<input type="hidden" class="form-control" id="blogId"
						name="blogId" value="${row.blog_id}">
			<button type="submit" class="btn btn-default">Details</button>
			</form></td>
			</tr>
			</c:forEach>
		</script>

		<!-- date descending order -->
		<script id="scriptDateDesc">
			<c:forEach var="row" items="${resultDateDesc.rows}">
			<tr>
			<fmt:formatDate type="both" dateStyle="long" timeStyle="long"
					value="${row.date_of_publication}" var="newFormattedDate" />
			<td id="arrangedDate"><c:out value="${newFormattedDate}" /></td>
			<td><c:out value="${row.title}" /></td>
			<td><form method="post" action="ShowDetails">
			<input type="hidden" class="form-control" id="blogId"
							name="blogId" value="${row.blog_id}">
			<button type="submit" class="btn btn-default">Details</button>
			</form></td>
			</tr>
			</c:forEach>
		</script>

		<!-- title ascending order -->
		<script id="scriptTitleAsc">
			<c:forEach var="row" items="${resultTitleAsc.rows}">
			<tr>
			<fmt:formatDate type="both" dateStyle="long" timeStyle="long"
			value="${row.date_of_publication}" var="newFormattedDate" />
			<td id="arrangedDate"><c:out value="${newFormattedDate}" /></td>
			<td><c:out value="${row.title}" /></td>
			<td><form method="post" action="ShowDetails">
			<input type="hidden" class="form-control" id="blogId"
					name="blogId" value="${row.blog_id}">
			<button type="submit" class="btn btn-default">Details</button>
			</form></td>
			</tr>
			</c:forEach>
		</script>

		<!-- title descending order -->
		<script id="scriptTitleDesc">
			<c:forEach var="row" items="${resultTitleDesc.rows}">
			<tr>
			<fmt:formatDate type="both" dateStyle="long" timeStyle="long"
					value="${row.date_of_publication}" var="newFormattedDate" />
			<td id="arrangedDate"><c:out value="${newFormattedDate}" /></td>
			<td><c:out value="${row.title}" /></td>
			<td><form method="post" action="ShowDetails">
			<input type="hidden" class="form-control" id="blogId"
							name="blogId" value="${row.blog_id}">
			<button type="submit" class="btn btn-default">Details</button>
			</form></td>
			</tr>
			</c:forEach>
		</script>

		<script>
			function showDateAsc() {
				document.getElementById("resultTable").innerHTML = document
						.getElementById("scriptDateAsc").innerHTML;
			}

			function showDateDesc() {
				document.getElementById("resultTable").innerHTML = document
						.getElementById("scriptDateDesc").innerHTML;
			}

			function showTitleAsc() {
				document.getElementById("resultTable").innerHTML = document
						.getElementById("scriptTitleAsc").innerHTML;
			}

			function showTitleDesc() {
				document.getElementById("resultTable").innerHTML = document
						.getElementById("scriptTitleDesc").innerHTML;
			}
		</script>

	</div>


</body>
</html>