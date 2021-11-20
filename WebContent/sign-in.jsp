<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<%@ include file ="header.jsp" %>
</head>
<body class="text-center signIn" data-new-gr-c-s-check-loaded="14.1039.0" data-gr-ext-installed="">
    <form class="form-signin ">
      <img class="mb-4" src="resources/images/logo.png" alt="" width="72" height="72">
      <h1 class="h3 mb-3 font-weight-normal">Faça Login</h1>
      <label for="inputEmail" class="sr-only">Endereço de Email</label>
      <input type="email" id="inputEmail" class="form-control" placeholder="Email" name="email" autofocus>
      <label for="inputPassword" class="sr-only">Senha</label>
      <input type="password" id="inputPassword" class="form-control" placeholder="Senha" name="password" >
      <div class="checkbox mb-3">
        <label>
          <input type="checkbox" value="remember-me"> Lembre-se de mim
        </label>
      </div>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
      <a class="btn btn-lg btn-secondary btn-block" href="create-account.jsp">Cria uma conta</a>
	</form>
 <%@ include file ="footer-sign-in.jsp" %>
</body>
</html>