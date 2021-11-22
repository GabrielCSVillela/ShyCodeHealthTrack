<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="resources/css/styles.css">
<link rel="stylesheet" href="resources/css/bootstrap.css">
</head>
<body>
	<div class="container-fluid">
		<header
			class="d-flex justify-content-around align-items-center border-bottom">
			<!-- Logo e nome healthtrack -->
			<div class="pl-5">
				<nav class="navbar navbar-light bg-light">
					<div>
						<a class="navbar-brand" href="home.jsp"> <img
							src="resources/images/logo.png" alt="" width="40" height="40"
							class="d-inline-block align-text-bottom"> HealthTrack
						</a>
					</div>
				</nav>
			</div>
			<!-- Navbar side burguer -->
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
					<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
						<li class="nav-item active"><a class="nav-link"
							href="home.jsp">Home</a></li>
						<li class="nav-item"><a class="nav-link"
							href="activity?action=list">Atividade</a></li>
						<li class="nav-item"><a class="nav-link"
							href="meal?action=list">Alimentação</a></li>
						<!--  <li class="nav-item">
							<a class="nav-link" href="health?action=list">Saúde</a>
						</li> -->
					</ul>
					<div class="dropdown">
						<button class="btn btn-default dropdown-toggle" type="button"
						style="color: rgba(0, 0, 0, 0.55);"	data-toggle="dropdown">
							Saúde <span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							<li class="nav-item"><a class="nav-link"
								href="health?action=list">Pressão</a></li>
							<li class="nav-item"><a class="nav-link"
								href="weight?action=list">Peso</a></li>
						</ul>
					</div>
				</div>
			</nav>

			<!-- Usuario e drop down para opcoes -->
			<!--<c:if test="${empty user }">
				<span class="navbar-text text-danger" style="margin-right: 10px">
					${erro } </span>
				<form class="form-inline my-2 my-lg-0" action="login" method="post">
					<input class="form-control mr-sm-2" type="text" name="email"
						placeholder="E-mail"> <input class="form-control mr-sm-2"
						type="password" name="password" placeholder="Senha">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Entrar</button>
				</form>
			</c:if>-->
			<nav class="navbar navbar-expand-sm">
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbar-list-4" aria-controls="navbarNav"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbar-list-4">
					<ul class="navbar-nav">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#"
							id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false"> <img
								src="https://s3.eu-central-1.amazonaws.com/bootstrapbaymisc/blog/24_days_bootstrap/fox.jpg"
								width="40" height="40" class="rounded-circle border border-dark">
						</a>
							<div class="dropdown-menu"
								aria-labelledby="navbarDropdownMenuLink">
								<a class="dropdown-item" href="client?action=open-form-update">Editar perfil</a> 
								<a class="dropdown-item border-top" href="login">Sair</a>
							</div></li>
					</ul>
				</div>
			</nav>

		</header>
	</div>
</body>
</html>