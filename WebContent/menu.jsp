<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<body>
	<div class="container-xl-fluid">
		<header class="d-flex justify-content-around align-items-center border-bottom">
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


			<!-- Usuario e drop down para opcoes -->
			<div class="pr-5">
			<div class="dropdown text-end">
				<a href="#"
					class="d-block link-dark text-decoration-none dropdown-toggle"
					id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
					<img src="resources/images/user.png" alt="mdo" width="32"
					height="32" class="rounded-circle">
				</a>
				<ul class="dropdown-menu text-small" aria-labelledby="dropdownUser1"
					style="">
					<li><a class="dropdown-item" href="#">New project...</a></li>
					<li><a class="dropdown-item" href="#">Settings</a></li>
					<li><a class="dropdown-item" href="#">Profile</a></li>
					<li><hr class="dropdown-divider"></li>
					<li><a class="dropdown-item" href="sign-in.jsp">Sign out</a></li>
				</ul>
			</div>
			</div>
		</header>
	</div>
</body>
</html>