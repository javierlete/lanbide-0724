<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Búsqueda</title>
</head>
<body>

	<form action="busqueda" method="post">
		<input name="codigo-postal" placeholder="Código Postal">
		<button>Buscar código postal</button>
	</form>

	<c:if test="${areas.size() == 0}">
		<p>No se ha encontrado ningún resultado</p>
	</c:if>

	<ul>
		<c:forEach items="${areas}" var="area">
			<li>${area.municipio}</li>
		</c:forEach>
	</ul>

</body>
</html>