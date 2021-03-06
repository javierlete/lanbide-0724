<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<!-- 
<pre>
${reserva}
</pre>
-->
 
<form action="hacer-reserva" method="post" novalidate>
	<%-- <div class="row mb-3">
		<label for="id" class="col-sm-2 col-form-label">Id</label>
		<div class="col-sm-10">
			requestScope sólo toma los datos de request y no los busca en otro ámbito, como por ejemplo sesión
			<input type="number" class="form-control" id="id" name="id"
				value="${reserva.id}">
		</div>
	</div> --%>
	<div class="row mb-3">
		<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="nombre" name="nombre"
				value="${reserva.nombre}">
			<span class="text-danger">${reserva.errores.nombre}</span>
		</div>
	</div>
	<div class="row mb-3">
		<label for="email" class="col-sm-2 col-form-label">Email</label>
		<div class="col-sm-10">
			<input type="email" class="form-control" id="email" name="email"
				value="${reserva.email}">
			<span class="text-danger">${reserva.errores.email}</span>
		</div>
	</div>
	<div class="row mb-3">
		<label for="telefono" class="col-sm-2 col-form-label">Teléfono</label>
		<div class="col-sm-10">
			<input type="tel" class="form-control" id="telefono"
				name="telefono" value="${reserva.telefono}">
			<span class="text-danger">${reserva.errores.telefono}</span>
		</div>
	</div>
	<div class="row mb-3">
		<label for="fechaHora" class="col-sm-2 col-form-label">Fecha y Hora</label>
		<div class="col-sm-10">
			<input type="datetime-local" class="form-control" id="fechaHora"
				name="fechaHora" value="${reserva.fechaHora}">
			<span class="text-danger">${reserva.errores.fechaHora}</span>
		</div>
	</div>
	<div class="row mb-3">
		<label for="numeroPersonas" class="col-sm-2 col-form-label">Número de personas</label>
		<div class="col-sm-10">
			<input type="number" min="1" class="form-control" id="numeroPersonas"
				name="numeroPersonas" value="${reserva.numeroPersonas}">
			<span class="text-danger">${reserva.errores.numeroPersonas}</span>
		</div>
	</div>
	<div class="row mb-3">
		<label for="comentarios" class="col-sm-2 col-form-label">Comentarios</label>
		<div class="col-sm-10">
			<textarea class="form-control" id="comentarios"
				name="comentarios">${reserva.comentarios}</textarea>
			<span class="text-danger">${reserva.errores.comentarios}</span>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col-sm-10 offset-sm-2">
			<button type="submit" class="btn btn-primary">Guardar</button>
			<a class="btn btn-danger" href="">Cancelar</a>
		</div>
	</div>

</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>