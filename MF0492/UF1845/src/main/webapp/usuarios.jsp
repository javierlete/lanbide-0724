<%-- 
VISTA de la aplicación
Cómo quiero que se vea la información recibida
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ipartek.formacion.servlets.modelos.Usuario,java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	ArrayList<Usuario> usuarios = (ArrayList<Usuario>)request.getAttribute("usuarios");
%>

<ul>
	<% for(Usuario usuario: usuarios) {
	%>
		<li>
			<a href="usuario?id=<%=usuario.getId()%>"><%=usuario %></a>
		</li>
	<% } %>
</ul>

</body>
</html>