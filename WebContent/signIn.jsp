<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<%@ include file ="header.jsp" %>
</head>
<body class="text-center signIn" data-new-gr-c-s-check-loaded="14.1039.0" data-gr-ext-installed="">
    <form class="form-signin ">
      <img class="mb-4" src="resources/images/logo.png" alt="" width="72" height="72">
      <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
      <label for="inputEmail" class="sr-only">Email address</label>
      <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required="" autofocus="">
      <label for="inputPassword" class="sr-only">Password</label>
      <input type="password" id="inputPassword" class="form-control" placeholder="Password" required="">
      <div class="checkbox mb-3">
        <label>
          <input type="checkbox" value="remember-me"> Remember me
        </label>
      </div>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      <button class="btn btn-lg btn-secondary btn-block" type="submit">Create Account</button>

 <%@ include file ="footer.jsp" %>
</body>
</html>