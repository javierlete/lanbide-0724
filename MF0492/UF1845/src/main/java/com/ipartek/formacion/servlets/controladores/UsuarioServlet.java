package com.ipartek.formacion.servlets.controladores;

import java.io.IOException;

import com.ipartek.formacion.servlets.modelos.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/usuario")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");

		if (id != null) {
			Usuario usuario = Globales.DAO_USUARIO.obtenerPorId(Long.parseLong(id));
			request.setAttribute("usuario", usuario);
		}

		request.getRequestDispatcher("/WEB-INF/vistas/usuario.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Si los caracteres internacionales ñ, á...) salen corruptos
		// se necesita especificar la codificación de los datos de
		// entrada
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Usuario usuario = new Usuario(null, email, password);

		String op = "";

		try {
			if (id == null || id.trim().length() == 0) {
				op = "añadido";
				Globales.DAO_USUARIO.insertar(usuario);
			} else {
				op = "modificado";
				usuario.setId(Long.parseLong(id));
				Globales.DAO_USUARIO.modificar(usuario);
			}

			request.setAttribute("alertatexto", "Se ha " + op + " el registro correctamente");
			request.setAttribute("alertanivel", "success");
		} catch (Exception e) {
			request.setAttribute("alertatexto", "La opción de " + op + " no ha funcionado");
			request.setAttribute("alertanivel", "danger");
		}

//		request.setAttribute("usuarios", DAO.obtenerTodos());
//		request.getRequestDispatcher("/WEB-INF/vistas/usuarios.jsp").forward(request, response);
//		request.getRequestDispatcher("/usuarios").forward(request, response);

		// Pide al navegador que cargue una nueva URL como una nueva REQUEST
		// El dato que pasamos es la URL que va a cargar el navegador
//		response.sendRedirect("usuarios");
//		response.sendRedirect(request.getContextPath() + "/admin/usuarios");
		request.getRequestDispatcher("/admin/usuarios").forward(request, response);
	}

}
