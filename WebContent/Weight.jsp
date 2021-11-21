<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Weight</title>
<%@ include file="header.jsp"%>
</head>
<%@ include file="menu.jsp"%>
<body>

	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
				<div class="navbar-nav">
					<a class="nav-item nav-link active" href=weight?action=list>Listar</a> 
					<a class="nav-item nav-link" href="register-weight.jsp">Cadastrar</a>
				</div>
			</div>
		</nav>
	</div>

	<div style="width: 100%" class="list-restaurants">
		
		<table class="table table-striped">
			<tr>
				<th>Data e Hora</th>
				<th>Valor do Peso</th>
			</tr>
			<c:forEach items="${weights }" var="w">
				<tr>
					<td>
						<fmt:formatDate value="${w.dateMeasurement.time}" pattern="dd/MM/yyyy" />
					</td>
					<td>${w.value}</td>
					<td>	
						<c:url value="weight" var="link">
							<c:param name="action" value="open-form-update" />
							<c:param name="id" value="${w.id}" />
						</c:url> 
						<a href="${link}" class="btn btn-primary btn-xs">Editar</a>
						<button type="button" class="btn btn-danger btn-xs"
							data-toggle="modal" data-target="#excluirModal"
							onclick="codigoExcluir.value = ${w.id}">
							Excluir
						</button>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div class="footer-sub-pages"
		style="position: absolute; bottom: 0; width: 100%;">
		<%@ include file="footer.jsp"%>
	</div>
	
	<!-- Modal -->
	<div class="modal fade" id="excluirModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Confirmação</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">Deseja realmente excluir a pressão?</div>
				<div class="modal-footer">
					<form action="weight" method="post">
						<input type="hidden" name="action" value="delete"> <input
							type="hidden" name="id" id="codigoExcluir">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Cancelar</button>
						<button type="submit" class="btn btn-danger">Excluir</button>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>