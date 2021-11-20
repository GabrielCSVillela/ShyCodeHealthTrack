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
		<form class="form-restaurant" action="health" method="post">
			<input type="hidden" value="update" name="action"> <input
				type="hidden" value="${bloodPressure.id}" name="id">

			<div style="display: flex; margin-bottom: 10px;">
				<h5 style="margin-left: 12px;" class="sub-title-food">Saúde</h5>
			</div>
			<div class="form-row">
				<div class="col-md-4 mb-3">
					<label for="validationServer01">Pressão mínima</label> <input
						type="text" class="form-control" value="${bloodPressure.minPressure}"
						id="id-nome" name="min_press" placeholder="Pressão mínima" required>
					<div class="invalid-tooltip">Digite a pressão mínima</div>
				</div>
				<div class="col-md-4 mb-3">
					<label for="validationServer01">Pressão máxima</label> <input
						type="text" class="form-control" value="${bloodPressure.maxPressure}"
						id="id-caloria" name="max_press" placeholder="Pressão máxima"
						required>
					<div class="invalid-tooltip">Digite a pressão máxima</div>
				</div>
				<div class="col-md-4 mb-3">
					<label for="validationServer01">Data e hora medição</label> <input
						type="datetime-local" class="form-control" value="${bloodPressure.timeMeasurement.time}"
						id="id-descricao" name="time_measurement" placeholder="Data e hora"
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