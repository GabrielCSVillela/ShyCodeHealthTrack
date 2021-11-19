<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="header.jsp"%>
<title>Cadastrar Refeição</title>
</head>
<%@ include file="menu.jsp"%>
<body>
	<div class="container">
		<h1>Cadastro de Produto</h1>
		<form action="produto" method="post">
			<div class="form-group">
				<label for="id-nome">Nome</label> <input type="text" name="nome"
					id="id-nome" class="form-control">
			</div>
			<div class="form-group">
				<label for="id-valor">Valor</label> <input type="text" name="valor"
					id="id-valor" class="form-control">
			</div>
			<div class="form-group">
				<label for="id-quantidade">Quantidade</label> <input type="text"
					name="quantidade" id="id-quantidade" class="form-control">
			</div>
			<div class="form-group">
				<label for="id-fabricacao">Data de Fabricação</label> <input
					type="text" name="fabricacao" id="id-fabricacao"
					class="form-control">
			</div>
			<input type="submit" value="Salvar" class="btn btn-primary">
		</form>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>