<%-- 
VISTA de la aplicación
Cómo quiero que se vea la información recibida
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ipartek.formacion.servlets.modelos.Usuario,java.util.ArrayList"%>
<%-- 
Importamos la biblioteca core de las bibliotecas de JSTL
Las bibliotecas de JSTL DEBEN estar en WEB-INF/lib
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Usuarios</title>
</head>
<body>

<ul>
	<c:forEach items="${usuarios}" var="usuario">
		<li>
			<a href="usuario?id=${usuario.id}">${usuario}</a>
			
			<c:if test="${usuario.email.contains(usuario.password)}">
				Mejor cambiamos la contraseña, ¿eh?
			</c:if>
		</li>
	</c:forEach>
</ul>

</body>
</html>