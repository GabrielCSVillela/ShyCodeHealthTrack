<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<%@ include file="header.jsp"%>
</head>
<%@ include file="menu.jsp"%>
<body>

  <div class="container">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
              <div class="navbar-nav">
                <a class="nav-item nav-link active" href="#">Cadastrar <span class="sr-only">(current)</span></a>
                <a class="nav-item nav-link" href="#">Listar</a>
              </div>
            </div>
          </nav>
    </div>

	<div style="width: 100%" class="list-restaurants">
		<c:if test="${not empty msg }">
			<div class="alert alert-success">${msg}</div>
		</c:if>
		<c:if test="${not empty erro }">
			<div class="alert alert-danger">${erro}</div>
		</c:if>
		<table class="table table-striped">
			<tr>
				<th>Data e Hora</th>
				<th>Pressão Min.</th>
				<th>Pressão Max.</th>
			</tr>
			<c:forEach items="${restaurantes }" var="r">
				<tr>
					<td>${r.name}</td>
					<td>${r.minPrice}</td>
					<td>${r.CNPJ}</td>
					<td>${r.category.name}</td>
					<td><c:url value="cadastro" var="link">
							<c:param name="acao" value="abrir-form-edicao" />
							<c:param name="codigo" value="${r.idRestaurant}" />
						</c:url> <a href="${link}" class="btn btn-primary btn-xs">Editar</a>
						<button type="button" class="btn btn-danger btn-xs"
							data-toggle="modal" data-target="#excluirModal"
							onclick="codigoExcluir.value = ${r.idRestaurant}">
							Excluir</button></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>