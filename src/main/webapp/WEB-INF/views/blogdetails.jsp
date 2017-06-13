<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${blog.title}</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
form {
	display: inline;
}
</style>
</head>

<body>
	<jsp:include page="navbar.jsp" />

	<sql:setDataSource var="source" driver="oracle.jdbc.OracleDriver"
		url="jdbc:oracle:thin:@localhost:1521:xe" user="trainee1"
		password="!QAZSE4" />

	<sql:query dataSource="${source}" var="result">
		SELECT * FROM BLOG_COMMENTS WHERE BLOG_ID='${sessionBlog.blogId}' ORDER BY DATE_OF_PUBLICATION DESC
		</sql:query>

	<div class="container">
		<div class="jumbotron">
			<h2>${blog.title}</h2>
			<h5>
				<fmt:formatDate type="both" dateStyle="long" timeStyle="long"
					value="${blog.dateOfPublication}" var="formattedDate" />
				<span class="glyphicon glyphicon-time"></span> Post by
				${blog.member.username}, ${formattedDate}
			</h5>
			<br>
			<pre>${blog.content}</pre>

			<c:choose>

				<c:when test="${sessionUser.username eq blog.member.username}">
					<div class="input-group" role="group">
						<form method="post" action="EditPost">
							<input type="hidden" class="form-control" id="blogId"
								name="blogId" value="${blog.blogId}">
							<button type="submit" class="btn btn-primary">Edit</button>
						</form>

						<form id="delete" method="post" action="DeletePost">
							<input type="hidden" class="form-control" id="blogId"
								name="blogId" value="${blog.blogId}">
							<button onclick="return confirmToDeletePost();" type="submit"
								class="btn btn-danger">Delete</button>
						</form>

						<a href="homepage"><button class="btn btn-default">Back</button></a>
					</div>
				</c:when>

				<c:otherwise>
					<button class="btn btn-default" onclick="goBack()">Back</button>
				</c:otherwise>

			</c:choose>

			<br>
			<c:if test="${!empty sessionUser}">
				<hr>
				<form method="post" action="SubmitComment">

					<div class="form-group">
						<input type="hidden" class="form-control" id="blogId"
							name="blogId" value="${blog.blogId}"> <label
							for="content">Comment:</label>
						<textarea class="form-control" id="textarea" rows="3"
							name="content" maxlength="4000" required></textarea>
						<h6 id="count">Characters left: 4000/4000</h6>
					</div>
					<button type="submit" class="btn btn-default">Submit</button>

				</form>
			</c:if>
			<br>

			<c:forEach var="row" items="${result.rows}">
				<hr>
				<h3>${row.title}</h3>
				<h6>
					<fmt:formatDate type="both" dateStyle="long" timeStyle="long"
						value="${row.date_of_publication}" var="formattedDate" />
					<span class="glyphicon glyphicon-comment"></span> Comment by
					${row.username}, ${formattedDate}
				</h6>
				<br>
				<pre>${row.content}</pre>

				<c:if test="${sessionUser.username eq row.username}">
					<form method="post" action="DeleteComment">
						<input type="hidden" class="form-control" id="commentId"
							name="commentId" value="${row.comment_id}">
						<button onclick="return confirmToDeleteComment();" type="submit"
							class="btn btn-danger btn-sm">Delete</button>
					</form>
				</c:if>


			</c:forEach>


			<script>
				function confirmToDeletePost() {
					var r = confirm("Are you sure you want to delete ${blog.title}?");
					return r;
				}

				function confirmToDeleteComment() {
					var r = confirm("Are you sure you want to delete your comment?");
					return r;
				}

				document.getElementById('textarea').onkeyup = function() {
					document.getElementById('count').innerHTML = "Characters left: "
							+ (4000 - this.value.length) + "/4000";
				};

				function goBack() {
					window.history.back();
				}
			</script>
		</div>
	</div>

</body>
</html>