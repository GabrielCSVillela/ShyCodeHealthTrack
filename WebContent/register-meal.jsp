<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="header.jsp"%>
<title>Cadastrar Refeição</title>
</head>
<%@ include file="menu.jsp"%>
<body>
	<div class="container" style="height: 51vh;">
		<div class="container">
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarNavAltMarkup"
					aria-controls="navbarNavAltMarkup" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
					<div class="navbar-nav">
						<a class="nav-item nav-link active" href="meal?action=list">Listar</a> <a
							class="nav-item nav-link" href="register-meal.jsp">Cadastrar</a>
					</div>
				</div>
			</nav>
		</div>
		<h2>Cadastro de Refeição</h2>
		<c:if test="${not empty msg }">
			<div class="alert alert-success">${msg}</div>
		</c:if>
		<c:if test="${not empty erro }">
			<div class="alert alert-danger">${erro}</div>
		</c:if>
		<form action="meal" method="post">
			<input type="hidden" value="register" name="action">
			<div class="form-group">
				<label for="id-nome">Nome Refeição</label> <input type="text"
					name="name_meal" id="id-nome" class="form-control">
			</div>
			<div class="form-group">
				<label for="id-valor">Total Calorias</label> <input type="text"
					name="total_calorie" id="id-valor" class="form-control">
			</div>

			<input type="submit" value="Salvar" class="btn btn-primary">
		</form>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>