<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="header.jsp"%>
<title>Atualizar Atividade</title>
</head>
<body>
	<%@ include file="menu.jsp"%>

	<div class="container">
		<form class="form-restaurant" action="activity" method="post">
			<input type="hidden" value="update" name="action"> <input
				type="hidden" value="${activity.id}" name="id">
			<div style="display: flex; margin-bottom: 10px;">
				<h5 style="margin-left: 12px;" class="sub-title-food">Atividade</h5>
			</div>
			<div class="form-row">
				<div class="col-md-4 mb-3">
					<label for="validationServer01">Nome</label> <input type="text"
						class="form-control" value="${activity.name}" id="id-nome"
						name="name_activity" placeholder="Nome atividade" required>
					<div class="invalid-tooltip">Digite o nome</div>
				</div>

				<div class="col-md-4 mb-3">
					<label for="validationServer01">Caloria</label> <input type="text"
						class="form-control" value="${activity.calorie}" id="id-caloria"
						name="calorie" placeholder="Caloria" required>
					<div class="invalid-tooltip">Digite a caloria</div>
				</div>

				<div class="col-md-4 mb-3">
					<label for="validationServer01">Começo</label> <input
						type="datetime-local" class="form-control" id="id-descricao"
						name="time_start" placeholder="Tempo inicio" required
						value='<fmt:formatDate value="${activity.startTime.time}"
							pattern="dd/MM/yyyy hh:mm" />'>
					<div class="invalid-tooltip">Digite o começo</div>
				</div>
				
				<div class="col-md-4 mb-3">
					<label for="validationServer01">Fim</label> <input
						type="datetime-local" class="form-control"
						value='<fmt:formatDate value="${activity.endTime.time}"
							pattern="dd/MM/yyyy hh:mm" />'
						id="id-descricao" name="time_end" placeholder="Tempo final"
						required>
					<div class="invalid-tooltip">Digite o fim</div>
				</div>

			</div>
	</div>
	<hr style="width: 100%;">
	<div style="text-align: -webkit-right;">
		<input type="submit" value="Salvar" class="btn btn-primary"> <a
			href="activity?action=list" class="btn btn-danger">Cancelar</a>
	</div>
	</form>
	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>