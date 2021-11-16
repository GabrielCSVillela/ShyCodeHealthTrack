<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<%@ include file="header.jsp"%>
</head>
<%@ include file="menu.jsp"%>
<body>
	<div class="container-lg">
	<div class="d-flex justify-content-around m-auto pt-4">
		<div class="text-center user-select-none">
			<a class="navbar-brand" href="activity.jsp"> <img
				src="resources/images/activity.png" alt="" width="280" height="500"
				class="d-inline-block align-text-bottom">
			</a>
			<h4>Atividade Física</h4>
		</div>

		<div class="text-center user-select-none">
			<a class="navbar-brand" href="meal.jsp"> <img
				src="resources/images/meal.png" alt="" width="280" height="500"
				class="d-inline-block align-text-bottom">
			</a>
			<h4>Alimentação</h4>
		</div>

		<div class="text-center user-select-none">
			<a class="navbar-brand" href="health.jsp"> <img
				src="resources/images/health.png" alt="" width="280" height="500"
				class="d-inline-block align-text-bottom">
			</a>
			<h4>Saúde</h4>
		</div>
	</div>
</div>
	<%@ include file="footer.jsp"%>
</body>
</html>