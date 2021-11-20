<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Health</title>
<%@ include file="header.jsp"%>
</head>
<%@ include file="menu.jsp"%>
<body>

	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
				<div class="navbar-nav">
					<a class="nav-item nav-link active" href="health.jsp">Listar</a> 
					<a class="nav-item nav-link" href="register-health.jsp">Cadastrar</a>
				</div>
			</div>
		</nav>
	</div>

	<div style="width: 100%" class="list-restaurants">
		
		<table class="table table-striped">
			<tr>
				<th>Data e Hora</th>
				<th>Pressão Min.</th>
				<th>Pressão Max.</th>
			</tr>
			<c:forEach items="${bloodPressures }" var="bp">
				<tr>
					<td>${bp.timeMeasurement}</td>
					<td>${bp.minPressure}</td>
					<td>${bp.maxPressure}</td>
					<td>
					<!--
					<c:url value="cadastro" var="link">
						<c:param name="acao" value="abrir-form-edicao" />
						<c:param name="codigo" value="${bp.idRestaurant}" />
						 </c:url> <a href="${link}" class="btn btn-primary btn-xs">Editar</a> 
					-->	
						<button type="button" class="btn btn-danger btn-xs"
							data-toggle="modal" data-target="#excluirModal"
							onclick="codigoExcluir.value = ${bp.id}">
							Excluir</button></td>
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