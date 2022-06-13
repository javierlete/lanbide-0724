package com.ipartek.formacion.servlets.controladores;

import java.io.IOException;

import com.ipartek.formacion.servlets.dal.DaoUsuarioMemoria;
import com.ipartek.formacion.servlets.modelos.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		Usuario usuario = DaoUsuarioMemoria.getInstancia().obtenerPorId(Long.parseLong(id));
		
		request.setAttribute("usuario", usuario);
		request.getRequestDispatcher("/WEB-INF/vistas/usuario.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
