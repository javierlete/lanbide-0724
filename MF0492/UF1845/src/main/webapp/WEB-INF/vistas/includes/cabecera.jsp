<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- 
Importamos la biblioteca core de las bibliotecas de JSTL
Las bibliotecas de JSTL DEBEN estar en WEB-INF/lib
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Usuarios</title>

<base href="${pageContext.request.contextPath}/">
<%-- 
Base establece la base de las rutas RELATIVAS en lugar de utilizar la URL que visualiza el navegador.
Afecta a todas las URLs que aparezcan en la página (vínculos, imágenes...)
Cuidado porque es necesario utilizar la / del final después del contextPath 
--%>

<!-- CSS only -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- JavaScript Bundle with Popper -->
<script src="js/bootstrap.bundle.min.js"></script>
</head>
<body class="container">
	<nav class="navbar navbar-expand-lg bg-dark navbar-dark mb-3">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Mi superApp</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<%-- me-auto empuja a la derecha el siguiente bloque. Como si tuviéramos un muelle a la derecha de la capa --%>
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Principal</a></li>
					<c:if test="${sessionScope.usuario != null}">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-bs-toggle="dropdown" aria-expanded="false">
								Administración </a>
							<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
								<li><a class="dropdown-item" href="admin/reservas">Reservas</a></li>
								<li><a class="dropdown-item" href="admin/usuarios">Usuarios</a></li>

							</ul></li>
					</c:if>
					<li class="nav-item"><a class="nav-link" href="hacer-reserva">Hacer
							reserva</a></li>
				</ul>
				<span class="navbar-text"> ${sessionScope.usuario.email} </span>
				<ul class="navbar-nav mb-2 mb-lg-0">
					<c:choose>
						<c:when test="${sessionScope.usuario == null}">
							<li class="nav-item"><a class="nav-link" href="login">Login</a></li>
						</c:when>
						<c:otherwise>
							<li class="nav-item"><a class="nav-link" href="logout">Logout</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
	</nav>

	<c:if test="${alertatexto != null}">
		<div class="alert alert-${alertanivel} alert-dismissible fade show"
			role="alert">
			${alertatexto}
			<button type="button" class="btn-close" data-bs-dismiss="alert"
				aria-label="Close"></button>
		</div>
	</c:if>
	
	<main>