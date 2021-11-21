<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
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
						  	<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Saúde
	    					<span class="caret"></span></button>
	    					<ul class="dropdown-menu">
	      						<li class="nav-item"><a class="nav-link" href="health?action=list">Pressão</a></li>
	      						<li class="nav-item"><a class="nav-link" href="#">Peso</a></li>
	    					</ul>
						</div>
				</div>
			</nav>

			<!-- Usuario e drop down para opcoes -->
			<c:if test="${empty user }">
				<span class="navbar-text text-danger" style="margin-right: 10px">
					${erro } </span>
				<form class="form-inline my-2 my-lg-0" action="login" method="post">
					<input class="form-control mr-sm-2" type="text" name="email"
						placeholder="E-mail"> <input class="form-control mr-sm-2"
						type="password" name="password" placeholder="Senha">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Entrar</button>
				</form>
			</c:if>
			<c:if test="${not empty user }">
				<span class="navbar-text"> ${user } <a href="login"
					class="btn btn-outline-primary my-2 my-sm-0">Sair</a>
				</span>
			</c:if>
		</header>
	</div>
</body>
</html>