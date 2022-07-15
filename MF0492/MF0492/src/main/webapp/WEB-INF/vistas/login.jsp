<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

<form action="login" method="post">
	<input type="text" name="nickname" placeholder="usuario">
	<p>${usuario.errores.nickname}</p>
	<input type="password" name="password">
	<p>${usuario.errores.password}</p>
	<button>Login</button>
	<p>${usuario.errores.autenticacion}</p>
</form>

</body>
</html>