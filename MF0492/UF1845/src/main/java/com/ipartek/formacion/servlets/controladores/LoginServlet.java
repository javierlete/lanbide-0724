package com.ipartek.formacion.servlets.controladores;

import java.io.IOException;

import com.ipartek.formacion.servlets.modelos.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final String LOGIN_JSP = "/WEB-INF/vistas/login.jsp";
	private static final long serialVersionUID = 1587748451045724579L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(LOGIN_JSP).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Usuario usuario = new Usuario(null, email, password);
		
		Usuario usuarioValidado = validarUsuario(usuario);
		
		if(usuarioValidado != null) {
			request.getSession().setAttribute("usuario", usuarioValidado);
			response.sendRedirect(request.getContextPath() + "/admin/usuarios");
		} else {
			request.setAttribute("alertatexto", "Email o contraseña incorrectos");
			request.setAttribute("alertanivel", "danger");
			request.setAttribute("usuario", usuario);
			request.getRequestDispatcher(LOGIN_JSP).forward(request, response);
		}
	}

	private Usuario validarUsuario(Usuario usuario) {
		Usuario usuarioEncontrado = Globales.DAO.obtenerPorEmail(usuario.getEmail());
		
		if(usuarioEncontrado != null && usuario.getPassword().equals(usuarioEncontrado.getPassword())) {
			return usuarioEncontrado;
		}
		
		return null;
	}

}
