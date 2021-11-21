<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>My Profile</title>
<link rel="stylesheet" href="resources/css/myprofile.css">
</head>
<body>
	<%@ include file="menu.jsp"%>
	<!-- Page content -->
	<div class="container-fluid" style="margin-top: 50px">
		<div class="row">
			<div class="col-xl-4 order-xl-2 mb-5 mb-xl-0">
				<div class="card card-profile shadow">
					<div class="row justify-content-center">
						<div class="col-lg-3 order-lg-2">
							<div class="card-profile-image">
								<a href="#"> <img width="200px" style="margin-top: 15px"
									height="200px" src="https://s3.eu-central-1.amazonaws.com/bootstrapbaymisc/blog/24_days_bootstrap/fox.jpg"
									class="rounded-circle">
								</a>
							</div>
						</div>
					</div>
					<div
						class="card-header text-center border-0 pt-8 pt-md-4 pb-0 pb-md-4">

					</div>
					<div class="card-body pt-0 pt-md-4">
						<div class="row">
							<div class="col">
								<div
									class="card-profile-stats d-flex justify-content-center mt-md-5">
									<div>
										<span class="heading">6</span> <span class="description">Atividades
											feitas</span>
									</div>
									<div>
										<span class="heading">4</span> <span class="description">Atividades
											pendentes</span>
									</div>
									<div>
										<span class="heading">10</span> <span class="description">Total
											de atividades</span>
									</div>
								</div>
							</div>
						</div>
						<div class="text-center">
							<h3>
								Guilherme Alves<span class="font-weight-light">, 20</span>
							</h3>
							<div class="h5 font-weight-300">
								<i class="ni location_pin mr-2"></i>São Paulo, Brasil
							</div>
							<div class="h5 mt-4">
								<i class="ni business_briefcase-24 mr-2"></i>
							</div>

							<hr class="my-4">
							<p>Adora fazer exercicios escutando uma boa musica :)</p>
						</div>
					</div>
				</div>
			</div>
			<div class="col-xl-8 order-xl-1">
				<div class="card bg-secondary shadow">
					<div class="card-header bg-white border-0">
						<div class="row align-items-center">
							<div class="col-8">
								<h3 class="mb-0">Meu Perfil</h3>
							</div>
							<div class="col-4 text-right">
								<a href="#!" class="btn btn-sm btn-primary">Detalhes</a>
							</div>
						</div>
					</div>
					<div class="card-body">
						<form>
							<h6 class="heading-small text-muted mb-4">User information</h6>
							<div class="pl-lg-4">
								<div class="row">
									<div class="col-lg-6">
										<div class="form-group focused">
											<label class="form-control-label" for="input-username">Nome
												do usuário</label> <input type="text" id="input-username"
												class="form-control form-control-alternative"
												placeholder="Username" value="Guilherme.Alves">
										</div>
									</div>
									<div class="col-lg-6">
										<div class="form-group">
											<label class="form-control-label" for="input-email">Email</label>
											<input type="email" id="input-email"
												class="form-control form-control-alternative"
												placeholder="guilherme@gmail.com">
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-lg-6">
										<div class="form-group focused">
											<label class="form-control-label" for="input-first-name">Primeiro
												Nome</label> <input type="text" id="input-first-name"
												class="form-control form-control-alternative"
												placeholder="Primeiro Nome" value="Guilherme">
										</div>
									</div>
									<div class="col-lg-6">
										<div class="form-group focused">
											<label class="form-control-label" for="input-last-name">Sobrenome</label>
											<input type="text" id="input-last-name"
												class="form-control form-control-alternative"
												placeholder="Sobrenome" value="Alves">
										</div>
									</div>
								</div>
							</div>
							<hr class="my-4">
							<!-- Address -->
							<h6 class="heading-small text-muted mb-4">Endereço</h6>
							<div class="pl-lg-4">
								<div class="row">
									<div class="col-md-12">
										<div class="form-group focused">
											<label class="form-control-label" for="input-address">Logradouro
												full</label> <input id="input-address"
												class="form-control form-control-alternative"
												placeholder="Home Address"
												value="Minha casa, na rua tal, no numero 666" type="text">
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-lg-4">
										<div class="form-group focused">
											<label class="form-control-label" for="input-city">Cidade</label>
											<input type="text" id="input-city"
												class="form-control form-control-alternative"
												placeholder="City" value="São Paulo">
										</div>
									</div>
									<div class="col-lg-4">
										<div class="form-group focused">
											<label class="form-control-label" for="input-country">Estado</label>
											<input type="text" id="input-country"
												class="form-control form-control-alternative"
												placeholder="Country" value="São Paulo">
										</div>
									</div>
									<div class="col-lg-4">
										<div class="form-group">
											<label class="form-control-label" for="input-country">Cep</label>
											<input type="number" id="input-postal-code"
												class="form-control form-control-alternative"
												placeholder="Cep" value="05266130">
										</div>
									</div>
								</div>
							</div>
							<hr class="my-4">
							<!-- Description -->
							<h6 class="heading-small text-muted mb-4">Mais informações</h6>
							<div class="pl-lg-4">
								<div class="form-group focused">
									<label>Descrição</label>
									<textarea rows="4"
										class="form-control form-control-alternative">Preciso ganhar peso é isso familia</textarea>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>