<%-- 
VISTA de la aplicación
Cómo quiero que se vea la información recibida
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

	<table class="table table-hover table-striped table-bordered">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Email</th>
				<th>Teléfono</th>
				<th>Fecha y hora</th>
				<th>Número de personas</th>
				<th>Comentarios</th>
				<th>Opciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${reservas}" var="r">
				<tr>
					<th>${r.id}</th>
					<th>${r.nombre}</th>
					<td>${r.email}</td>
					<td>${r.telefono}</td>
					<td>${r.fechaHora}</td>
					<td>${r.numeroPersonas}</td>
					<td>${r.comentarios}</td>
					<td>
						<a class="btn btn-sm btn-primary" href="admin/reserva?id=${usuario.id}&op=editar">Editar</a>
						<a class="btn btn-sm btn-danger" href="admin/reserva?id=${usuario.id}&op=borrar">Borrar</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td>
					<a class="btn btn-sm btn-primary" href="hacer-reserva">Añadir</a>
				</td>
			</tr>
		</tfoot>
	</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>