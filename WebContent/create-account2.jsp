<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="resources/css/styles.css">
<%@ include file="header.jsp"%>
<title>Insert title here</title>
</head>
<body class="create-account">
<div class="box-create-account w-50 h-75 rounded" style="background-color: #FFFFFF; padding:20px; magin:auto;">
	<h2 class="title" style="text-align: center">Crie sua conta</h2>
	<c:if test="${not empty msg }">
		<div class="alert alert-success">${msg}</div>
	</c:if>
	<c:if test="${not empty erro }">
		<div class="alert alert-danger">${erro}</div>
	</c:if>
	<form class="form-create-account" action="client" method="post">
	<input type="hidden" value="register" name="action">
		<div class="form-row">
			<div class="">
				<label for="validationDefault01">Primeiro nome</label> <input
					type="text" class="form-control" id="validationDefault01"
					placeholder="Primeiro nome" name="first_name" required>
			</div>
			<div class="">
				<label for="validationDefault02">Sobrenome</label> <input
					type="text" class="form-control" id="validationDefault02"
					placeholder="Sobrenome" name="last_name" required>
			</div>
			<div class="">
				<label for="validationDefaultUsername">Email</label>
				<div class="input-group">
				<input type="email" class="form-control"
						id="validationDefaultUsername" placeholder="Email"
						aria-describedby="inputGroupPrepend2" name="email" required>
				</div>
			</div>
		</div>
		<div class="form-row">
			<div class="">
				<label for="validationDefault03">Número Telefone</label> <input type="number"
					class="form-control" id="validationDefault03" placeholder="Telefone" name="phone"
					required>
			</div>
			<div class="">
				<label for="validationDefault03">Data de Nascimento</label> <input type="date"
					class="form-control" id="validationDefault03" placeholder="" name="birthday"
					required>
			</div>
			<div class="">
				<label for="validationDefault04">Altura</label> <input type="number"
					class="form-control" id="validationDefault04" placeholder="Altura" name="height"
					required>
			</div>
			<div class="">
				<label for="validationDefault05">Senha</label> <input type="password"
					class="form-control" id="validationDefault05" placeholder="Senha" name="password"
					required>
			</div>
		</div>
		<div class="create-account-button pt-3" style="text-align:center;">
		<button class="btn btn-primary border-white" type="submit" style="background-color: #0C7797; color: #A3E1D2;" >Criar Conta</button>
		<a class="btn btn-secondary border-white" href="sign-in.jsp" style="background-color: #A3E1D2; color: #0C7797;" >Já tenho uma conta</a>
		</div>
		
	</form>
	<%@ include file="footer-sign-in.jsp"%>
</div>
</body>
</html>
