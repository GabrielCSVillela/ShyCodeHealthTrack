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
	<div class="container">
		<h1>Cadastro de Produto</h1>
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