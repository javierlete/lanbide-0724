<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Usuario</title>
</head>
<body>

<form>
	<input name="id" placeholder="Id">
	<input name="email" placeholder="Email">
	<input name="password" placeholder="Password">
	<button>Guardar cambios</button>
</form>

<%-- 
Siempre que utilicemos el prefijo c necesitamos
registrar la taglib mediante la directiva con el mismo nombre
 --%>
	<c:choose>
		<c:when test="${usuario != null}">

			<dl>
				<dt>Id</dt>
				<dd>${usuario.id}</dd>
				<dt>Email</dt>
				<dd>${usuario.email}</dd>
				<dt>Password</dt>
				<dd>${usuario.password}</dd>
			</dl>

		</c:when>
		<c:otherwise>
			<p>No se ha encontrado el usuario</p>
		</c:otherwise>
	</c:choose>
</body>
</html>