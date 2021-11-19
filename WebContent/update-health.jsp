<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="header.jsp"%>
<title>Atualizar Dados Saúde</title>
</head>
<%@ include file="menu.jsp"%>
<body>


	<div class="container">
		<form class="form-restaurant" action="cadastro" method="post">
			<input type="hidden" value="editar" name="acao"> <input
				type="hidden" value="${restaurantes.idRestaurant}" name="codigo">
			<input type="hidden" value="${restaurantes.address.idAddress}"
				name="codigoEndereco">

			<div style="display: flex; margin-bottom: 10px;">
				<h5 style="margin-left: 12px;" class="sub-title-food">Saúde</h5>
			</div>
			<div class="form-row">
				<div class="col-md-4 mb-3">
					<label for="validationServer01">Pressão mínima</label> <input
						type="text" class="form-control" value="${restaurantes.name}"
						id="id-nome" name="nome" placeholder="Pressão mínima" required>
					<div class="invalid-tooltip">Digite a pressão mínima</div>
				</div>
				<div class="col-md-4 mb-3">
					<label for="validationServer01">Pressão máxima</label> <input
						type="text" class="form-control" value="${restaurantes.CNPJ}"
						id="id-caloria" name="caloria" placeholder="Pressão máxima"
						required>
					<div class="invalid-tooltip">Digite a pressão máxima</div>
				</div>
				<div class="col-md-4 mb-3">
					<label for="validationServer01">Data e hora medição</label> <input
						type="text" class="form-control" value="${restaurantes.minPrice}"
						id="id-descricao" name="descricao" placeholder="Data e hora"
						required>
					<div class="invalid-tooltip">Digite a data e hora</div>

				</div>
			</div>

			<hr style="width: 100%;">
			<div style="text-align: -webkit-right;">
				<input type="submit" value="Salvar" class="btn btn-primary">
				<a href="cadastro?acao=listar" class="btn btn-danger">Cancelar</a>
			</div>
		</form>
	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>