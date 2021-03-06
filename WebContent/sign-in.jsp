<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Login - Health Track App</title>
<link rel="stylesheet" href="resources/css/styles.css">
<%@ include file="header.jsp"%>
</head>
<body class="sign-in">
	<div class="box-sign-in w-50 h-50 rounded"
		style="background-color: #FFFFFF; padding: 20px; magin: auto;">
		<c:if test="${empty user }">
			<span class="navbar-text text-danger" style="margin-right: 10px">
				${erro } </span>
			<form class="form-sign-in" action="login" method="post">
				<div class="login-img-sign-in" style="text-align: center;">
					<img class="mb-4" src="resources/images/logo.png" alt="" width="72"
						height="72">
					<h3 class="mb-3 font-weight-normal">Login</h3>
				</div>
				<label for="inputEmail" class="sr-only">Endereço de Email</label> <input
					type="email" id="inputEmail" class="form-control my-2"
					placeholder="Email" name="email" autofocus> <label
					for="inputPassword" class="sr-only">Senha</label> <input
					type="password" id="inputPassword" class="form-control my-2"
					placeholder="Senha" name="password">

				<div class="buttons-sign-in pt-3" style="text-align: center;">
					<button class="btn btn-lg btn-primary btn-block border-white"
						style="background-color: #0C7797; color: #A3E1D2;" type="submit">Entrar</button>
					<a class="btn btn-lg btn-secondary btn-block border-white"
						style="background-color: #A3E1D2; color: #0C7797;"
						href="create-account2.jsp">Criar uma conta</a>
				</div>
			</form>
		</c:if>
		<c:if test="${not empty user }" >
			<c:redirect url="home.jsp"/>
		</c:if>
	</div>
	<%@ include file="footer-sign-in.jsp"%>
</body>
</html>