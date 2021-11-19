<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="header.jsp"%>
<title>Cadastrar Saúde</title>
</head>
<%@ include file="menu.jsp"%>
<body>
	<div class="container">
		<h1>Cadastro de Pressão</h1>
		<c:if test="${not empty msg }">
			<div class="alert alert-success">${msg}</div>
		</c:if>
		<c:if test="${not empty erro }">
			<div class="alert alert-danger">${erro}</div>
		</c:if>
		<form action="health" method="post">
			<input type="hidden" value="register" name="action">
			<div class="form-group">
				<label for="id-nome">Dia de Medição</label> <input type="datetime-local"
					name="time_measurement" id="id-nome" class="form-control" required>
			</div>
			<div class="form-group">
				<label for="id-quantidade">Pressão Mínima</label> <input type="text"
					name="min_press" id="id-quantidade" class="form-control" required>
			</div>
			<div class="form-group">
				<label for="id-valor">Pressão Máxima</label> <input type="text"
					name="max_press" id="id-valor" class="form-control" required>
			</div>
			
			<input type="submit" value="Salvar" class="btn btn-primary">
		</form>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>