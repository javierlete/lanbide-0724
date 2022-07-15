package com.ipartek.formacion.mf0492.controladores;

import java.io.IOException;

import com.ipartek.formacion.mf0492.modelos.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final String LOGIN_JSP = Globales.VISTAS + "/login.jsp";
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(LOGIN_JSP).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");

		Usuario usuario = new Usuario();
		usuario.setNickname(nickname);
		usuario.setPassword(password);

		if (usuario.getErrores().size() > 0) {
			errorUsuario(request, response, usuario);
			return;
		}
		
		Usuario usuarioValidado = validarUsuario(usuario);
		
		if (usuarioValidado.getErrores().size() > 0) {
			errorUsuario(request, response, usuarioValidado);
			return;
		}
		
		request.getSession().setAttribute("usuario", usuarioValidado);
		
		response.sendRedirect("busqueda");
	}

	private void errorUsuario(HttpServletRequest request, HttpServletResponse response, Usuario usuario)
			throws ServletException, IOException {
		request.setAttribute("usuario", usuario);
		request.getRequestDispatcher(LOGIN_JSP).forward(request, response);
	}

	private Usuario validarUsuario(Usuario usuario) {
		Usuario validado = Globales.DAO_USUARIO.buscarPorNickname(usuario.getNickname());
		
		if(validado != null && validado.getPassword().equals(usuario.getPassword())) {
			return validado;
		}
		
		usuario.getErrores().put("autenticacion", "Usuario o contraseña incorrecta");
		
		return usuario;
	}

}
