<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="header.jsp"%>
<title>Atualizar Refeição</title>
</head>
<%@ include file="menu.jsp"%>
<body>
	<div class="container">
		<form class="form-restaurant" action="meal" method="post">
			<input type="hidden" value="update" name="action"> <input
				type="hidden" value="${meal.id}" name="id">

			<div style="display: flex; margin-bottom: 10px;">
				<h5 style="margin-left: 12px;" class="sub-title-food">Refeição</h5>
			</div>
			<div class="form-row">
				<div class="col-md-4 mb-3">
					<label for="validationServer01">Nome Refeição</label> <input
						type="text" class="form-control" value="${meal.nameMeal}"
						id="id-nome" name="name_meal" placeholder="Nome Refeição" required>
					<div class="invalid-tooltip">Digite o nome da refeição.</div>
				</div>
				<div class="col-md-4 mb-3">
					<label for="validationServer01">Caloria Total</label> <input
						type="text" class="form-control" value="${meal.totalCalorie}"
						id="id-caloria" name="total_calorie"
						placeholder="Digite a caloria" required>
					<div class="invalid-tooltip">Digite um valor calorico.</div>
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