<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
body {
	background-color: #99CCFF;
}

#welcomeback {
	color: gainsboro;
}
</style>

<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand">TestBlog</a>
		</div>
		<ul class="nav navbar-nav">

			<c:choose>
				<c:when test="${empty sessionUser}">
					<li><a href="homepage">Home</a></li>
					<li><a href="signup">Sign up</a></li>
					<li><a href="login">Log in</a></li>
				</c:when>

				<c:otherwise>
					<li><a href="homepage">Home</a></li>
					<li><a href="writeblog">Write a post</a></li>
					<li><a href="listYourPosts">Your posts</a></li>
					<li><a href="Logout">Log out</a></li>
				</c:otherwise>
			</c:choose>

		</ul>

		<c:choose>
			<c:when test="${!empty sessionUser}">
				<ul class="nav navbar-nav navbar-right">
					<li><p id="welcomeback">Welcome back, ${sessionUser.username}</p></li>
				</ul>
			</c:when>
		</c:choose>
	</div>


</nav>