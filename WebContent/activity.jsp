<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Activity</title>
<%@ include file="header.jsp"%>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
				<div class="navbar-nav">
					<a class="nav-item nav-link active" href="activity.jsp">Listar</a>
					<a class="nav-item nav-link" href="register-activity.jsp">Cadastrar</a>
				</div>
			</div>
		</nav>
	</div>

	<div style="width: 100%" class="list-restaurants">
		<table class="table table-striped">
			<tr>
				<th>Atividade</th>
				<th>Calorias</th>
				<th>Data</th>
				<th></th>
			</tr>
			<c:forEach items="${activities }" var="a">
				<tr>
					<td>${a.name}</td>
					<td>${a.calorie}</td>
					<td><fmt:formatDate value="${a.dateRecord.time}"
							pattern="dd/MM/yyyy" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="footer-sub-pages"
		style="position: absolute; bottom: 0; width: 100%;">
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>

