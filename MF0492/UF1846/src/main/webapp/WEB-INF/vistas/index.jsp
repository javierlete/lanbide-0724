<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="row row-cols-1 row-cols-md-3 g-4">
	<c:forEach items="${peliculas}" var="p">
		<div class="col">
			<div class="card h-100">
				<img src="http://placeimg.com/640/360/any?id=${p.id}" class="card-img-top" alt="">
				<div class="card-body">
					<h5 class="card-title">${p.titulo}</h5>
				</div>
				<div class="card-footer">
					<small class="text-muted">${p.precio}</small>
				</div>
			</div>
		</div>
	</c:forEach>
</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>