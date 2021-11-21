<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="header.jsp"%>
<title>Atualizar Peso</title>
</head>
<%@ include file="menu.jsp"%>
<body>
	<div class="container">
		<form class="form-restaurant" action="weight" method="post">
			<input type="hidden" value="update" name="action"> <input
				type="hidden" value="${weight.id}" name="id">

			<div style="display: flex; margin-bottom: 10px;">
				<h5 style="margin-left: 12px;" class="sub-title-food">Refeição</h5>
			</div>
			<div class="form-row">
				<div class="col-md-4 mb-3">
					<label for="validationServer01">Peso (kg)</label> <input
						type="number" class="form-control" value="${weight.value}"
						id="id-nome" name="value" placeholder="Peso" required>
					<div class="invalid-tooltip">Digite o peso</div>
				</div>
				<div class="col-md-4 mb-3">
					<label for="validationServer01">Data</label> <input
						type="date" class="form-control" value="${weight.dateMeasurement}"
						id="id-caloria" name="date_measurement"
						placeholder="Digite a data" required>
					<div class="invalid-tooltip">Digite a data de pesagem</div>
				</div>
			</div>

			<hr style="width: 100%;">
			<div style="text-align: -webkit-right;">
				<input type="submit" value="Salvar" class="btn btn-primary">
				<a href="meal?action=list" class="btn btn-danger">Cancelar</a>
			</div>
		</form>
	</div>


	<%@ include file="footer.jsp"%>
</body>
</html>