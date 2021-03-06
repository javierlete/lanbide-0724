<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<form action="admin/usuario" method="post">
	<div class="row mb-3">
		<label for="id" class="col-sm-2 col-form-label">Id</label>
		<div class="col-sm-10"> <%-- requestScope sólo toma los datos de request y no los busca en otro ámbito, como por ejemplo sesión --%>
			<input type="number" class="form-control" id="id" name="id" value="${requestScope.usuario.id}">
		</div>
	</div>
	<div class="row mb-3">
		<label for="email" class="col-sm-2 col-form-label">Email</label>
		<div class="col-sm-10">
			<input type="email" class="form-control" id="email" name="email" value="${requestScope.usuario.email}">
		</div>
	</div>
	<div class="row mb-3">
		<label for="password" class="col-sm-2 col-form-label">Password</label>
		<div class="col-sm-10">
			<input type="password" class="form-control" id="password" name="password" value="${requestScope.usuario.password}">
		</div>
	</div>
	<div class="row mb-3">
		<div class="col-sm-10 offset-sm-2">
			<button type="submit" class="btn btn-primary">Guardar</button>
			<a class="btn btn-danger" href="admin/usuarios">Cancelar</a>
		</div>
	</div>
	
</form>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>