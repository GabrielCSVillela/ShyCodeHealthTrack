<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="header.jsp"%>
<title>Registrar Atividade</title>
</head>
<%@ include file="menu.jsp"%>
<body>
	<div class="container" style="height: 56vh;">
	
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
			
		<h1>Cadastro de Atividade</h1>
		<c:if test="${not empty msg }">
			<div class="alert alert-success">${msg}</div>
		</c:if>
		<c:if test="${not empty erro }">
			<div class="alert alert-danger">${erro}</div>
		</c:if>
		<form action="activity" method="post">
			<input type="hidden" value="register" name="action">
			<div class="form-group">
				<label for="id-nome">Nome Atividade</label> <input type="text"
					name="name_activity" id="id-nome" class="form-control" required>
			</div>
			<div class="form-group">
				<label for="id-valor">Caloria</label> <input type="text"
					name="calorie" id="id-valor" class="form-control" required>
			</div>
			<div class="form-group">
				<label for="id-quantidade">Hora Início</label> <input
					type="datetime-local" name="time_start" id="id-quantidade"
					class="form-control" required>
			</div>
			<div class="form-group">
				<label for="id-fabricacao">Hora Final</label> <input
					type="datetime-local" name="time_end" id="id-fabricacao"
					class="form-control" required>
			</div>
			<input type="submit" value="Salvar" class="btn btn-primary">
		</form>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>